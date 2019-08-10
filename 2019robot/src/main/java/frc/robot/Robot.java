/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.CargoIntake;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.HatchIntake;
import frc.robot.subsystems.Pivot;
import frc.robot.subsystems.Vision;

public class Robot extends TimedRobot {
  public static OI oi;

  // public static Drivetrain drivetrain = Drivetrain.getInstance();
  public static Drivetrain drivetrain = new Drivetrain();
  // public static CargoIntake cargoIntake = CargoIntake.getInstance();
  public static CargoIntake cargoIntake = new CargoIntake();
  // public static Climber climber = Climber.getInstance();
  public static Climber climber = new Climber();
  // public static Arm arm = Arm.getInstance();
  public static Arm arm = new Arm();
  // public static HatchIntake hatchIntake = HatchIntake.getInstance();
  public static HatchIntake hatchIntake = new HatchIntake();
  // public static Pivot pivot = Pivot.getInstance();
  public static Pivot pivot = new Pivot();
  public static Vision vision = new Vision();
  
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    oi = new OI();
    
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  @Override
  public void robotPeriodic() {
    SmartDashboard.putBoolean("Arm Reset", RobotMap.armZeroLimitSwitch.get());
    if (RobotMap.armZeroLimitSwitch.get() == false)
      arm.resetArmPosition();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
    // Scheduler.getInstance().run();
    teleopPeriodic();
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void testPeriodic() {
  }
}
