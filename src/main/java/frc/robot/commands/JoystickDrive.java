/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class JoystickDrive extends CommandBase {
	private final DriveSubsystem m_drive;
	private final Joystick joystick;

	/**
	 * Creates a new DefaultDrive.
	 *
	 * @param subsystem The drive subsystem this command wil run on.
	 * @param forward   The control input for driving forwards/backwards
	 * @param rotation  The control input for turning
	 */
	public JoystickDrive(DriveSubsystem subsystem, Joystick joystick) {
		this.m_drive = subsystem;
		this.joystick = joystick;
		addRequirements(subsystem);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {

		// double throt = (((joystick.getRawAxis(3) / 2) + 1) / 2);

		// double m_forward = (throt * joystick.getRawAxis(1));
		// double m_rotation = ((throt / 2) * joystick.getRawAxis(2));

		double throt = (joystick.getRawAxis(3) * -1 + 1);

		double m_forward = joystick.getRawAxis(1) * throt * -1;
		double m_rotation = joystick.getRawAxis(2) * (throt / 2) * -1;

		System.out.println("throt = " + throt);
		System.out.println("m_forward = " + m_forward);
		System.out.println("m_rotation = " + m_rotation);

		m_drive.arcadeDrive(m_forward, m_rotation);
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
