/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.climber.Climb;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.commands.drivetrain.FlipDrivetrain;
import frc.robot.commands.drivetrain.PIDRotateAngle;
import frc.robot.commands.drivetrain.TurnToAngle;
import frc.robot.commands.intake.IntakeCell;
import frc.robot.commands.intake.OuttakeCell;
import frc.robot.commands.shooter.Shoot;
import frc.robot.commands.shooter.VisionAssistedShoot;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LimelightVision;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.SixBall;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final Drivetrain drivetrain = new Drivetrain();

  private final Intake intake = new Intake();

  private final Shooter shooter = new Shooter();

  private final LimelightVision limelight = new LimelightVision();

  private final Pneumatics pneumatics = new Pneumatics();

  private final Climber climber = new Climber();

  private Joystick driveJoystick = new Joystick(Constants.kDriveJoystickPort);

  private XboxController controller = new XboxController(1);

  private JoystickButton shoot9020 = new JoystickButton(driveJoystick, 12);
  private JoystickButton shoot9015 = new JoystickButton(driveJoystick, 2);
  private JoystickButton shoot9010 = new JoystickButton(driveJoystick, 10);

  private JoystickButton servoTest = new JoystickButton(driveJoystick, 7);


  private final JoystickButton align = new JoystickButton(driveJoystick, 8);

  
 private final JoystickButton flipDT = new JoystickButton(driveJoystick, 6);
  
  private final JoystickButton shoot = new JoystickButton(driveJoystick, 1);

  SendableChooser<CommandBase> autonomousTrajectories;

  private final JoystickButton intakeCell = new JoystickButton(driveJoystick, 3);
  private final JoystickButton outtakeCell = new JoystickButton(driveJoystick, 4);
  

  private final JoystickButton compressorOff = new JoystickButton(driveJoystick, 11);
  private final JoystickButton compressorOn = new JoystickButton(driveJoystick, 9);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    autonomousTrajectories = new SendableChooser<>();

    climber.setDefaultCommand(new Climb(climber, () -> controller.getY(Hand.kLeft), () -> controller.getY(Hand.kRight)));
    drivetrain.setDefaultCommand(new ArcadeDrive(drivetrain, () -> -driveJoystick.getY(), () -> driveJoystick.getX(), () -> driveJoystick.getThrottle()));

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    align.whileHeld(
      new PIDRotateAngle(
        drivetrain,
        shooter
        //leds
      )
    );

    shoot9015.whileHeld(new Shoot(shooter, () -> 11.5, () -> 90, pneumatics));
    shoot9020.whileHeld(new Shoot(shooter, () -> 20, () -> 90, pneumatics));

    shoot9010.whenPressed(new InstantCommand(pneumatics::TurnOffSolenoid, pneumatics));

    shoot.whileHeld(new VisionAssistedShoot(shooter, pneumatics));


    flipDT.whenPressed(new FlipDrivetrain(drivetrain));
    
  
    compressorOff.whenPressed(new InstantCommand(pneumatics::TurnOffCompressor, pneumatics));
    compressorOn.whenPressed(new InstantCommand(pneumatics::TurnOnCompressor, pneumatics));


    servoTest.whenPressed(new TurnToAngle(drivetrain, 0));

    intakeCell.whileHeld(new IntakeCell(intake, shooter, pneumatics));
    outtakeCell.whileHeld(new OuttakeCell(intake));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new SixBall(drivetrain, shooter, pneumatics, intake);
  }
}
