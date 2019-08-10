/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.arm.ManualArmControl;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem {
  // private static Arm instance = new Arm();

  // public static Arm getInstance() {
  //   return instance;
  // }

  private static WPI_TalonSRX
    armMasterMotor = RobotMap.armMasterMotor,
    armSlaveMotor = RobotMap.armSlaveMotor;

  public Arm() {
    armMasterMotor.setNeutralMode(NeutralMode.Brake);
    armSlaveMotor.setNeutralMode(NeutralMode.Brake);

    armMasterMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    armMasterMotor.setSensorPhase(true);
    armMasterMotor.setInverted(false);

    armMasterMotor.configNominalOutputForward(0, 0);
    armMasterMotor.configNominalOutputReverse(0, 0);
    armMasterMotor.configPeakOutputForward(1, 0);
    armMasterMotor.configPeakOutputReverse(-1, 0);

    armMasterMotor.selectProfileSlot(0, 0);
    // armMasterMotor.config_kF(0, Constants.kArmF,0);
    // armMasterMotor.config_kP(0, Constants.kArmP, 0);
    // armMasterMotor.config_kI(0,Constants.kArmI, 0);
    // armMasterMotor.config_kD(0, Constants.kArmD, 0);
    
    // armMasterMotor.configMotionCruiseVelocity(Constants.kArmCruiseVelocity, 0);
    // armMasterMotor.configMotionAcceleration(Constants.kArmAcceleration, 0);

    armMasterMotor.setSelectedSensorPosition(0, 0, 0);

    armSlaveMotor.follow(armMasterMotor);
  }
  
  public void setArmVoltage(double voltage) {
    armMasterMotor.set(ControlMode.PercentOutput, voltage, DemandType.ArbitraryFeedForward, -Constants.kG * Math.cos(Math.toRadians(90 - getAngle())));
  }

  public double getAngle() {
    return 180 - ((double) armMasterMotor.getSelectedSensorPosition() / 4096 * 360);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ManualArmControl());
  }

  public void resetArmPosition()
  {
    armMasterMotor.setSelectedSensorPosition(0,0,0);
    armSlaveMotor.follow(armMasterMotor);
  }
}
