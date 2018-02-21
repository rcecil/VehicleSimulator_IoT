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
import java.util.Vector; 

public class RoadMap {
	int num_places      = 100 ;
	int num_roads = 200 ;
	Random rand = new Random(System.currentTimeMillis()) ;
	int[] speedLimits = {10,20,30,40,50,60,80,90,100,120} ;
	Vector<Point> Places = new Vector<Point>();
	Vector<Road>  Roads  = new Vector<Road>() ;
	double xmin ;
	double xmax ;
	double ymin ;
	double ymax ;
	
	public void initialize(int num_places,int num_roads,
			double xmin, double xmax , double ymin, double ymax) {
		
		int xrand  ;
		int yrand  ;
		double X , Y ;
		for(int i = 0 ; i < num_places ; i++) {
			xrand = rand.nextInt(100) ;
			yrand = rand.nextInt(100) ;
			X = xmin + ( (xmax - xmin) * xrand / 100.0 ) ;
			Y = ymin + ( (ymax - ymin) * yrand / 100.0 ) ;
			Places.add(new Point(X,Y)) ;
		}
		int i = 0 ;
		int start = rand.nextInt(num_places) ;
		int limits = speedLimits.length ;
		do{
			int end   = rand.nextInt(num_places) ;
			if( start != end ) {
				Point s = Places.get(start) ;				
				Point e = Places.get(end) ;
				Road r = new Road(++i,s.getX(),s.getY(),e.getX(),e.getY()) ;
				r.setSpeed_limit(speedLimits[rand.nextInt(speedLimits.length)]);
				Roads.add(r) ;
				start = end ;
			}
		}while(i != num_roads) ;
	}
	
	public Road getRandomRoad() {
		return Roads.get(rand.nextInt(num_roads)) ;
	}
	public void printPlaces() {
		for (Point place : Places) {
			place.print();
		}
	}
	
	public void printRoads() {
		for ( Road road : Roads) {
			road.print() ;
		}
	}
}
