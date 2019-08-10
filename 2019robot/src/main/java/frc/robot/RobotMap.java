/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import frc.util.LimitSwitch;

public class RobotMap {
  public static WPI_VictorSPX
    frontRightDriveMotor = new WPI_VictorSPX(Constants.kFrontRightMotor), 
    frontLeftDriveMotor = new WPI_VictorSPX(Constants.kFrontLeftMotor),
    backRightDriveMotor = new WPI_VictorSPX(Constants.kBackRightMotor), 
    backLeftDriveMotor = new WPI_VictorSPX(Constants.kBackLeftMotor);

  public static Spark
    leftCargoIntakeMotor = new Spark(Constants.kLeftCargoIntakeMotor), 
    rightCargoIntakeMotor = new Spark(Constants.kRightCargoIntakeMotor);
  
  public static Spark 
    climberWheelMotor = new Spark(Constants.kClimberWheelPort);
  
  public static VictorSP
    climberLiftMotor = new VictorSP(Constants.kClimberLiftPort);
  
  public static WPI_TalonSRX
    armMasterMotor = new WPI_TalonSRX(Constants.kArmMasterPort),
    armSlaveMotor = new WPI_TalonSRX(Constants.kArmSlavePort);
    
  public static Spark 
    hatchIntakeWheelMotor = new Spark(Constants.kHatchIntakeWheelPort);
  
  public static WPI_TalonSRX
    hatchIntakePivotMotor = new WPI_TalonSRX(Constants.kHatchIntakePivotPort);

  public static DigitalInput
    armZeroLimitSwitch = new DigitalInput(Constants.kArmZeroLimitSwitchPort);
    // climberTopLimitSwitch = new DigitalInput(Constants.kClimberTopLimitSwitchPort),
    // climberBottomLimitSwitch = new DigitalInput(Constants.kClimberBottomLimitSwitchPort);
}
