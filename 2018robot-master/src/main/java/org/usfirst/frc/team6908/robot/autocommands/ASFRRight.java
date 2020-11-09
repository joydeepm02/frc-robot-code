package org.usfirst.frc.team6908.robot.autocommands;

import org.usfirst.frc.team6908.robot.commands.*;
import org.usfirst.frc.team6908.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class ASFRRight extends CommandGroup {

    public ASFRRight() {
    	addSequential(new AutoDrive(190));
    	addSequential(new AutoTurn(-30));
    	addSequential(new StaticHeightControl(RobotConstants.SCALE_HEIGHT));
    	addSequential(new FondleCubeOut(),1.5);
    }
}
