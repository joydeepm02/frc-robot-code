/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.hatchintake.OuttakeHatch;;


public class HatchIntake extends Subsystem {
  // private static HatchIntake instance;

  // public static HatchIntake getInstance() {
  //   return instance;
  // }

  public Spark 
    hatchIntakeWheelMotor = RobotMap.hatchIntakeWheelMotor;
  
  public void intake() {
    hatchIntakeWheelMotor.set(0.5);
  }

  public void outtake() {
    hatchIntakeWheelMotor.set(-1.0);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new OuttakeHatch());
  }
}
