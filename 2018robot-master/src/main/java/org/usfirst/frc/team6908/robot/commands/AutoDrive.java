package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	
	private static final double AUTO_DRIVE_CORRECT_COEFF = 0.1;
	private double distance;
	private double gyroAngle;
	private double driveAngle;
	private static final double speed = 0.8; //.5
	private static final double slowSpeed = 0.3; //.2

	public AutoDrive(double dist) {
		distance = ((dist / (6*Math.PI)) * 255);
		requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	DriveTrain.leftEncoder.reset();
    	DriveTrain.rightEncoder.reset();
    	DriveTrain.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gyroAngle = DriveTrain.gyro.getAngle();
		driveAngle = -gyroAngle * AUTO_DRIVE_CORRECT_COEFF;
		
		
		//System.out.println("Time (sec) = " + String.format("%.1f",currentPeriodSec) + " Angle =" + String.format("%.2f",driveAngle));
		if(distance - DriveTrain.rightEncoder.get() < .25 * distance) {
			Robot.drivetrain.Drive(-slowSpeed, driveAngle*AUTO_DRIVE_CORRECT_COEFF);
		}
		else if(distance - DriveTrain.rightEncoder.get() > .25 * distance) {
			Robot.drivetrain.Drive(-speed, driveAngle*AUTO_DRIVE_CORRECT_COEFF);
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (DriveTrain.rightEncoder.getDistance() >= distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.Drive(0.0, 0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
        
    }

}
