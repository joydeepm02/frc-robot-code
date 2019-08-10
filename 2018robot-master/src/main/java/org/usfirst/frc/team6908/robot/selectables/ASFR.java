package org.usfirst.frc.team6908.robot.selectables;

import org.usfirst.frc.team6908.robot.autocommands.ASFRLeft;
import org.usfirst.frc.team6908.robot.autocommands.ASFRRight;

import edu.wpi.first.wpilibj.command.Command;

public class ASFR extends Selectables {
	
	static Command Left = new ASFRLeft();
	static Command Right = new ASFRRight();
	
    public ASFR() {
        super(Left,Right, 1);
    }
}
