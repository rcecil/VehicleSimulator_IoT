/*
Copyright 2018 International Business Machines

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Author               : Roy R. Cecil
Email                : roy.cecil@pt.ibm.com
Date of Creation     : 21 Feb , 2018
Notes                :
        

Revision History     :

*/
package com.ibm.ts.demo;

import java.util.Random;

public class Driver implements Runnable{
	int id ;
	int vehicle_id ;
	RoadMap rm ;
	boolean bad = false ;
	Random rand = new Random(System.currentTimeMillis()) ;
	Publisher p = null ;
	
	public Publisher getP() {
		return p;
	}
	public void setP(Publisher p) {
		this.p = p;
	}
	public void setRoadMap(RoadMap rm) {
		this.rm = rm ;
	}
	public void drive() {
		Road cur_road = rm.getRandomRoad() ;
		float speed_limit = cur_road.getSpeed_limit() ;
		double x_a = cur_road.getX_a() ;
		double x_b = cur_road.getX_b() ;
		double y_a = cur_road.getY_a() ;
		double y_b = cur_road.getY_b() ;
		int steps  = 100 ;
		double x_step = ( x_b - x_a ) / 100 ;
		double y_step = ( y_b - y_a ) / 100 ;
		for(int i = 0 ; i < steps ; i++) {
			double velocity = 0 ;
			if (bad) {
				if(rand.nextInt(100)<200) {
					velocity = speed_limit + rand.nextInt(20) ;
				}
			} else {
				velocity = rand.nextInt((int)speed_limit) ;
			}
			java.time.LocalDateTime now = java.time.LocalDateTime.now();
			String message = " { \"d\" : { \"DriverId\" : " + id +
					" , \"Latitude\" : " +
					Double.toString(x_a + i * x_step) + 
					" , \"Longitude\" :  " + Double.toString(y_a + i * y_step)
					+ " , \"SpeedLimit\" :  " + (int)speed_limit + 
					" , \"Velocity\" :  " + velocity + 
					" , \"Year\" :  " + now.getYear() +
					" , \"Month\" :  " + now.getMonthValue() +
					" , \"Day\" :  " + now.getDayOfMonth() +
					" , \"Hour\" :  " + now.getHour() +
					" , \"Minute\" :  " + now.getMinute() +
					" , \"Second\" :  " + now.getSecond() +
					"} }";
			p.publish(message);
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
	
	public void rent() {
		System.out.println( Integer.toString(id) + " " +
				0 + " " + 0 + " " + 0 + " " + 0) ;
	}
	
	public void returnVehicle() {
		System.out.println( Integer.toString(id) + " " +
				1 + " " + 1 + " " + 1 + " " + 1) ;
	}
	
	public Driver(int id) {
		this.id = id ;
		if(rand.nextInt(100) < 200) bad = true ;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			//rent() ;
			drive() ;
			//returnVehicle() ;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
}
