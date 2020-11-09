/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.LimelightVision;
import frc.robot.subsystems.Shooter;

public class PIDRotateAngle extends CommandBase {

  private final Drivetrain drivetrain;
  private final Shooter shooter;
  private double setpoint;

  private final double kP = 0.13; // 0.15;// 0.03;// 0.025; // 0.06//0.0825;//0.075;// 0.0875; // 0.09; //0.1; // 0.1125;//0.125; //0.15;
  private final double kD = 0.013; // 0.01;//0.002; //0.011;// 0.009875;// 0.00975;
  private final double kI = 0; //0.005;
  // Use 0.0825 & 0.00975 for drivetrain rotation

  private double previousError = 0;
  private double error = 0;
  private double cumError = 0;

  private int stopAccumulator;
  

  /**
   * Creates a new PIDRotateAngle.
   */
  public PIDRotateAngle(Drivetrain drivetrain, Shooter shooter) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drivetrain = drivetrain;
    this.shooter = shooter;
    // addRequirements(drivetrain);
    // addRequirements(shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    stopAccumulator = 0;
    setpoint = 0;
    cumError = 0;
    previousError = 0;
    error = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      error = -shooter.getHorizontalOffset();
      cumError += error * Constants.kDT;
      double output = (kP * error) + (kD * (error - previousError) / Constants.kDT) + (kI * cumError);
      drivetrain.arcadeDrive(0, -output);
      previousError = error;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (!shooter.hasValidTargetPose2d())
    {
      return true;
    }
    
    if(Math.abs(error)<=1){
      stopAccumulator++;
    }
    else if(Math.abs(error)>=1){
      stopAccumulator = 0;
    }
    return stopAccumulator>=10;
  }
}
