/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class TelescopeSeek extends CommandBase {

  final int _pos;
  /**
   * Creates a new TelescopeSeek.
   * @param pos the encoder position the command will seek to
   */
  public TelescopeSeek(int pos) {
    // addRequirements(RobotContainer.telescope);
    _pos = pos;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // maybe implement a cancel of other TelescopeSeek objects here?
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!(RobotContainer.telescope.getUpSwitch()) && !(RobotContainer.telescope.getUpSwitch())){
      RobotContainer.telescope.getMotor().set(ControlMode.Position, _pos);
    }
    else RobotContainer.telescope.getMotor().set(ControlMode.PercentOutput, 0.0); // TODO implement further
    
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
