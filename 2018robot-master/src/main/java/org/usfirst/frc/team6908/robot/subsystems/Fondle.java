package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.RobotConstants;
import org.usfirst.frc.team6908.robot.RobotMap;
import org.usfirst.frc.team6908.robot.commands.ElevatorVariableControl;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Fondle extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
       
    }
    
    public void fondleIn() {
    	RobotMap.rightFlywheel.set(RobotConstants.MAX_FLYWHEEL_THROTTLE_INTAKE); //Set intake spinning towards robot
   		RobotMap.leftFlywheel.set(RobotConstants.MIN_FLYWHEEL_THROTTLE_INTAKE);
    }
    
    public void fondleOut() {
    	RobotMap.rightFlywheel.set(RobotConstants.MIN_FLYWHEEL_THROTTLE_OUTTAKE);//Set intake spinning outward to push box out
   		RobotMap.leftFlywheel.set(RobotConstants.MAX_FLYWHEEL_THROTTLE_OUTTAKE);
    }
    
    public void stopFondle() { 	
    	RobotMap.leftFlywheel.set(0);//Stop intake
		RobotMap.rightFlywheel.set(0);
    	
    	
    }
   
    
   
}

