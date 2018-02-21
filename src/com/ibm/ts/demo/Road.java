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

public class Road {
	public double getX_a() {
		return x_a;
	}
	public void setX_a(double x_a) {
		this.x_a = x_a;
	}

	public double getY_a() {
		return y_a;
	}

	public void setY_a(double y_a) {
		this.y_a = y_a;
	}

	public double getX_b() {
		return x_b;
	}

	public void setX_b(double x_b) {
		this.x_b = x_b;
	}

	public double getY_b() {
		return y_b;
	}

	public void setY_b(double y_b) {
		this.y_b = y_b;
	}

	public Road(int id , double x_a,double y_a,double x_b , double y_b) {
		this.x_a = x_a ;
		this.y_a = y_a ;
		this.x_b = x_b ;
		this.y_a = y_b ;
	}
	
	public float getSpeed_limit() {
		return speed_limit;
	}
	public void setSpeed_limit(float speed_limit) {
		this.speed_limit = speed_limit;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void print() {
		System.out.println("Road connects latitude : " + Double.toString(this.x_a) + 
				"longitude : " + Double.toString(this.y_a) + " with latitude : " +
				Double.toString(this.x_b) + "longitude : " + Double.toString(this.y_b)) ;
	}
	
	double x_a ;
	double y_a ;
	double x_b ;
	double y_b ;
	int 	id ;
	float speed_limit = 0 ;
	
}
