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


import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.Constants.TelescopeConstants;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Telescope extends Subsystem {

private WPI_TalonSRX _talon;
private DigitalInput downSwitch;
private DigitalInput upSwitch;


    public Telescope() {
        _talon = new WPI_TalonSRX(Constants.TelescopeConstants.TALON_CAN_CHANNEL);
        downSwitch = new DigitalInput(Constants.TelescopeConstants.DOWN_SWITCH_CHANNEL);
        upSwitch = new DigitalInput(Constants.TelescopeConstants.UP_SWITCH_CHANNEL);
        _talon.
        // TODO configure Talon PID
    }

    @Override
    public void initDefaultCommand() {
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }


    public WPI_TalonSRX getMotor(){
        return _talon;
    }
    public boolean getUpSwitch(){
        if (Constants.TelescopeConstants.UP_SWITCH_INVERTED)
            return !upSwitch.get();
        else return upSwitch.get();
    }    
    public boolean getDownSwitch(){
        if (Constants.TelescopeConstants.DOWN_SWITCH_INVERTED)
            return !downSwitch.get();
        else return downSwitch.get();
    }

}

