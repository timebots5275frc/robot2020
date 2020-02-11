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
import frc.robot.subsystems.Spitter;

public class SpitterSet extends CommandBase {

  private int state;

  /**
   * Creates a new SpitterSet.\
   */
  public SpitterSet(int setState) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.state = setState;
    addRequirements(RobotContainer.spitter);
  }

  /**
   * @param state 0 in/stop, 1 out/deploy
   */
  public void setState(int setState) {
    this.state = setState;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Spitter subsystem = RobotContainer.spitter;

    if (state == 0) {
      subsystem.getTrapDoor().set(true);
      subsystem.getVictor().set(ControlMode.PercentOutput, 0);
    }

    if (state == 1) {
      subsystem.getTrapDoor().set(false);
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
