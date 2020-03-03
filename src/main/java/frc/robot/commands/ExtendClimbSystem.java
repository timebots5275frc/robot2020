/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.WinchConstants;
import frc.robot.Constants.TelescopeConstants;
import frc.robot.subsystems.Telescope;
import frc.robot.subsystems.Winch;

public class ExtendClimbSystem extends CommandBase {
  Winch _win;
  Telescope _tele;
  int _pos;
  int _c = 0;
  /**
   * Determines whether or not we can drive the winch immediately. This is useful
   * when retracting to zero from full extension as the telescope might break.
   */
  boolean canWinch = true;

  /**
   * The ratio of winch drum rotations necessary for each telescope rotation to
   * ensure the winch follows the telescope
   */
  final double WINCH_PER_TELE = TelescopeConstants.TELE_DRUM_CIRCUMFERENCE / WinchConstants.WINCH_DRUM_CIRCUMFERENCE;
  /**
   * The inverse of WINCH_PER_TELE
   * 
   */
  final double TELE_PER_WINCH = 1 / WINCH_PER_TELE;

  /**
   * Creates a new ExtendClimbSystem.
   * 
   * @param telescopePosition the position, in encoder counts, for the provided
   *                          telescope subsystem to seek to.
   */
  public ExtendClimbSystem(Telescope tele, Winch win, int telescopePosition) {
    // Use addRequirements() here to declare subsystem dependencies.
    _tele = tele;
    _win = win;
    _pos = telescopePosition;
    addRequirements(_tele);
    addRequirements(_win);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("init ECS");
    if ((_pos - _tele.getMotor().getSelectedSensorPosition()) < -4096) { // if the difference is more than one rotation
                                                                         // to the negative, wait one second to begin
                                                                         // driving the winch
      canWinch = false;
      System.out.println("set canWinch to false");
    } else
      canWinch = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (_c >= 20)
      canWinch = true;

    _tele.getMotor().set(ControlMode.Position, _pos);
    if (canWinch)
      _win.getMotor().set(ControlMode.Position, _tele.getMotor().getSelectedSensorPosition() * WINCH_PER_TELE);
    else
      _c += 1;

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
