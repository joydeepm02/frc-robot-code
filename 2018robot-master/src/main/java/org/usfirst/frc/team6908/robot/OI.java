package org.usfirst.frc.team6908.robot;

import edu.wpi.first.wpilibj.Joystick; 
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team6908.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */ 
public class OI {	
	public Joystick Joystick1;
	public Joystick Joystick2;

	public static Button fondleIn;
	public static Button fondleOut;
	public static Button leftFlapUp;
	public static Button leftFlapDown;
	public static Button rightFlapUp;
	public static Button rightFlapDown;	
	public static Button restrainRamps;
	public static Button releaseRamps;
	
	public OI() {
		Joystick1 = new Joystick(RobotConstants.JOYSTICK1_PORT);
		Joystick2 = new Joystick(RobotConstants.JOYSTICK2_PORT);	
		//Intake
		fondleIn = new JoystickButton(Joystick1, RobotConstants.TRIGGER);
		fondleOut = new JoystickButton(Joystick2,RobotConstants.TRIGGER);
		fondleIn.whileHeld(new FondleCubeIn());
		fondleOut.whileHeld(new FondleCubeOut());
		//Ramp fondle buttons
		restrainRamps = new JoystickButton(Joystick1, RobotConstants.BUTTON7);
		releaseRamps = new JoystickButton(Joystick1, RobotConstants.BUTTON8);
		restrainRamps.whileHeld(new FondleUpRamps());
		releaseRamps.whileHeld(new FondleDownRamps());
		//Ramp deploy buttons
		rightFlapUp = new JoystickButton(Joystick1, RobotConstants.BUTTON9);
		rightFlapDown = new JoystickButton(Joystick1, RobotConstants.BUTTON10);
		leftFlapUp = new JoystickButton(Joystick1, RobotConstants.BUTTON11);
		leftFlapDown = new JoystickButton(Joystick1, RobotConstants.BUTTON12);
		leftFlapUp.whileHeld(new RaiseLeftRamp());
		leftFlapDown.whileHeld(new LowerLeftRamp());
		rightFlapUp.whileHeld(new RaiseRightRamp());
		rightFlapDown.whileHeld(new LowerRightRamp());		
	}	
}
