package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.*;


import edu.wpi.first.wpilibj.command.Command;


/**
 *
 */
public class FondleCubeIn extends Command {

    public FondleCubeIn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	 requires(Robot.fondle);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Checks if button 3 is being held to determine direction of motor spin
   
    		//Button 3 is held, flywheels spin to output
    		Robot.fondle.fondleIn();
    	} 
   
   
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.fondle.stopFondle();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    		end();
    }
}
