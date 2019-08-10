/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.cargointake.IntakeCargo;
import frc.robot.commands.climber.DeployClimber;
import frc.robot.commands.climber.RetractClimber;
import frc.robot.commands.drivetrain.FlipDrivetrain;
import frc.robot.commands.hatchintake.IntakeHatch;
import frc.robot.commands.vision.AlignToTarget;
import frc.robot.commands.vision.DriveToTarget;

public class OI {
  public Joystick
    driveStick = new Joystick(Constants.kDriveStickPort);
  
  public XboxController
    operatorController = new XboxController(Constants.kOperatorControllerPort);

  public Button
    intakeCargo = new JoystickButton(driveStick, Constants.kIntakeCargoButton),
    intakeHatch = new JoystickButton(driveStick, Constants.kIntakeHatchButton),
    alignToTarget = new JoystickButton(driveStick, Constants.kAlignToTargetButton),
    driveToTarget = new JoystickButton(driveStick, Constants.kDriveToTargetButton),
    deployClimber = new JoystickButton(driveStick, Constants.kDeployClimberButton),
    retractClimber = new JoystickButton(driveStick, Constants.kRetractClimberButton),
    autoDeployClimber = new JoystickButton(driveStick, Constants.kAutoDeployClimberButton),
    autoRetractClimber = new JoystickButton(driveStick, Constants.kAutoRetractClimberButton),
    flipDrivetrain = new JoystickButton(driveStick, Constants.kDrivetrainFlipperButton);
    
    public OI() {
      intakeCargo.whileHeld(new IntakeCargo());
      intakeHatch.whileHeld(new IntakeHatch());
      alignToTarget.whileHeld(new AlignToTarget());
      deployClimber.whileHeld(new DeployClimber());
      retractClimber.whileHeld(new RetractClimber());
      driveToTarget.whileHeld(new DriveToTarget());
      flipDrivetrain.whenPressed(new FlipDrivetrain());
      /*
      autoDeployClimber.whenPressed(new AutoDeployClimber());
      autoRetractClimber.whenPressed(new AutoRetractClimber());
      */
    }
}
