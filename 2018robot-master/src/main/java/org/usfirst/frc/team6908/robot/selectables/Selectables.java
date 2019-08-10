package org.usfirst.frc.team6908.robot.selectables;

import org.usfirst.frc.team6908.robot.autocommands.*;
import org.usfirst.frc.team6908.robot.Robot;


import edu.wpi.first.wpilibj.command.Command;

public class Selectables extends Command {

	Command LeftCommand;
	Command RightCommand;
	String Data;
	int ss;
	
	public Selectables(Command LeftOption, Command RightOption, int SwitchorScale) {
		LeftCommand = LeftOption;
		RightCommand = RightOption;
		ss = SwitchorScale;
		
	}
	
	public void execute() {
		System.out.println("Data="+Robot.gameData);
		switch(Robot.gameData.charAt(ss)) {
		case 'L':
			LeftCommand.start();
			break;
		case 'R':
			RightCommand.start();
			break;
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
