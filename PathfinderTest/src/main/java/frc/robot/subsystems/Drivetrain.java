/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public static SpeedControllerGroup
        leftMotors = new SpeedControllerGroup(RobotMap.frontLeftTalon,RobotMap.backLeftTalon),
        rightMotors = new SpeedControllerGroup(RobotMap.frontRightTalon, RobotMap.backRightTalon);

    public Drivetrain() {
        // Robot will not go in circles if right motors are inverted
        rightMotors.setInverted(true);
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftMotors.set(leftSpeed);
        rightMotors.set(rightSpeed);
    }

    public void stop() {
        leftMotors.set(0.0);
        rightMotors.set(0.0);
    }
    
    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TankDrive());
    }
}
