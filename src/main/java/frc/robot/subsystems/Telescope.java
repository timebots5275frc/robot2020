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

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import static frc.robot.Constants.TelescopeConstants;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Telescope extends SubsystemBase {

    private WPI_TalonSRX _talon;
    private DigitalInput downSwitch;
    private DigitalInput upSwitch;

    public Telescope() {
        _talon = new WPI_TalonSRX(TelescopeConstants.TALON_CAN_CHANNEL);
        downSwitch = new DigitalInput(TelescopeConstants.DOWN_SWITCH_CHANNEL);
        upSwitch = new DigitalInput(TelescopeConstants.UP_SWITCH_CHANNEL);
        _talon.configAllSettings(TelescopeConstants.getConfig());
        _talon.setSelectedSensorPosition(0);
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public WPI_TalonSRX getMotor() {
        return _talon;
    }

    /**
     * gets the state of up limit switch
     * 
     * @return false if it is "safe" to continue moving, true if movement should be
     *         stopped
     */
    public boolean getUpSwitch() {
        if (TelescopeConstants.UP_SWITCH_INVERTED)
            return !upSwitch.get();
        else
            return upSwitch.get();
    }

    /**
     * gets the state of down limit switch
     * 
     * @return false if it is "safe" to continue moving, true if movement should be
     *         stopped
     */
    public boolean getDownSwitch() {
        if (TelescopeConstants.DOWN_SWITCH_INVERTED)
            return !downSwitch.get();
        else
            return downSwitch.get();
    }

}
