/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class IntakeSet extends CommandBase {

  private Intake subsystem;
  private int state;

  /**
   * Creates a new IntakeSet.
   */
  public IntakeSet(Intake subsystem, int state) {
    this.subsystem = subsystem;
    this.state = state;
    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (state == 0) {
      subsystem.getSolenoid().set(false);
      subsystem.getVictor().set(ControlMode.PercentOutput, 0);
    }

    if (state == 1) {
      subsystem.getSolenoid().set(true);
      subsystem.getVictor().set(ControlMode.PercentOutput, 0.3);
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
