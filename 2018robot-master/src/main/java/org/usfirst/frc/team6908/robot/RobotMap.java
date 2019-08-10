package org.usfirst.frc.team6908.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;  
import edu.wpi.first.wpilibj.VictorSP;

//import com.kauailabs.navx.frc.AHRS;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//Drivetrain
	public static WPI_TalonSRX frontLeftT = new WPI_TalonSRX(RobotConstants.FRONT_LEFT_TALON);
	public static WPI_TalonSRX frontRightT = new WPI_TalonSRX(RobotConstants.FRONT_RIGHT_TALON);
	public static WPI_TalonSRX backLeftT = new WPI_TalonSRX(RobotConstants.BACK_LEFT_TALON);
	public static WPI_TalonSRX backRightT = new WPI_TalonSRX(RobotConstants.BACK_RIGHT_TALON);  
	public static AHRS gyro = new AHRS(Port.kMXP);
	public static Encoder rightEncoder = new Encoder(10,11);
	public static Encoder leftEncoder = new Encoder(12,13);

	//Elevator
	public static VictorSP elevator = new VictorSP(RobotConstants.ELEVATOR_VICTOR);
	public static Encoder elevatorEncoder = new Encoder(4, 5);
	public static DigitalInput botElevatorLimit = new DigitalInput(9);
	public static DigitalInput topElevatorLimit = new DigitalInput(8);
  
	//Intake
	public static Spark leftFlywheel = new Spark(RobotConstants.LEFT_FLYWHEEL_SPARK);
	public static Spark rightFlywheel = new Spark(RobotConstants.RIGHT_FLYWHEEL_SPARK);
	public static VictorSP fondleAngler = new VictorSP(RobotConstants.ELEVATOR_ANGLE_VICTOR);
	  
	//Ramp Winch Motor Controllers
	public static Spark leftRamp = new Spark(RobotConstants.LEFT_RAMP_SPARK);
	public static Spark rightRamp = new Spark(RobotConstants.RIGHT_RAMP_SPARK);
	
	//Ramp Drop Motor Controllers
	public static VictorSP rampDropController = new VictorSP(RobotConstants.RAMP_DROP_VICTOR);
	
	//Ramp Limit Switches
	public static DigitalInput LeftRampLimit = new DigitalInput(7);
	public static DigitalInput RightRampLimit = new DigitalInput(6);
	

}