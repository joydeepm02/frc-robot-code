/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.pivot.ManualPivotControl;


public class Pivot extends Subsystem {
  // private static Pivot instance = new Pivot();

  // public static Pivot getInstance() {
  //   return instance;
  // }

  private WPI_TalonSRX
    hatchIntakePivotMotor = RobotMap.hatchIntakePivotMotor;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ManualPivotControl());
  }
}
