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

import java.util.Vector;

public class Main {
	public final int max_drivers  = 2 ;
	public final int max_vehicles = max_drivers ;
	public final static RoadMap rm = new RoadMap() ;
	Vector<Driver> renting = new Vector<Driver>() ;
	Vector<Driver> idle    = new Vector<Driver>() ;
	Vector<Vehicle> fleet = new Vector<Vehicle>() ;
	Rentals rentals = new Rentals(max_drivers) ;
	
	public void initialize() {
		rm.initialize(100,200,39.8566887,40.5024815,-108.7825304,-104.7738939) ;
		for (int i = 0 ; i < max_drivers ; i++) {
			Sensor c  = new Sensor(i+1) ;
			Driver d = new Driver(i) ;
			d.setRoadMap(rm);
			d.setP(c);
			idle.add(d);
			fleet.add(new Vehicle(i));
			rentals.execute(d);
		}
	}
	public static void main(String[] args) {
		Main m = new Main() ;
		m.initialize(); 
	}

}
