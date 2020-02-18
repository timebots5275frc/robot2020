// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

/**
 *
 */
public class Hopper extends SubsystemBase {

	private WPI_VictorSPX hopperVictorTop;
	private WPI_VictorSPX hopperVictorBottom;

	public Hopper() {
		hopperVictorTop = new WPI_VictorSPX(Constants.HopperConstants.VICTOR_CAN_TOP);
		hopperVictorBottom = new WPI_VictorSPX(Constants.HopperConstants.VICTOR_CAN_BOTTOM);
		// hopperVictorFollower.follow(hopperVictor);

		// 0.5 seconds from neutral to full output (during open-loop control)
		hopperVictorTop.configOpenloopRamp(Constants.HopperConstants.VICTOR_RAMPING);
		hopperVictorBottom.configOpenloopRamp(Constants.HopperConstants.VICTOR_RAMPING);

		// ramping during closed-loop control
		hopperVictorTop.configClosedloopRamp(Constants.HopperConstants.VICTOR_RAMPING);
		hopperVictorBottom.configClosedloopRamp(Constants.HopperConstants.VICTOR_RAMPING);
	}

	/**
	 * @return the hopperVictorTop
	 */
	public WPI_VictorSPX getHopperVictorTop() {
		return hopperVictorTop;
	}

	/**
	 * @return the hopperVictorBottom
	 */
	public WPI_VictorSPX getHopperVictorBottom() {
		return hopperVictorBottom;
	}

	@Override
	public void periodic() {
		// Put code here to be run every loop

	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

}
