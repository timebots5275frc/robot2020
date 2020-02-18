/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Winch;

public class WinchSet extends CommandBase {
	private int _pos;
	final Winch _win;

	/**
	 * Creates a new WinchSet.
	 * 
	 * @param position the position, in encoder counts, for this instance of
	 *                 WinchSet to seek to.
	 */
	public WinchSet(Winch winch, int position) {
		// Use addRequirements() here to declare subsystem dependencies.
		addRequirements(winch);
		_win = winch;
		_pos = position;

	}

	/**
	 * Creates a new WinchSet.
	 * 
	 * @param pull the position, in inches of lift, for this instance of WinchSet to
	 *             seek to.
	 */
	public WinchSet(Winch winch, double pull) {
		addRequirements(winch);
		_win = winch;
		_pos = (int) _win.rotationsToEnc(_win.pullToRotations(pull));
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		System.out.println("WINCHSET INITIALIZED");
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		System.out.println("WinchSet position: " + _win.getMotor().getSelectedSensorPosition() + " target: " + _pos);
		System.out.println("WinchSet voltage: " + _win.getMotor().getBusVoltage());
		_win.getMotor().set(ControlMode.Position, _pos);
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		System.out.println("interrupted or ended");
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
