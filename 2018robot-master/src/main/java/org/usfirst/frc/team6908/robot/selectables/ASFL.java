package org.usfirst.frc.team6908.robot.selectables;

import org.usfirst.frc.team6908.robot.autocommands.ASFLLeft;
import org.usfirst.frc.team6908.robot.autocommands.ASFLRight;

import edu.wpi.first.wpilibj.command.Command;

public class ASFL extends Selectables {

	static Command Left = new ASFLLeft();
	static Command Right = new ASFLRight();
	
    public ASFL() {
        super(Left,Right, 1);
    }

}
