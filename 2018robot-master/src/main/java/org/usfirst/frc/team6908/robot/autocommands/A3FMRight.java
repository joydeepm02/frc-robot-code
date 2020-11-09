package org.usfirst.frc.team6908.robot.autocommands;

import org.usfirst.frc.team6908.robot.RobotConstants;
import org.usfirst.frc.team6908.robot.commands.*;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class A3FMRight extends CommandGroup {

    public A3FMRight() {
    	addSequential(new AutoDrive(8));
    	addSequential(new WaitCommand(.5));
    	addParallel(new FondleCubeIn(), 1.5);
    	addSequential(new AutoTurn(35));
    	addSequential(new AutoDrive(67));
    	addSequential(new FondleCubeIn(),.2);
    	addParallel(new FondleCubeIn(), 1.5);
    	addSequential(new AutoTurn(-35));
    	addSequential(new StaticHeightControl(RobotConstants.SWITCH_HEIGHT));
    	addSequential(new AutoDrive(3));
    	addSequential(new FondleCubeOut(),0.5);
    }
}
