/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveTrainConstants;

public class DriveSubsystem extends SubsystemBase {

	/**
	 * Motor Diagram |1 3| |2 4|
	 */

	private WPI_TalonSRX rightTalon;
	private WPI_VictorSPX rightVictor2;
	private SpeedControllerGroup m_rightMotors;
	private WPI_TalonSRX leftTalon;
	private WPI_VictorSPX leftVictor4;
	private SpeedControllerGroup m_leftMotors;
	private DifferentialDrive m_drive;

	// // The motors on the left side of the drive.
	// private final SpeedControllerGroup m_leftMotors = new
	// SpeedControllerGroup(new WPI_TalonSRX(1), new WPI_VictorSPX(2));

	// // The motors on the right side of the drive.
	// private final SpeedControllerGroup m_rightMotors = new
	// SpeedControllerGroup(new WPI_TalonSRX(3),
	// new WPI_VictorSPX(4));

	// // The robot's drive
	// private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors,
	// m_rightMotors);

	/**
	 * Creates a new DriveSubsystem.
	 */
	public DriveSubsystem() {

		rightTalon = new WPI_TalonSRX(DriveTrainConstants.RIGHT_TALON);

		rightVictor2 = new WPI_VictorSPX(DriveTrainConstants.RIGHT_VICTOR);
		rightVictor2.follow(rightTalon);

		m_rightMotors = new SpeedControllerGroup(rightTalon, rightVictor2);
		addChild("Speed Controller Group 2", m_rightMotors);

		leftTalon = new WPI_TalonSRX(DriveTrainConstants.LEFT_TALON);

		leftVictor4 = new WPI_VictorSPX(DriveTrainConstants.LEFT_VICTOR);
		leftVictor4.follow(leftTalon);

		m_leftMotors = new SpeedControllerGroup(leftTalon, leftVictor4);
		addChild("Speed Controller Group 1", m_leftMotors);

		m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
		addChild("Differential Drive 1", m_drive);
		// differentialDrive1.setSafetyEnabled(true);
		m_drive.setExpiration(0.1);
		m_drive.setMaxOutput(1.0);

		m_rightMotors.setInverted(true);
		m_leftMotors.setInverted(true);

		rightTalon.configAllSettings(DriveTrainConstants.getConfig());
		rightTalon.setSelectedSensorPosition(0);

		leftTalon.configAllSettings(DriveTrainConstants.getConfig());
		leftTalon.setSelectedSensorPosition(0);
	}

	/**
	 * Drives the robot using arcade controls.
	 *
	 * @param fwd the commanded forward movement
	 * @param rot the commanded rotation
	 */
	public void arcadeDrive(double fwd, double rot) {
		m_drive.arcadeDrive(fwd, rot);
	}

	public void resetEncoders() {
		rightTalon.setSelectedSensorPosition(0);
		leftTalon.setSelectedSensorPosition(0);
	}

	public DifferentialDrive getDDrive() {
		return m_drive;
	}

	/**
	 * Gets the left drive WPI_TalonSRX.
	 *
	 * @return the left drive WPI_TalonSRX
	 */
	public WPI_TalonSRX getLeft() {
		return rightTalon;
	}

	/**
	 * Gets the right drive WPI_TalonSRX.
	 *
	 * @return the right drive WPI_TalonSRX
	 */
	public WPI_TalonSRX getRightr() {
		return leftTalon;
	}

	/**
	 * Sets the max output of the drive. Useful for scaling the drive to drive more
	 * slowly.
	 *
	 * @param maxOutput the maximum output to which the drive will be constrained
	 */
	public void setMaxOutput(double maxOutput) {
		m_drive.setMaxOutput(maxOutput);
	}

	@Override
	public void periodic() {
		// This method will be called once per scheduler run
	}
}
