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
import frc.robot.commands.ExtendClimbSystem;
import frc.robot.commands.HopperSet;
import frc.robot.commands.IntakeSolenoidSet;
import frc.robot.commands.IntakeSpeedSet;
import frc.robot.commands.JoystickDrive;
import frc.robot.commands.SpitterSet;
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

    public static Spitter spitter;
    public static Command spitterOff;
    public static Command spitterOn;

    public static Telescope telescope;
    public static Command setTelescopeZero;
    public static Command setTelescopeHigh;

    public static Winch winch;
    public static Command setWinchZero;
    public static Command setWinchTenInch;

    public static Intake intake;
    public static Command deployIntake;
    public static Command retractIntake;
    public static Command startIntake;
    public static Command stopIntake;

    public static Command extendCommand;
    public static Command retractCommand;
    public static Command halfwayCommand;

    /**
     * RobotContainer
     */
    public RobotContainer() {
        // Configure the button bindings

        // Intake //
        // intake = new Intake();
        // deployIntake = new IntakeSolenoidSet(intake, true);
        // retractIntake = new IntakeSolenoidSet(intake, false);
        // startIntake = new IntakeSpeedSet(intake, Constants.IntakeConstants.INTAKE_SPEED);
        // stopIntake = new IntakeSpeedSet(intake, 0);
        // intake.setDefaultCommand(stopIntake);
        // //

        // Hopper //
        hopper = new Hopper();
        hopperAdvance = new HopperSet(hopper, Constants.HopperConstants.HOPPER_ADVANCE_SPEED);
        hopperStop = new HopperSet(hopper, Constants.HopperConstants.HOPPER_HOLD_SPEED);
        hopperReverse = new HopperSet(hopper, Constants.HopperConstants.HOPPER_REVERSE_SPEED);
        hopper.setDefaultCommand(hopperStop);
        // //

        // Telescope //
        telescope = new Telescope();
        setTelescopeZero = new TelescopeSeek(telescope, 0); // 0in
        setTelescopeHigh = new TelescopeSeek(telescope, 6*4096);
        // //

        // Winch //
        winch = new Winch();
        setWinchZero = new WinchSet(winch, 0);
        setWinchTenInch = new WinchSet(winch, 10.0);
        // //


        // EXTEND/RETRACT
        extendCommand = new ExtendClimbSystem(telescope, winch, 40960);
        retractCommand = new ExtendClimbSystem(telescope, winch, 0);
        halfwayCommand = new ExtendClimbSystem(telescope, winch, 40960/2);

        // // Spitter //
        // spitter = new Spitter();
        // spitterOff = new SpitterSet(spitter, 0);
        // spitterOn = new SpitterSet(spitter, 1);
        // //

        driveTrainSubsystem.setDefaultCommand(new JoystickDrive(this.driveTrainSubsystem, this.driveStick));

        configureButtonBindings();
        configureSubsystemCommands();
    }

    private void configureButtonBindings() {

        new JoystickButton(driveStick, 5).whenActive(hopperAdvance);
        new JoystickButton(driveStick, 3).whenActive(hopperStop);
        new JoystickButton(driveStick, 4).whenActive(retractCommand);
        new JoystickButton(driveStick, 1).whenActive(halfwayCommand); 
        new JoystickButton(driveStick, 6).whenActive(extendCommand);
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
