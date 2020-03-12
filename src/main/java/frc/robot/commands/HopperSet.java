/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class HopperSet extends CommandBase {

    final Hopper _hopper;

    private WPI_VictorSPX hopperVictorTop;
    private WPI_VictorSPX hopperVictorBottom;

    private double _speed;

    /**
     * @param hopperSubsystem
     * @param speedPercent    Between -1 to 1
     */
    public HopperSet(Hopper hopperSubsystem, double speedPercent) {
        _hopper = hopperSubsystem;
        _speed = speedPercent;

        addRequirements(hopperSubsystem);
        hopperVictorTop = _hopper.getHopperVictorBottom();
        hopperVictorBottom = _hopper.getHopperVictorTop();
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {

    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        hopperVictorTop.set(ControlMode.PercentOutput, _speed);
        hopperVictorBottom.set(ControlMode.PercentOutput, _speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return false;
    }
}
