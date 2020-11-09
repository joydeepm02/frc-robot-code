package org.usfirst.frc.team6908.robot.autocommands;

import org.usfirst.frc.team6908.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ASFRLeft extends CommandGroup {

    public ASFRLeft() {
    	addSequential(new AutoDrive(190));
    }
}
