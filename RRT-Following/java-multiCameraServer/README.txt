===================
Building on desktop
===================

Java 11 is required to build.  Set your path and/or JAVA_HOME environment
variable appropriately.

 --------
 Building
 --------
1) Open a session of terminal/powershell and navigate to this folder

2) Run "./gradlew build"

---------
Deploying
---------

1) Open the web dashboard of the Raspberry Pi 
    - In a browser, visit "frcvision.local/"

2) Click on the "Vision Status" tab on the left

3) Press the "Down" button

4) Press the "Writable" button on the top of the screen

5) Click on "Vision Settings" tab

6) Set "Team Number" to 6908

7) Click on "Camera rPi Camera 0"

8) Click on "Load Source Config from JSON File"

9) Navigate to "frc.json" in the Resources folder

10) Press "Save" on the bottom of the screen

11) Click on "Application"

12) In the "Application" dropdown, select "Uploaded Java jar"

13) Click on "Choose file" and navigate to /build/libs/java-multiCameraServer-all.jar

14) Click on "Save"

15) Click on the "Read-Only" button on the top of the screen

16) Go to the "Vision Status" tab

17) Press the blue "Up" button