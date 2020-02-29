/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Spitter extends SubsystemBase {
	private DoubleSolenoid solenoidTrapDoor;
	private WPI_VictorSPX spitterVictor;

	public Spitter() {
		solenoidTrapDoor = new DoubleSolenoid(1, 1, 6);
		addChild("solenoidTrapDoor", solenoidTrapDoor);

		spitterVictor = new WPI_VictorSPX(Constants.SpitterConstants.VICTOR_CAN);
	}

	public DoubleSolenoid getTrapDoor() {
		return solenoidTrapDoor;
	}

	public WPI_VictorSPX getVictor() {
		return spitterVictor;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	@Override
	public void periodic() {
		// Put code here to be run every loop
	}

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

}
