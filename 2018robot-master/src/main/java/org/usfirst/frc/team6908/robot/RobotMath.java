package org.usfirst.frc.team6908.robot;

public class RobotMath {

	public static double normalize(double min, double max, double a, double b, double x) {
		return (((b-a)*(x-min))/(max-min))+a;
	}
	
	
	
}
