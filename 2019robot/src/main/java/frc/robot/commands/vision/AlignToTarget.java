/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Constants;

public class AlignToTarget extends Command {
  private double prev, offset, turn, cameraWidth;

  public AlignToTarget() {
    requires(Robot.vision);
  }

  @Override
  protected void initialize() {
    prev = 0;
    offset = 0;
    turn = 0;
    cameraWidth = Constants.kCameraWidth;
  }

  @Override
  protected void execute() {
    double centerX = Robot.vision.getRightTapeX();
    if (centerX == 0) offset = 0;
    else offset = (cameraWidth/2)-centerX;

    turn = (offset * Constants.kTurnP) + (Constants.kTurnD * ((offset - prev) / Constants.kDT));
    prev = offset;

    Robot.drivetrain.setDriveMotors(-turn, turn);
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
