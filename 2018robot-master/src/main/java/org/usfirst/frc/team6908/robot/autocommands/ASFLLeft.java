package org.usfirst.frc.team6908.robot.autocommands;

import org.usfirst.frc.team6908.robot.RobotConstants;
import org.usfirst.frc.team6908.robot.commands.AutoDrive;
import org.usfirst.frc.team6908.robot.commands.AutoTurn;
import org.usfirst.frc.team6908.robot.commands.FondleCubeOut;
import org.usfirst.frc.team6908.robot.commands.StaticHeightControl;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ASFLLeft extends CommandGroup {
	
	public ASFLLeft(){
		addSequential(new AutoDrive(190));
		addSequential(new AutoTurn(30));
		addSequential(new StaticHeightControl(RobotConstants.SCALE_HEIGHT));
		addSequential(new FondleCubeOut(),1.5);
	}
	

}
