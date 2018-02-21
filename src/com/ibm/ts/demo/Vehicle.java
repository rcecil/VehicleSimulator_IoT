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

public class Vehicle {
	
	public Vehicle(int id) {
		this.id = id ;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public int getRoad() {
		return road;
	}
	public void setRoad(int road) {
		this.road = road;
	}
	public int getHeading() {
		return heading;
	}
	public void setHeading(int heading) {
		this.heading = heading;
	}
	public float getRate_x() {
		return rate_x;
	}
	public void setRate_x(float rate_x) {
		this.rate_x = rate_x;
	}
	public float getRate_y() {
		return rate_y;
	}
	public void setRate_y(float rate_y) {
		this.rate_y = rate_y;
	}
	public int getDriver() {
		return driver;
	}
	public void setDriver(int driver) {
		this.driver = driver;
	}
	int id ;
	float speed = 0 ;
	int road  ;
	int heading ;
	float rate_x ;
	float rate_y ;
	int driver = 0 ;
	
}
