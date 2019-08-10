package frc.robot;

public class RobotConstants {
    
    //Drivetrain Constants
    public static final int
        kFrontLeftMotor = 1,
        kBackLeftMotor = 0,
        kFrontRightMotor = 2,
        kBackRightMotor = 3,
        kLeftDriveEncoderA = 0, // 10
        kLeftDriveEncoderB = 1, // 11
        kRightDriveEncoderA = 12,
        kRightDriveEncoderB = 13,
        kEncoderTicksPerRev = 255;
        
    //Joystick Constants
    public static final int
        kLeftStickPort = 0,
        kRightStickPort = 1;

    //Pathfinder Constants
    public static final double
        kWheelDiameter = 0.5, // feet
        kP = 0.1,
        kI = 0.0,
        kD = 0.0,
        kVMax = 9.08, // ft/sec
        kA = 0.0, // Need to find
        kdt = 0.02; // seconds
}