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
// import edu.wpi.first.wpilibj.buttons.Button;
// import edu.wpi.first.wpilibj.buttons.JosystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.WinchSet;
import frc.robot.commands.HopperAdvance;
import frc.robot.commands.HopperHold;
import frc.robot.commands.HopperReverse;
import frc.robot.commands.HopperSet;
import frc.robot.commands.JoystickDrive;
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
  public DriveSubsystem driveTrainSubsystem = new DriveSubsystem();

  public Joystick driveStick = new Joystick(Constants.ControllerConstants.DRIVER_STICK_CHANNEL);

  private final SendableChooser<Command> autoChooser = new SendableChooser<>();

  public static Hopper hopper;
  public Command hopperAdvance;
  public Command hopperStop;
  public Command hopperReverse;

  // public static SpitterSet spitterSetCommand;
  public static Command spitterOff;
  public static Command spitterOn;

  public static Telescope telescope;
  public static Command setTelescopeZero;

  public static Winch winch;
  public static Command setWinchZero;
  public static Command setWinchTenInch;

  /**
   * RobotContainer
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    configureSubsystemCommands();

    // Telescope //
    hopper = new Hopper();
    hopperAdvance = new HopperSet(hopper, Constants.HopperConstants.HOPPER_ADVANCE_SPEED);
    hopperStop = new HopperSet(hopper, Constants.HopperConstants.HOPPER_HOLD_SPEED);
    hopperReverse = new HopperSet(hopper, Constants.HopperConstants.HOPPER_REVERSE_SPEED);
    hopper.setDefaultCommand(hopperStop);
    // //

    // spitter = new Spitter();

    // Telescope //
    telescope = new Telescope();
    setTelescopeZero = new TelescopeSeek(telescope, 10.0); // 10 Inches
    // //

    // Winch //
    winch = new Winch();
    setWinchZero = new WinchSet(winch, 0);
    setWinchTenInch = new WinchSet(winch, 10.0);
    // //

    driveTrainSubsystem.setDefaultCommand(new JoystickDrive(this.driveTrainSubsystem, this.driveStick));

    // spitterOn = new SpitterSet(spitter, 1);
    // spitterOff = new SpitterSet(spitter, 0);

    // //
  }

  private void configureButtonBindings() {

    new JoystickButton(driveStick, 5).whenActive(hopperAdvance);
    new JoystickButton(driveStick, 3).whenActive(hopperStop);
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
