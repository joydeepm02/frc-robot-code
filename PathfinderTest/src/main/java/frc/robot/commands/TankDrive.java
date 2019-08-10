/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class TankDrive extends Command {
    double startTime = 0;

    public TankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
    }

    public double checkDeadzone(double speed) {
        if(Math.abs(speed) < 0.05) {
            return 0;
        }
        else {
            return speed;
        }
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.drivetrain.stop();
        RobotMap.leftDriveEncoder.reset();
        RobotMap.rightDriveEncoder.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double leftSpeed = OI.leftStick.getY();
        double rightSpeed = OI.rightStick.getY();
        leftSpeed = checkDeadzone(leftSpeed);
        rightSpeed = checkDeadzone(rightSpeed);
        Robot.drivetrain.drive(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
