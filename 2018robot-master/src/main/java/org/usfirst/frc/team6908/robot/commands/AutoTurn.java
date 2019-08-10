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
//        DriveTrain.rotater.setAbsoluteTolerance(2);
        DriveTrain.rotater.setOutputRange(-0.5, 0.5);
    }

    protected void execute() {
//    	SmartDashboard.putBoolean("ee", Math.abs(DriveTrain.rotater.get())<.1);
//    	SmartDashboard.putBoolean("hh", DriveTrain.rotater.onTarget());
//    	SmartDashboard.putBoolean("ehhhhhhhhhhhhhh", Math.abs(DriveTrain.rotater.get())<.1 && DriveTrain.rotater.onTarget());
//    	SmartDashboard.putNumber("oh", Math.abs(DriveTrain.rotater.get()));
    }

    protected boolean isFinished() {
//        return (Math.abs(DriveTrain.rotater.get())<.1 && DriveTrain.rotater.onTarget());
    	return (this.timeSinceInitialized() >= 1.7);
    }

    protected void end() {
        DriveTrain.rotater.disable();
//        Robot.drivetrain.Drive(0.0, 0.0);
        System.out.println("i wanna die");
    }

    protected void interrupted() {
        end();
        
    }
}