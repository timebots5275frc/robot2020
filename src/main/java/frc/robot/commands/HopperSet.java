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
	final Hopper _hop;

	private WPI_VictorSPX hopperVictorTop;
	private WPI_VictorSPX hopperVictorBottom;

	public HopperSet(Hopper hop) {
		_hop = hop;
		addRequirements(_hop);
		hopperVictorTop = RobotContainer.hopper.getHopperVictorBottom();
		hopperVictorBottom = RobotContainer.hopper.getHopperVictorTop();
	}

	// Called just before this Command runs the first time
	@Override
	public void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	public void execute() {
		hopperVictorTop.set(ControlMode.PercentOutput, Constants.HopperConstants.HOPPER_ADVANCE_SPEED);
		hopperVictorBottom.set(ControlMode.PercentOutput, Constants.HopperConstants.HOPPER_ADVANCE_SPEED);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	public boolean isFinished() {
		return false;
	}
}
