package org.usfirst.frc.team6908.robot.autocommands;

import org.usfirst.frc.team6908.robot.RobotConstants; 
import org.usfirst.frc.team6908.robot.commands.AutoDrive;
import org.usfirst.frc.team6908.robot.commands.AutoTurn;
import org.usfirst.frc.team6908.robot.commands.FondleCubeIn;
import org.usfirst.frc.team6908.robot.commands.FondleCubeOut;
import org.usfirst.frc.team6908.robot.commands.StaticHeightControl;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class A3FMLeft extends CommandGroup {

    public A3FMLeft() {
    	addSequential(new AutoDrive(20));
    	addSequential(new WaitCommand(0.5));
    	addParallel(new FondleCubeIn(), 1.5);
    	addSequential(new AutoTurn(-38));
    	addSequential(new AutoDrive(70));
    	addParallel(new FondleCubeIn(), 1.5);
    	addSequential(new AutoTurn(38));
    	addSequential((new StaticHeightControl(RobotConstants.SWITCH_HEIGHT)));
    	addSequential(new AutoDrive(5));
    	addSequential(new FondleCubeOut(), 1.5);
    }
}
