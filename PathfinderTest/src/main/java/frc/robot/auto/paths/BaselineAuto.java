/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auto.paths;

import java.io.File;

import edu.wpi.first.wpilibj.command.CommandGroup;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import frc.robot.auto.commands.AutoDrive;

public class BaselineAuto extends CommandGroup {
    /**
     * Robot drives 10 feet past baseline
     */
    public BaselineAuto() {
        System.out.println("BaselineAuto started");

        Trajectory l = Pathfinder.readFromCSV(new File("/home/lvuser/paths/FasterBaseline_left.csv"));
        Trajectory r = Pathfinder.readFromCSV(new File("/home/lvuser/paths/FasterBaseline_right.csv"));
        
        addSequential(
            new AutoDrive(l, r)
        );
        System.out.println("BaselineAuto finished");
    }
}
