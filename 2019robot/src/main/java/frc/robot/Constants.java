/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class Constants {

    // Drivetrain Constants
    public static final int 
        kFrontLeftMotor = 4, 
        kFrontRightMotor = 3, 
        kBackLeftMotor = 5,
        kBackRightMotor = 2,
        kDrivetrainFlipperButton = 2;

    public static final double
        kMinAxis = -1,
        kMaxAxis = 1,
        kLowRangeTurn = 0.2,
        kHighRangeTurn = 1;
        
    // OI Constants
    public static final int
        kDriveStickPort = 0,
        kOperatorControllerPort = 1,
        kIntakeCargoButton = 1,
        kIntakeHatchButton = 12,
        kOuttakeHatchButton = 6,
        kAlignToTargetButton = 9;

    // Cargo Intake Constants
    public static final int 
        kLeftCargoIntakeMotor = 4, 
        kRightCargoIntakeMotor = 5;
 
    // Climber Constants
    public static final int 
        kClimberLiftPort = 1, 
        kClimberWheelPort = 0,
        kClimberTopLimitSwitchPort = 0,
        kClimberBottomLimitSwitchPort = 0,
        kDeployClimberButton = 3,
        kRetractClimberButton = 5,
        kAutoDeployClimberButton = 4,
        kAutoRetractClimberButton = 6;
    
    // Arm Constants
    public static final int 
        kArmMasterPort = 6,
        kArmSlavePort = 7,
        kArmZeroLimitSwitchPort = 0;
    
    public static final double
        kG = 0.15;

    // Hatch Intake Constants
    public static final int 
        kHatchIntakeWheelPort = 3, 
        kHatchIntakePivotPort = 2;

    // Vision Constanats
    public static final int
        kCameraWidth = 320,
        kThrottleP = 0,
        kDriveToTargetButton = 10;
    
    public static final double
        kTurnP = 0.002,
        kTurnD = 0.0003;

    // Universal Constants
    public static final double
        kDT = 0.02;
}
