/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
// import edu.wpi.first.wpilibj.buttons.Button;
// import edu.wpi.first.wpilibj.buttons.JosystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.WinchSet;
import frc.robot.commands.AutoDriveForward;
import frc.robot.commands.ExtendClimbSystem;
import frc.robot.commands.HopperSet;
import frc.robot.commands.IntakeHopperGroup;
import frc.robot.commands.IntakeSolenoidSet;
import frc.robot.commands.IntakeSpeedSet;
import frc.robot.commands.JoystickDrive;
import frc.robot.commands.RatchetSender;
import frc.robot.commands.RatchetSet;
import frc.robot.commands.SpitterSet;
import frc.robot.commands.SpitterSolenoidSet;
import frc.robot.commands.TelescopeSeek;
import frc.robot.subsystems.*;
import static frc.robot.Constants.TelescopeConstants.FULL_EXTENSION;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public DriveSubsystem driveTrainSubsystem = new DriveSubsystem();

  public Joystick driveStick = new Joystick(Constants.ControllerConstants.DRIVER_STICK_CHANNEL);
  public Joystick auxStick = new Joystick(Constants.ControllerConstants.AUX_STICK_CHANNEL);

  private final SendableChooser<Command> autoChooser = new SendableChooser<>();

  public static Hopper hopper;
  public static Command hopperAdvance;
  public static Command hopperStop;
  public static Command hopperReverse;

  public static Spitter spitter;
  public static Command spitterOff;
  public static Command spitterOn;
  public static Command spitterDeploy;
  public static Command spitterRetract;

  public static Telescope telescope;
  public static Command setTelescopeZero;
  public static Command setTelescopeHigh;

  public static Winch winch;
  public static Command setWinchZero;
  public static Command setWinchTenInch;
  public static Command setRatchetLock;
  public static Command setRatchetUnLock;

  public static Intake intake;
  public static Command deployIntake;
  public static Command retractIntake;
  public static Command startIntake;
  public static Command stopIntake;
  public static Command reverseIntake;

  public static Command extendCommand;
  public static Command retractCommand;
  public static Command halfwayCommand;
  public static Command extendLowCommand;
  public static Command negRetractCommand;

  public static Command rsend;
  public static Command ratchetLock;
  public static Command ratchetUnlock;

  public static Command autoDriveForwards;

  // Command Groups
  public static IntakeHopperGroup intakeHopperCommandGroup;

  /**
   * RobotContainer
   */
  public RobotContainer() {
    // Configure the button bindings

    // Intake //
    intake = new Intake();
    deployIntake = new IntakeSolenoidSet(intake, true);
    retractIntake = new IntakeSolenoidSet(intake, false);
    startIntake = new IntakeSpeedSet(intake, Constants.IntakeConstants.INTAKE_SPEED);
    stopIntake = new IntakeSpeedSet(intake, 0);
    reverseIntake = new IntakeSpeedSet(intake, -1 * Constants.IntakeConstants.INTAKE_SPEED);
    intake.setDefaultCommand(stopIntake);
    // //

    // Spitter //
    spitter = new Spitter();
    spitterOff = new SpitterSet(spitter, 0.0);
    spitterOn = new SpitterSet(spitter, Constants.SpitterConstants.MAX_OUTPUT);
    spitterDeploy = new SpitterSolenoidSet(spitter, true);
    spitterRetract = new SpitterSolenoidSet(spitter, false);
    // //

    // Hopper //
    hopper = new Hopper();
    hopperAdvance = new HopperSet(hopper, Constants.HopperConstants.HOPPER_ADVANCE_SPEED);
    hopperStop = new HopperSet(hopper, Constants.HopperConstants.HOPPER_HOLD_SPEED);
    hopperReverse = new HopperSet(hopper, Constants.HopperConstants.HOPPER_REVERSE_SPEED);
    hopper.setDefaultCommand(hopperStop);
    // hopperAdvance.start();
    // //

    // Telescope //
    telescope = new Telescope();

    // Winch //
    winch = new Winch();
    rsend = new RatchetSender(winch, 1.0);
    ratchetLock = new RatchetSet(winch, true);
    ratchetUnlock = new RatchetSet(winch, false);

    // EXTEND/RETRACT
    extendCommand = new ExtendClimbSystem(telescope, winch, FULL_EXTENSION);
    extendLowCommand = new ExtendClimbSystem(telescope, winch, FULL_EXTENSION - (4096 * 2));
    retractCommand = new ExtendClimbSystem(telescope, winch, 0);
    halfwayCommand = new ExtendClimbSystem(telescope, winch, FULL_EXTENSION / 2);
    negRetractCommand = new ExtendClimbSystem(telescope, winch, (-4096 * 7) - 2048);

    driveTrainSubsystem.setDefaultCommand(new JoystickDrive(this.driveTrainSubsystem, this.driveStick));

    intakeHopperCommandGroup = new IntakeHopperGroup();

    autoDriveForwards = new AutoDriveForward(driveTrainSubsystem, 1.0, .7);
    autoChooser.addOption("Drive Forwards - Auton", autoDriveForwards);
    autoChooser.setDefaultOption("DO NOTHING", new CommandBase() {
    });
    SmartDashboard.putData("Auto Selector", autoChooser);

    configureButtonBindings();
    configureSubsystemCommands();
  }

  private void configureButtonBindings() {

    new JoystickButton(driveStick, 1).toggleWhenPressed(spitterOn);
    // new JoystickButton(driveStick, 2).toggleWhenPressed(startIntake);
    new JoystickButton(driveStick, 2).toggleWhenPressed(intakeHopperCommandGroup);

    new JoystickButton(driveStick, 3).whenActive(retractIntake);
    new JoystickButton(driveStick, 4).whenActive(spitterRetract);
    new JoystickButton(driveStick, 5).whenActive(deployIntake);

    new JoystickButton(driveStick, 6).whenActive(spitterDeploy);
    new JoystickButton(driveStick, 7).whenActive(retractCommand);
    new JoystickButton(driveStick, 9).whenActive(halfwayCommand); // CLIMB RETRACT HALFWAY
    new JoystickButton(driveStick, 10).whenActive(negRetractCommand); // CLIMB RETRACT 1/4 UP
    new JoystickButton(driveStick, 11).whenActive(extendCommand); // CLIMB EXTEND HIGH
    new JoystickButton(driveStick, 12).whenActive(extendLowCommand); // CLIMB EXTEND LOW

    new JoystickButton(auxStick, 7).whenActive(reverseIntake);
    new JoystickButton(auxStick, 8).whenActive(hopperReverse);
    new JoystickButton(auxStick, 1).toggleWhenPressed(ratchetLock);
    new JoystickButton(auxStick, 2).toggleWhenPressed(ratchetUnlock);
    // //

  }

  private void configureSubsystemCommands() {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }

  public Joystick getDriveStick() {
    return driveStick;
  }
}
