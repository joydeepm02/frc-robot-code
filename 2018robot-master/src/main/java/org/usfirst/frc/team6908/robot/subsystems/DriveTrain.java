package org.usfirst.frc.team6908.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6908.robot.*;
import org.usfirst.frc.team6908.robot.commands.ArcadeDrive;
import org.usfirst.frc.team6908.robot.commands.Rotate;
/**
 *
 */
public class DriveTrain extends Subsystem {

	  double leftMtr, rightMtr;	
  
    public static SpeedControllerGroup rightMotors = new SpeedControllerGroup(RobotMap.frontRightT, RobotMap.backRightT);
    public static SpeedControllerGroup leftMotors = new SpeedControllerGroup(RobotMap.frontLeftT, RobotMap.backLeftT);
    public static AHRS gyro = RobotMap.gyro;
    public static Encoder rightEncoder = RobotMap.rightEncoder;
    public static Encoder leftEncoder = RobotMap.leftEncoder;
    
    public static Rotate turnit = new Rotate();
    
    public static PIDController rotater = new PIDController(0.023, .0, 0.001, gyro, turnit);
  
    public DriveTrain() {   	
    	rightMotors.setName("Right");
    	leftMotors.setName("Left");
    	
    	SmartDashboard.putData(gyro);
    	SmartDashboard.putData(leftEncoder);
    	SmartDashboard.putData(rightEncoder);
    	
    	gyro.setName("Gyro", "spin me");
    	
    }
    
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDrive());
		RobotMap.frontRightT.setInverted(true);
		RobotMap.backRightT.setInverted(true);		
	}
    
	public void setLeftMotors (double speed) {
		RobotMap.frontLeftT.set(speed);
		RobotMap.backLeftT.set(speed);
	}
	
	public void setRightMotors (double speed) {
		RobotMap.frontRightT.set(speed);
		RobotMap.backRightT.set(speed);
	}
	
	public void Drive(double throttle, double turn) {
		//Converts throttle and turn values into left and right tank drive values
		leftMtr = throttle + turn;
		rightMtr = throttle - turn;
		//Sets values to motors
		Robot.drivetrain.setLeftMotors(leftMtr);
		Robot.drivetrain.setRightMotors(rightMtr);	
    }
}
