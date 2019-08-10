/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.drivetrain.ArcadeDrive;

public class Drivetrain extends Subsystem {
  // private static Drivetrain instance = new Drivetrain();
  private boolean flipped = false;

  // public static Drivetrain getInstance() {
  //   return instance;
  // }

  private static SpeedControllerGroup
    leftMotors = new SpeedControllerGroup(RobotMap.frontLeftDriveMotor, RobotMap.backLeftDriveMotor),
    rightMotors = new SpeedControllerGroup(RobotMap.frontRightDriveMotor, RobotMap.backRightDriveMotor);

  public Drivetrain() {
    RobotMap.frontLeftDriveMotor.setNeutralMode(NeutralMode.Brake);
    RobotMap.frontRightDriveMotor.setNeutralMode(NeutralMode.Brake);
    RobotMap.backLeftDriveMotor.setNeutralMode(NeutralMode.Brake);
    RobotMap.backRightDriveMotor.setNeutralMode(NeutralMode.Brake);
    rightMotors.setInverted(true);
  }

  
  public void setDriveMotors(double leftVoltage, double rightVoltage) {
    if (flipped == false)
    {
      leftMotors.set(leftVoltage);
      rightMotors.set(rightVoltage);
    }
    else if (flipped == true)
    {
      leftMotors.set(-rightVoltage);
      rightMotors.set(-leftVoltage);
    }

  }

  /**
   * Flips the drivetrain
   */
  public void flip() 
  {
    flipped = !flipped;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ArcadeDrive());
  }
}
