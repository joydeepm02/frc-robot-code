package org.usfirst.frc.team6908.robot.autocommands;

import org.usfirst.frc.team6908.robot.RobotConstants;
import org.usfirst.frc.team6908.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BaselineDrive extends CommandGroup {

    public BaselineDrive() {
    	addSequential(new AutoDrive(120));
    }
}
