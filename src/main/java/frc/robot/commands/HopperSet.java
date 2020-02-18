/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Hopper;

public class HopperSet extends CommandBase {
	final Hopper hopperSubsystem;

	private WPI_VictorSPX hopperVictorTop;
	private WPI_VictorSPX hopperVictorBottom;

	private double speedPercent;

	/**
	 * @param hopperSubsystem Between -1 to 1
	 * @param speedPercent
	 */
	public HopperSet(Hopper hopperSubsystem, double speedPercent) {
		this.hopperSubsystem = hopperSubsystem;
		this.speedPercent = speedPercent;

		addRequirements(hopperSubsystem);
		hopperVictorTop = hopperSubsystem.getHopperVictorBottom();
		hopperVictorBottom = hopperSubsystem.getHopperVictorTop();
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		hopperVictorTop.set(ControlMode.PercentOutput, speedPercent);
		hopperVictorBottom.set(ControlMode.PercentOutput, speedPercent);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return false;
	}
}
