package org.usfirst.frc.team6908.robot.commands;

import org.usfirst.frc.team6908.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LowerLeftRamp extends Command {

	public LowerLeftRamp() {
		requires(Robot.leftRamp);
	}

	//Nothing needs to happen here
	@Override
	protected void initialize() {
		
	}

	//Turns on winch
	@Override
	protected void execute() {
		Robot.leftRamp.ReelOutWinch();
	}

	//Command does not finished unless interrupted
	@Override
	protected boolean isFinished() {
		return !Robot.leftRamp.isUp();
	}

	//When the command is over, set the winch back to 0
	@Override
	protected void end() {
		Robot.leftRamp.StopReeling();
	}

	//When the command is interrupted, end it
	@Override
	protected void interrupted() {
		end();
	}
}
