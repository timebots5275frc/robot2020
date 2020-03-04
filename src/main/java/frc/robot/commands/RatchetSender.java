/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Winch;

public class RatchetSender extends CommandBase {
  private Winch _win;
  private double _time = 5.0;

  /**
   * Creates a new RatchetSender
   * 
   * @param win  the winch subsystem to use
   * @param time the match time, in seconds,
   */
  public RatchetSender(Winch win, double time) {
    _win = win;
    _time = time;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _win.getSolenoid().set(Value.kReverse);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Timer.getMatchTime() <= _time) {
      _win.getSolenoid().set(Value.kForward);
      System.out.println("*** RATCHET at " + _time + "s remaining ***");
    }
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
