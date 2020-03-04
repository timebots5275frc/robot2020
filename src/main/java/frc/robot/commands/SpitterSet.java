/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Spitter;

public class SpitterSet extends CommandBase {
  private double state;
  private Spitter subsystem;

  /**
   * Creates a new SpitterSet.\
   */
  public SpitterSet(Spitter subsystem, double setting) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.state = setting;
    this.subsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    subsystem.getVictor().set(ControlMode.PercentOutput, state);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    subsystem.getVictor().set(ControlMode.PercentOutput, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
