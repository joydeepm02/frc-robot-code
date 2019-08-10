package org.usfirst.frc.team6908.robot.subsystems;

import org.usfirst.frc.team6908.robot.Robot; 
import org.usfirst.frc.team6908.robot.RobotConstants;


import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampFondler extends Subsystem {
	
	SpeedController motor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public RampFondler(SpeedController controller, double speed) {
		motor = controller;
		controller.set(speed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
        
//	public void FondleUpRamps() {
//		motor.set(RobotConstants.RAMPS_UP_SPEED);
//	}
//	
//	public void FondleDownRamps() {
//		motor.set(RobotConstants.RAMPS_DOWN_SPEED);
//	}
	
    public void start(double speed) {
    	motor.set(speed);
    }
    
	public void StopRampFondling(){
		motor.set(0.0);
	}
	
}

