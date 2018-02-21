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

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Sensor implements Publisher {
	String orgId        =  null ;
	String broker       =  null ;
	String clientId     =  null ;
    String userid       = "use-token-auth" ;
    String password     =  null ;
    MemoryPersistence persistence = new MemoryPersistence();
    MqttClient mqttClient = null;
	private String deviceClassName;
	private String devicePrefix;
    
	public Sensor(int id,String orgId,String deviceClassName , String devicePrefix,String token) {
		//this.clientId = clientId + Integer.toString(id);
		this.orgId = orgId ;
		this.deviceClassName = deviceClassName ;
		this.devicePrefix  = devicePrefix ;
		this.password = token ;
		this.broker = "tcp://" + this.orgId + ".messaging.internetofthings.ibmcloud.com:1883" ;
		this.clientId = "d:" + this.orgId + ":" + this.deviceClassName + ":" + this.devicePrefix + Integer.toString(id);
		
		try {
			mqttClient =  new MqttClient(broker, this.clientId, persistence);
			System.out.println( this.clientId );
		} catch (MqttException e) {
			 System.out.println("reason "+e.getReasonCode());
	         System.out.println("msg "+e.getMessage());
	         System.out.println("loc "+e.getLocalizedMessage());
	         System.out.println("cause "+e.getCause());
	         System.out.println("excep "+e);
			 e.printStackTrace();
		}
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setPassword(password.toCharArray());
        connOpts.setUserName(userid);
        System.out.println("Connecting to broker: "+broker);
        try {
        	mqttClient.connect(connOpts);
		} catch (MqttException e) {
			 System.out.println("reason "+e.getReasonCode());
	         System.out.println("msg "+e.getMessage());
	         System.out.println("loc "+e.getLocalizedMessage());
	         System.out.println("cause "+e.getCause());
	         System.out.println("excep "+e);
			 e.printStackTrace();
			 System.exit(-1);
		}
        System.out.println("Connected");
	}
	
	public void publish(String content) {
		String topic        = "iot-2/evt/pos/fmt/JSON";
        int qos             = 2;
        
        try {
            
           // System.out.println(content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            mqttClient.publish(topic, message);
 
        } catch(MqttException e) {
			 System.out.println("reason "+e.getReasonCode());
	         System.out.println("msg "+e.getMessage());
	         System.out.println("loc "+e.getLocalizedMessage());
	         System.out.println("cause "+e.getCause());
	         System.out.println("excep "+e);
			 e.printStackTrace();
        }
	}
	
	public void disconnect() {
		try {
			mqttClient.disconnect();
			System.out.println("Disconnected");
		} catch (MqttException e) {
			 System.out.println("reason "+e.getReasonCode());
	         System.out.println("msg "+e.getMessage());
	         System.out.println("loc "+e.getLocalizedMessage());
	         System.out.println("cause "+e.getCause());
	         System.out.println("excep "+e);
			 e.printStackTrace();
		}
	}
}
