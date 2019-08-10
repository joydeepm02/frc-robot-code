/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.util.RobotMath;

public class ArcadeDrive extends Command {

  double speed, finalLeftSpeed, finalRightSpeed;

  public ArcadeDrive() {
    requires(Robot.drivetrain);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if(Math.abs(Robot.oi.driveStick.getY()) > 0.08) {
      speed = -Robot.oi.driveStick.getY();
    }
    else {
      speed = 0;
    }
    double acceleration = Robot.oi.driveStick.getThrottle();
    double throttleAcc = RobotMath.normalize(Constants.kMaxAxis, Constants.kMinAxis, Constants.kLowRangeTurn, Constants.kHighRangeTurn, acceleration);
    double turn = Robot.oi.driveStick.getX() * 0.5;
    finalLeftSpeed = (speed + turn) * throttleAcc;
    finalRightSpeed = (speed - turn) * throttleAcc;
    Robot.drivetrain.setDriveMotors(finalLeftSpeed, finalRightSpeed);
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
