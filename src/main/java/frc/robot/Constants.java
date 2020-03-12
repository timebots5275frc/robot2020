/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;

/**
 * Add your docs here.
 */
public final class Constants {

    /**
     * @Title DriveTrainConstants
     */
    public static final class DriveTrainConstants {
        public static final int RIGHT_TALON = 1;
        public static final int RIGHT_VICTOR = 2;
        public static final int LEFT_TALON = 3;
        public static final int LEFT_VICTOR = 4;
        public static final TalonSRXConfiguration TELE_SRX_CONFIG = new TalonSRXConfiguration();

        public static TalonSRXConfiguration getConfig() {
            // TODO tune these values
            TELE_SRX_CONFIG.closedloopRamp = 0;
            TELE_SRX_CONFIG.openloopRamp = 0;
            return TELE_SRX_CONFIG;
        }
    }

    /**
     * @Title TelescopeConstants
     */
    public static final class TelescopeConstants {
        // TODO set these correct
        public static final int UP_SWITCH_CHANNEL = 0;
        public static final int DOWN_SWITCH_CHANNEL = 1;
        public static final int TALON_CAN_CHANNEL = 9;
        public static final boolean UP_SWITCH_INVERTED = false;
        public static final boolean DOWN_SWITCH_INVERTED = false;
        private static final TalonSRXConfiguration TELE_SRX_CONFIG = new TalonSRXConfiguration();

        public static final int FULL_EXTENSION = 12 * 4096;

        public static final double TELE_DRUM_CIRCUMFERENCE = Math.PI * .75; // pi * .75" dia

        public static TalonSRXConfiguration getConfig() {
            // TODO tune these values
            TELE_SRX_CONFIG.primaryPID.selectedFeedbackSensor = FeedbackDevice.CTRE_MagEncoder_Absolute;
            TELE_SRX_CONFIG.neutralDeadband = 0.005;
            TELE_SRX_CONFIG.slot0.kP = 1.5;
            TELE_SRX_CONFIG.slot0.kI = 0.0;
            TELE_SRX_CONFIG.slot0.kD = 50000.0;
            TELE_SRX_CONFIG.slot0.integralZone = 400;
            TELE_SRX_CONFIG.slot0.closedLoopPeakOutput = 0.75; // TODO .75 ??
            TELE_SRX_CONFIG.closedloopRamp = .5;
            TELE_SRX_CONFIG.openloopRamp = .5;
            return TELE_SRX_CONFIG;
        }
    }

    /**
     * @Title ControllerConstants
     */
    public static final class ControllerConstants {
        public static final int DRIVER_STICK_CHANNEL = 0;
        public static final int AUX_STICK_CHANNEL = 1;
    }

    /**
     * @Title WinchConstants
     */
    public static final class WinchConstants {
        public static final int WINCH_VICTOR_CHANNEL = 11;
        public static final int WINCH_TALON_CHANNEL = 10;
        public static final int WINCH_LIMIT_CHANNEL = 2;
        public static final TalonSRXConfiguration WINCH_SRX_CONFIG = new TalonSRXConfiguration();
        /**
         * Circumference of winch drum in inches
         */
        public static final double WINCH_DRUM_CIRCUMFERENCE = 1.25 * Math.PI;

        public static TalonSRXConfiguration getConfig() {
            // TODO tune these values
            WINCH_SRX_CONFIG.primaryPID.selectedFeedbackSensor = FeedbackDevice.CTRE_MagEncoder_Absolute;
            WINCH_SRX_CONFIG.neutralDeadband = 0.005;
            WINCH_SRX_CONFIG.slot0.kP = 0.35;
            WINCH_SRX_CONFIG.slot0.kI = 0.0;
            WINCH_SRX_CONFIG.slot0.kD = 500000.0;
            WINCH_SRX_CONFIG.slot0.integralZone = 400;
            WINCH_SRX_CONFIG.slot0.closedLoopPeakOutput = 1.0;
            WINCH_SRX_CONFIG.closedloopRamp = .5;
            WINCH_SRX_CONFIG.openloopRamp = .5;
            WINCH_SRX_CONFIG.forwardLimitSwitchSource = LimitSwitchSource.Deactivated;
            WINCH_SRX_CONFIG.reverseLimitSwitchSource = LimitSwitchSource.Deactivated;
            return WINCH_SRX_CONFIG;
        }

        /**
         * s Ratchet
         */
        public static final int PCM_CHANNEL = 1;
        public static final int RATCHET_CHANNEL = 3;
    }

    /**
     * @Title HopperConstants
     */
    public static final class HopperConstants {

        public static final int HOPPER_ADVANCE_BUTTON = 6; // Temp button
        public static final int HOPPER_REVERSE_BUTTON = 4; // Temp button

        public static final int VICTOR_CAN_TOP = 6;
        public static final int VICTOR_CAN_BOTTOM = 7;

        // ControlMode.PercentOutput Value should range from 0 to 1; Ex 0.5 = 50%;
        public static final double HOPPER_ADVANCE_SPEED = 0.6;
        public static final double HOPPER_HOLD_SPEED = 0;
        public static final double HOPPER_REVERSE_SPEED = -0.50;

        /**
         * Minimum desired time to go from neutral to full throttle. A value of '0' will
         * disable the ramp.
         */
        public static final double VICTOR_RAMPING = 0.1;
    }

    /**
     * @Title SpitterConstants
     */
    public static final class SpitterConstants {
        public static final int SPITTER_TRAPDOOR_TOGGLE_BUTTON = 7; // Temp button
        public static final int VICTOR_CAN = 8;
        public static final int SOLENOID_CAN = 1;
        public static final double MAX_OUTPUT = 0.7;
    }

    /**
     * @Title IntakeConstants
     */
    public static final class IntakeConstants {
        public static final int INTAKE_VICTOR_CHANNEL = 5;
        public static final int SOLENOID_CHANNEL = 1; // Was 2
        public static final double INTAKE_SPEED = 0.3;

    }

}
