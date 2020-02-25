/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveTrainConstants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveDistance extends CommandBase {
    private final DriveSubsystem drive;
    private final double inches;
    private final double speed;
    private final int _pos;

    /**
     * Creates a new DriveDistance.
     *
     * @param inches The number of inches the robot will drive
     * @param speed  The speed at which the robot will drive
     * @param drive  The drive subsystem on which this command will run
     */
    public DriveDistance(double inches, double speed, DriveSubsystem drive) {
        addRequirements(drive);
        this.inches = inches;
        this.speed = speed;
        this.drive = drive;

        inches = inches / DriveTrainConstants.WHEEL_CIRCUMFERENCE_INCHES; // pull / circumference to yield rotations
        inches = inches * 4096; // rotations to encoder counts
        _pos = (int) inches;
    }

    @Override
    public void initialize() {
        drive.resetEncoders();
        drive.arcadeDrive(speed, 0);
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        drive.getLeft().set(ControlMode.Position, _pos);
        drive.getRightr().set(ControlMode.Position, _pos);
    }

    @Override
    public void end(boolean interrupted) {
        drive.arcadeDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        // return Math.abs(drive.getAverageEncoderDistance()) >= m_distanceInch;
        return false;
    }
}
