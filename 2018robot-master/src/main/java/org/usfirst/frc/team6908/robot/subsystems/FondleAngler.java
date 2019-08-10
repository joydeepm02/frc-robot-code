package org.usfirst.frc.team6908.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6908.robot.RobotMap;

public class FondleAngler extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}
	
	public void fondleAngleUp() {
		RobotMap.fondleAngler.set(0.7);
		
	}
	public void fondleAngleDown() {
		RobotMap.fondleAngler.set(-0.7);
	}
}
