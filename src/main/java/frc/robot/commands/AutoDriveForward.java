/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDriveForward extends CommandBase {

  DriveSubsystem _driveSub;
  DifferentialDrive _drive;
  Timer _t = new Timer();
  double _time;
  double _speed;
  /**
   * Returns a new AutoDriveForward command - drives forwards
   * @param drive using the specified subsystem
   * @param driveUntil until the specified time
   * @param driveSpeed at the specified speed (multiplied by -1)
   */
  public AutoDriveForward(DriveSubsystem drive, double driveUntil, double driveSpeed) {
    _driveSub = drive;
    _drive = _driveSub.getDDrive();
    _time = driveUntil;
    _speed = driveSpeed;
    _t.stop();
    _t.reset();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _t.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    do{
      _drive.arcadeDrive(_speed * -1, 0.0);
    }while (_t.get() <= _time);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    _drive.arcadeDrive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (_t.get() <= _time);
  }
}
