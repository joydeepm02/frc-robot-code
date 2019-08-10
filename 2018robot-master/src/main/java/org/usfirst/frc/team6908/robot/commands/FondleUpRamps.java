package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.OI;
import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.RobotConstants;
import org.usfirst.frc.team6908.robot.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FondleUpRamps extends Command {
	
    public FondleUpRamps() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.rampFondler);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.rampFondler.start(RobotConstants.RAMP_FONDLE_UP_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.rampFondler.StopRampFondling();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
