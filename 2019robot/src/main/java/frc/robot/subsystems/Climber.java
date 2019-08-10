/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.climber.ClimberWheelControl;

public class Climber extends Subsystem {
  // private static Climber instance = new Climber();
  
  // public static Climber getInstance() {
  //   climberLiftMotor.setInverted(true);
  //   climberWheelMotor.setInverted(true);
  //   return instance;
  // }
  private static Spark 
    climberWheelMotor = RobotMap.climberWheelMotor;
  
  private static VictorSP
    climberLiftMotor = RobotMap.climberLiftMotor;

  public void setLiftMotor(double voltage) {
    climberLiftMotor.set(voltage);
  }

  public void setWheelMotor(double voltage) {
    climberWheelMotor.set(voltage);
  }

  public Climber() {
    climberLiftMotor.setInverted(true);
    climberWheelMotor.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ClimberWheelControl());
  }

}
