/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.WinchSet;
import frc.robot.commands.HopperAdvance;
import frc.robot.commands.HopperReverse;
import frc.robot.commands.TeleopDrive;
import frc.robot.commands.TelescopeSeek;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final DriveTrain driveTrainSubsystem = new DriveTrain();

  private static final Joystick driveStick = new Joystick(Constants.ControllerConstants.DRIVER_STICK_CHANNEL);

  private final SendableChooser<Command> autoChooser = new SendableChooser<>();

  public static Intake intake;
  public static Hopper hopper;

  // public static SpitterSet spitterSetCommand;
  public static Command spitterOff;
  public static Command spitterOn;

  public static Telescope telescope;
  public static Command setTelescopeZero;

  public static Winch winch;
  public static Command setWinchZero;
  public static Command setWinchTenInch;

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    configureSubsystemCommands();
    intake = new Intake();
    hopper = new Hopper();
    // spitter = new Spitter();

    // Telescope //
    telescope = new Telescope();
    setTelescopeZero = new TelescopeSeek(telescope, 10.0); // 10 Inches
    // //

    // Winch //
    winch = new Winch();
    setWinchZero = new WinchSet(winch, 0);
    setWinchTenInch = new WinchSet(winch, 10.0);

    // spitterOn = new SpitterSet(spitter, 1);
    // spitterOff = new SpitterSet(spitter, 0);

    // //

    // driveTrainSubsystem.setDefaultCommand(
    // // A split-stick arcade command, with forward/backward controlled by the left
    // // hand, and turning controlled by the right.
    // new TeleopDrive());
  }

  private void configureButtonBindings() {
    // new JoystickButton(driveStick, 10).whenPressed(new TeleopDrive());
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

  public static Joystick getDriveStick() {
    return driveStick;
  }
}
