package org.usfirst.frc.team6908.robot.autocommands;

import org.usfirst.frc.team6908.robot.commands.*;
import org.usfirst.frc.team6908.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 */
public class ASFRRight extends CommandGroup {

    public ASFRRight() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
//    	addSequential(new AutoDrive(8));
//    	addSequential(new TurnRobot(17));
//    	addSequential(new AutoDrive(63));
//    	addSequential(new TurnRobot(-17));
//    	addSequential(new AutoDrive(201));
//    	addSequential(new AutoTurn(-25));
//    	addSequential(new AutoDrive(12));
    	addSequential(new AutoDrive(190));
    	addSequential(new AutoTurn(-30));
    	addSequential(new StaticHeightControl(RobotConstants.SCALE_HEIGHT));
    	addSequential(new FondleCubeOut(),1.5);
    }
}
