package org.usfirst.frc.team6908.robot.commands;

import edu.wpi.first.wpilibj.command.Command; 
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.RobotMap;


public class StaticHeightControl extends Command {
	
	private static double distance;
	
	public StaticHeightControl(double dist) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.elevator);
 		distance = dist;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.elevator.ePID.reset();
		Robot.elevator.ePID.enable();
		Robot.elevator.ePID.setAbsoluteTolerance(5);
		Robot.elevator.ePID.setOutputRange(-.5, .5);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.elevator.ePID.setSetpoint(distance);
		SmartDashboard.putNumber("Encoder", RobotMap.elevatorEncoder.getDistance());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		if(Robot.elevator.ePID.get()>0) {
			return(Robot.elevator.ePID.onTarget() || Robot.elevator.isAtTop());
		}
		else if(Robot.elevator.ePID.get()<0) {
			return(Robot.elevator.ePID.onTarget() || Robot.elevator.isAtBottom());
		}
		else {
			return false;
		}
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.elevator.ePID.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
