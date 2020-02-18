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

public class DriveSubsystem extends SubsystemBase {

  /**
   * Motor Diagram |1 3| |2 4|
   */

  private WPI_TalonSRX rightTalon1;
  private WPI_VictorSPX rightVictor2;
  private SpeedControllerGroup m_rightMotors;
  private WPI_TalonSRX leftTalon3;
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

    rightTalon1 = new WPI_TalonSRX(1);

    rightVictor2 = new WPI_VictorSPX(2);

    m_rightMotors = new SpeedControllerGroup(rightTalon1, rightVictor2);
    addChild("Speed Controller Group 2", m_rightMotors);

    leftTalon3 = new WPI_TalonSRX(3);

    leftVictor4 = new WPI_VictorSPX(4);

    m_leftMotors = new SpeedControllerGroup(leftTalon3, leftVictor4);
    addChild("Speed Controller Group 1", m_leftMotors);

    m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
    addChild("Differential Drive 1", m_drive);
    // differentialDrive1.setSafetyEnabled(true);
    m_drive.setExpiration(0.1);
    m_drive.setMaxOutput(1.0);

    m_rightMotors.setInverted(true);
    m_leftMotors.setInverted(true);
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

  public DifferentialDrive getDDrive() {
    return m_drive;
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
