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
import frc.robot.commands.cargointake.OuttakeCargo;

public class CargoIntake extends Subsystem {
  // private static CargoIntake instance = new CargoIntake();

  // public static CargoIntake getInstance() {
  //   return instance;
  // }

  private Spark 
    leftCargoIntakeMotor = RobotMap.leftCargoIntakeMotor, 
    rightCargoIntakeMotor = RobotMap.rightCargoIntakeMotor;

  public void setCargoIntakeMotor(double leftSpeed, double rightSpeed) {
    leftCargoIntakeMotor.set(leftSpeed);
    rightCargoIntakeMotor.set(rightSpeed);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new OuttakeCargo());
  }
}
