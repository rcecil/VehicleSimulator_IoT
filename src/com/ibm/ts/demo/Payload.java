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

public class Payload {
	int DriverId ;
	double Latitude ;
	double Longitude ;
	float SpeedLimit ;
	double Velocity ;
	int Year ;
	int Month ;
	int Day ;
	int Hour ;
	int Minute ;
	int Second ;
	public Payload(int DriverId,double Latitude,double Longitude,float SpeedLimit,
			double Velocity) {
		this.DriverId = DriverId ;
		this.Latitude = Latitude ;
		this.Longitude = Longitude ;
		this.SpeedLimit = SpeedLimit ;
		this.Velocity = Velocity ;
		java.time.LocalDateTime now = java.time.LocalDateTime.now();
		this.Year = now.getYear() ;
		this.Month = now.getMonthValue() ;
		this.Day = now.getDayOfMonth() ;
		this.Hour = now.getHour() ;
		this.Minute = now.getMinute() ;
		this.Second = now.getSecond() ;
		
	}
}
