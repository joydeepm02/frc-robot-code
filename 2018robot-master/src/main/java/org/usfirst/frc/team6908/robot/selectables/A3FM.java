package org.usfirst.frc.team6908.robot.selectables;

import org.usfirst.frc.team6908.robot.autocommands.A3FMLeft;
import org.usfirst.frc.team6908.robot.autocommands.A3FMRight;

import edu.wpi.first.wpilibj.command.Command;

public class A3FM extends Selectables {
	static Command Left = new A3FMLeft();
	static Command Right = new A3FMRight();
	
	public A3FM() { 
		super(Left, Right, 0);
	}
}
