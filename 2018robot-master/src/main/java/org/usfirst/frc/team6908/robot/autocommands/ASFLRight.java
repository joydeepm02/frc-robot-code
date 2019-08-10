package org.usfirst.frc.team6908.robot.autocommands;

import org.usfirst.frc.team6908.robot.commands.AutoDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ASFLRight extends CommandGroup {

	public ASFLRight() {
		addSequential(new AutoDrive(190));
	}

}
