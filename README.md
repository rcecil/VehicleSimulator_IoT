# VehicleSimulator_IoT

1. Ensure that you have a JDK installed and the JAVA_HOME path is set correctly to your JDK Home Directory.

2. Ensure that you have Apache Ant installed
   http://mirrors.up.pt/pub/apache//ant/binaries/apache-ant-1.10.2-bin.zip
   
3. Download the VehicleSimulator_IoT to your local directory.

4. Edit src/vsim.properties file to set the following properties correctly to point to IBM Watson IoT Platform
    numroads
    numcities
    numdrivers
    debug
    numvehicles
    orgid
    deviceclassname
    deviceprefix
    accesstoken
    
5. Build the application
    ant clean
    ant
    
6. Run the application
    cd dist 
    java -jar vsim.jar
