package org.usfirst.frc.team6908.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6908.robot.Robot;
import org.usfirst.frc.team6908.robot.subsystems.DriveTrain;

/**
 *
 */
public class  AutoTurn extends Command {
	private double turnAngle;

    public AutoTurn(double angle) {
        requires(Robot.drivetrain);
        turnAngle = angle;
    	DriveTrain.gyro.reset();
    }

    protected void initialize() {
    	DriveTrain.gyro.reset();
    	DriveTrain.rotater.reset();
        DriveTrain.rotater.enable();
        DriveTrain.rotater.setSetpoint(turnAngle + DriveTrain.gyro.getAngle());
        DriveTrain.rotater.setOutputRange(-0.5, 0.5);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	return (this.timeSinceInitialized() >= 1.7);
    }

    protected void end() {
        DriveTrain.rotater.disable();
    }

    protected void interrupted() {
        end();
    }
}
