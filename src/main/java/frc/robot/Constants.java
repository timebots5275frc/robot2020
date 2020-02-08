/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

/**
 * Add your docs here.
 */
public final class Constants {
    public static final class TelescopeConstants{
        // TODO set these correct
        public static final int UP_SWITCH_CHANNEL = 0;
        public static final int DOWN_SWITCH_CHANNEL = 0;
        public static final int TALON_CAN_CHANNEL = 9;
        public static final boolean UP_SWITCH_INVERTED = false;
        public static final boolean DOWN_SWITCH_INVERTED = false;
        private static final TalonSRXConfiguration TELE_SRX_CONFIG = new TalonSRXConfiguration();

        public static final double TELE_DRUM_CIRCUMFERENCE = Math.PI * .75; // pi * .75" dia

        public static TalonSRXConfiguration getConfig(){
            // TODO tune these values
            TELE_SRX_CONFIG.primaryPID.selectedFeedbackSensor = FeedbackDevice.CTRE_MagEncoder_Absolute;
            TELE_SRX_CONFIG.neutralDeadband = 0.0;
            TELE_SRX_CONFIG.slot0.kP = 0.0;
            TELE_SRX_CONFIG.slot0.kI = 0.0;
            TELE_SRX_CONFIG.slot0.kD = 0.0;
            TELE_SRX_CONFIG.slot0.integralZone = 400;
            TELE_SRX_CONFIG.slot0.closedLoopPeakOutput = 1.0;
            TELE_SRX_CONFIG.closedloopRamp = .5;
            TELE_SRX_CONFIG.openloopRamp = .5;
            return TELE_SRX_CONFIG;
        }
    }
    public static final class ControllerConstants{
        public static final int DRIVER_STICK_CHANNEL = 0;
    }
}
