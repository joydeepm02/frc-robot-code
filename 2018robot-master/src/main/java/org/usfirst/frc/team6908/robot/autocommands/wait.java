package org.usfirst.frc.team6908.robot.autocommands;

import org.usfirst.frc.team6908.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class wait extends CommandGroup {

    public wait() {
    	addSequential(new WaitCommand(15));
    
}
