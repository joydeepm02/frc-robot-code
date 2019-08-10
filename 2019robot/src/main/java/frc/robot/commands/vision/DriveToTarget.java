/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.vision;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class DriveToTarget extends Command {
  
  private double prev, offset, turn, area1, area2, throttleRight, throttleLeft, cameraWidth;
  
  public DriveToTarget() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  @Override
  protected void initialize() {
    System.out.println("Entered Vision Command");
    prev = 0;
    offset = 0;
    turn = 0;
    area1 = 0;
    area2 = 0;
    throttleRight = 0;
    throttleLeft = 0;
    cameraWidth = Constants.kCameraWidth;
    // initialize network tables
  }

  // Move the robot according to the values recieved from the vision coprocessor
  @Override
  protected void execute() {
    // Retrieve values regarding RRT attributes
    // double tapeCenter = Vision.getTapeCenter();
    double centerX = Robot.vision.getRightTapeX();
    area2 = Robot.vision.getRightTapeSize();
    if (centerX == 0) offset = 0;
    else offset = (cameraWidth/2)-centerX;

    throttleRight = (Constants.kThrottleP)/area2;
    throttleLeft = ((Constants.kThrottleP + 50)/area2);
    if(throttleRight > 1) throttleRight = 1;
    if (throttleLeft > 1) throttleLeft = 1;

    // System.out.println("throttleLeft : " + throttleLeft);
    // System.out.println("throttle right: " + throttleRight);

    turn = (offset * Constants.kTurnP) + (Constants.kTurnD * ((offset - prev) / Constants.kDT));
    prev = offset;

    Robot.drivetrain.setDriveMotors(throttleLeft-turn, throttleRight + turn);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.drivetrain.setDriveMotors(0, 0);
  }

  @Override
  protected void interrupted() {
  }}
