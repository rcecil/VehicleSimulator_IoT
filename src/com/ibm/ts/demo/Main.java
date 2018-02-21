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

import java.util.ResourceBundle;
import java.util.Vector;

public class Main {
	public int max_drivers  = 2 ;
	public int max_vehicles = max_drivers ;
	public int numRoads  = 100 ;
	public int numCities = 100 ;
	public final static RoadMap rm = new RoadMap() ;
	Vector<Driver> renting = new Vector<Driver>() ;
	Vector<Driver> idle    = new Vector<Driver>() ;
	Vector<Vehicle> fleet = new Vector<Vehicle>() ;
	Rentals rentals = new Rentals(max_drivers) ;
	java.util.ResourceBundle rb = null ;
	private String orgId;
	private String deviceClassName;
	private String token;
	private String devicePrefix;
	
	/**
	   * Any properties in the properties file is used unless overridden by commandline arguments
	   *
	   */
	  private void readProperties() {
	    rb = ResourceBundle.getBundle("vsim");
	    if (rb == null) {
	      System.out.println("Failed to  read vsim.properties file, switching to defaults");
	      return;
	    }
	    if (rb.containsKey("numroads")) {
	    	try {
	    		int tmp  = Integer.parseInt(rb.getString("numroads"));
	    		numRoads = tmp ;
	    	}catch(Exception e) {}
	      
	    }
	    if (rb.containsKey("numcities")) {
	    	try {
	    		int tmp  = Integer.parseInt(rb.getString("numcities"));
	    		numCities = tmp ;
	    	}catch(Exception e) {}
		}
	    if (rb.containsKey("numdrivers")) {
	    	try {
	    		int tmp  = Integer.parseInt(rb.getString("numdrivers"));
	    		max_drivers = tmp ;
	    	}catch(Exception e) {}
		}
	    if (rb.containsKey("numvehicles")) {
	    	try {
	    		int tmp  = Integer.parseInt(rb.getString("numvehicles"));
	    		max_vehicles = tmp ;
	    	}catch(Exception e) {}
		}
	    if (rb.containsKey("orgid")) {
	    	orgId = rb.getString("orgid") ;
		}
	    if (rb.containsKey("deviceclassname")) {
	    	deviceClassName = rb.getString("deviceclassname") ;
		}
	    if (rb.containsKey("token")) {
	    	token = rb.getString("token") ;
		}
	    if (rb.containsKey("deviceprefix")) {
	    	devicePrefix = rb.getString("deviceprefix") ;
		}
	  }
	
	public void initialize() {
		this.readProperties(); 
		rm.initialize(100,200,39.8566887,40.5024815,-108.7825304,-104.7738939) ;
		for (int i = 0 ; i < max_drivers ; i++) {
			System.out.println("i = " + Integer.toString(i)) ;
			Sensor c  = new Sensor(i+1, orgId, deviceClassName, devicePrefix,token) ;
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
