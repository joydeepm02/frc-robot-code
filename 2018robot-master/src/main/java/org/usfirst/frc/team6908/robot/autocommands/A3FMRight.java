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
//    	addSequential(new ServoRelease());
//    	addSequential(new WaitCommand(1.5)); 
    	//addSequential(new FondleInAuto());
    	addSequential(new AutoDrive(8));
    	addSequential(new WaitCommand(.5));
    	addParallel(new FondleCubeIn(), 1.5);
    	addSequential(new AutoTurn(35));
//    	addSequential(new FondleCubeIn(),.5);
//    	addParallel(new StaticHeightControl(RobotConstants.switchHeight));
    	addSequential(new AutoDrive(67));
//    	addSequential(new FondleCubeIn(), 0.5);
    	addSequential(new FondleCubeIn(),.2);
    	addParallel(new FondleCubeIn(), 1.5);
    	addSequential(new AutoTurn(-35));
//    	addSequential(new FondleCubeIn(),.2);
    	addSequential(new StaticHeightControl(RobotConstants.SWITCH_HEIGHT));
    	addSequential(new AutoDrive(3));
    	addSequential(new FondleCubeOut(),0.5);

//    	addSequential(new AutoDrive(7));
//    	addSequential(new WaitCommand(0.2));
//    	addSequential(new AutoTurn(42));
//    	addSequential(new AutoDrive(73));
//    	addSequential(new WaitCommand(0.2));
//    	addSequential(new AutoTurn(-42));
//    	addSequential(new AutoDrive(6));
//    	
    }
}
