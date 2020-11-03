/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.controller.ProfiledPIDController;
import edu.wpi.first.wpilibj.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.ProfiledPIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

/**
 * A command that will turn the robot to the specified angle using a motion profile.
 */
public class RotateToAngle extends ProfiledPIDCommand {
  /**
   * Turns to robot to the specified angle using a motion profile.
   *
   * @param targetAngleDegrees The angle to turn to
   * @param drive              The drive subsystem to use
   */
  public RotateToAngle(Drivetrain drivetrain, double targetAngleDegrees) {
    super(
        new ProfiledPIDController(Constants.kDriveTurnP, Constants.kDriveTurnI,
                                  Constants.kDriveTurnD, new TrapezoidProfile.Constraints(
            Constants.kMaxTurnRateDegPerS,
            Constants.kMaxTurnAccelerationDegPerSSquared)),
        // Close loop on heading
        drivetrain::getHeadingAsAngle,
        // Set reference to target
        targetAngleDegrees,
        // Pipe output to turn robot
        (output, setpoint) -> drivetrain.arcadeDrive(0, output),
        // Require the drive
        drivetrain);

    // Set the controller to be continuous (because it is an angle controller)
    getController().enableContinuousInput(-180, 180);
    // Set the controller tolerance - the delta tolerance ensures the robot is stationary at the
    // setpoint before it is considered as having reached the reference
    getController()
        .setTolerance(Constants.kTurnToleranceDeg, Constants.kTurnRateToleranceDegPerS);
  }

  @Override
  public boolean isFinished() {
    // End when the controller is at the reference.
    return getController().atGoal();
  }
}