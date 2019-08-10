package org.usfirst.frc.team6908.robot;

public class RobotConstants {
		
	//Acceleration multipliers
	public static final double LOW_RANGE_TURN = .2;
	public static final double HIGH_RANGE_TURN = 1;
	public static final double LOW_RANGE_THROTTLE = .4;
	public static final double HIGH_RANGE_THROTTLE = 1;
	//Elevator
	public static final double ELEVATOR_EXTEND_SPEED = .8;
	public static final double JOYSTICK_DEADZONE = .1;
	public static final double ELEVATOR_P = -.011;
	public static final double ELEVATOR_I = 0;
	public static final double ELEVATOR_D = 0;
	public static final int ELEVATOR_TOLERANCE = 5;
	public static final int BASE_HEIGHT = 0;
	public static final double SWITCH_HEIGHT = -10000;
	public static final double SCALE_HEIGHT = -23500;
	//Intake
	public static final double MAX_FLYWHEEL_THROTTLE_OUTTAKE = .6;//Speed for outwards push
	public static final double MIN_FLYWHEEL_THROTTLE_OUTTAKE = -.6;
	public static final double MIN_FLYWHEEL_THROTTLE_INTAKE = -1;//Speed for inwards pull
	public static final double MAX_FLYWHEEL_THROTTLE_INTAKE = 1;
	//Winch speed constant
	public static final double WINCH_SPEED = 1;
	//Ramp Drop motor speed constant
	public static final int RAMP_FONDLE_DOWN_SPEED = -1;
	public static final int RAMP_FONDLE_UP_SPEED = 1;
	
	public static final int MIN_AXIS = -1;
	public static final int MAX_AXIS = 1;


	//RoboRIO ports
		//Drivetrain CAN
		public static final int FRONT_LEFT_TALON= 1;
		public static final int FRONT_RIGHT_TALON = 2;
		public static final int BACK_LEFT_TALON = 0;
		public static final int BACK_RIGHT_TALON = 3;
		//Elevator
		public static final int ELEVATOR_VICTOR = 1;
		public static final int ELEVATOR_ANGLE_VICTOR = 7;
		public static final int BOT_ELEVATOR_LIMIT = 9; //DIO
		public static final int TOP_ELEVATOR_LIMIT = 8; //DIO
		//Intake PWM
		public static final int LEFT_FLYWHEEL_SPARK= 4;
		public static final int RIGHT_FLYWHEEL_SPARK = 9;
		//Ramp PWM
		public static final int RIGHT_RAMP_SPARK = 3;
		public static final int LEFT_RAMP_SPARK = 2;
		public static final int RAMP_DROP_VICTOR = 0;
	
	//Joystick Button ports
	public static final int JOYSTICK1_PORT = 0;
	public static final int JOYSTICK2_PORT = 1;
	public static final int TRIGGER = 1;
	public static final int THUMB_BUTTON = 2;
	public static final int BUTTON3 = 3;
	public static final int BUTTON4 = 4;
	public static final int BUTTON5 = 5;
	public static final int BUTTON6 = 6;
	public static final int BUTTON7 = 7;
	public static final int BUTTON8 = 8;
	public static final int BUTTON9 = 9;
	public static final int BUTTON10 = 10;
	public static final int BUTTON11 = 11;
	public static final int BUTTON12 = 12;
	public static final int BUTTON13 = 13;

}
