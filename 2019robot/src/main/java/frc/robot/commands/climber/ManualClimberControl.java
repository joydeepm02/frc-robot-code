/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.climber;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ManualClimberControl extends Command {
  public ManualClimberControl() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    
    double climberLiftVoltage = -0.8 * Robot.oi.operatorController.getY(Hand.kLeft);
    double climberWheelVoltage = -1 * Robot.oi.operatorController.getY(Hand.kRight);

    // Robot.climber.setLiftMotor(climberLiftVoltage);
    // Robot.climber.setWheelMotor(climberWheelVoltage);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
