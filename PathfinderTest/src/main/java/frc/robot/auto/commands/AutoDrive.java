/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.auto.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotConstants;
import frc.robot.RobotMap;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

public class AutoDrive extends Command {
    /**
     * General command to drive a trajectory.
     */
    private static Trajectory
        leftTrajectory,
        rightTrajectory;
    
    private static EncoderFollower
        leftFollower,
        rightFollower;

    public AutoDrive(Trajectory l, Trajectory r) {
        System.out.println("AutoDrive started");
        RobotMap.leftDriveEncoder.reset();
        RobotMap.rightDriveEncoder.reset();

        leftTrajectory = l;
        rightTrajectory = r;

        leftFollower = new EncoderFollower(leftTrajectory);
        rightFollower = new EncoderFollower(rightTrajectory);

        leftFollower.configureEncoder(RobotMap.leftDriveEncoder.get(), RobotConstants.kEncoderTicksPerRev, RobotConstants.kWheelDiameter);
        rightFollower.configureEncoder(RobotMap.rightDriveEncoder.get(), RobotConstants.kEncoderTicksPerRev, RobotConstants.kWheelDiameter);
        leftFollower.configurePIDVA(RobotConstants.kP, RobotConstants.kI, RobotConstants.kD, 1/RobotConstants.kVMax, RobotConstants.kA);
        rightFollower.configurePIDVA(RobotConstants.kP, RobotConstants.kI, RobotConstants.kD, 1/RobotConstants.kVMax, RobotConstants.kA);

        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        double l = leftFollower.calculate(RobotMap.leftDriveEncoder.get());
        double r = rightFollower.calculate(RobotMap.rightDriveEncoder.get());
        
        double gyroHeading = -RobotMap.gyro.getAngle();
        double desiredHeading = Pathfinder.r2d(leftFollower.getHeading());

        double angleDifference = Pathfinder.boundHalfDegrees(desiredHeading - gyroHeading);
        double turn = 0.8 * (-1.0/80.0) * angleDifference;

        Robot.drivetrain.drive(l+turn, r-turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return leftFollower.isFinished() && rightFollower.isFinished();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.drivetrain.stop();
        System.out.println("AutoDrive finished");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
