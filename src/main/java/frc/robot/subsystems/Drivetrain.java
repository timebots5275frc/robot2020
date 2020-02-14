// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

public class DriveTrain extends Subsystem {

    private WPI_TalonSRX rightTalon1;
    private WPI_VictorSPX rightVictor2;
    private SpeedControllerGroup speedControllerGroup2;
    private WPI_TalonSRX leftTalon3;
    private WPI_VictorSPX leftVictor4;
    private SpeedControllerGroup speedControllerGroup1;
    private DifferentialDrive differentialDrive1;

    public DriveTrain() {
        rightTalon1 = new WPI_TalonSRX(1);

        rightVictor2 = new WPI_VictorSPX(2);

        speedControllerGroup2 = new SpeedControllerGroup(rightTalon1, rightVictor2);
        addChild("Speed Controller Group 2", speedControllerGroup2);

        leftTalon3 = new WPI_TalonSRX(3);

        leftVictor4 = new WPI_VictorSPX(4);

        speedControllerGroup1 = new SpeedControllerGroup(leftTalon3, leftVictor4);
        addChild("Speed Controller Group 1", speedControllerGroup1);

        differentialDrive1 = new DifferentialDrive(speedControllerGroup1, speedControllerGroup2);
        addChild("Differential Drive 1", differentialDrive1);
        differentialDrive1.setSafetyEnabled(true);
        differentialDrive1.setExpiration(0.1);
        differentialDrive1.setMaxOutput(1.0);

    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new TeleopDrive());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public DifferentialDrive getDDrive() {
        return differentialDrive1;
    }
}
