package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;

import edu.wpi.first.wpilibj.PIDOutput;

public class Rotate implements PIDOutput {

	@Override
	public void pidWrite(double output) {
		Robot.drivetrain.Drive(0, output-.002);

	}

}
