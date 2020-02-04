/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public final class Constants {
    public static final class TelescopeConstants {
        // TODO set these correct
        public static final int UP_SWITCH_CHANNEL = 0;
        public static final int DOWN_SWITCH_CHANNEL = 0;
        public static final int TALON_CAN_CHANNEL = 9;
        public static final boolean UP_SWITCH_INVERTED = false;
        public static final boolean DOWN_SWITCH_INVERTED = false;
    }

    public static final class ControllerConstants {
        public static final int DRIVER_STICK_CHANNEL = 0;
    }

    public static final class HopperConstants {
        public static final int VICTOR_CAN_TOP = 6;
        public static final int VICTOR_CAN_BOTTOM = 7;
        /**
         * ControlMode.PercentOutput Value should range from 0 to 1; Ex 0.5 = 50%;
         */
        public static final double HOPPER_ADVANCE_SPEED = 0.1;
        public static final double HOPPER_HOLD_SPEED = 0.1;
        public static final double HOPPER_REVERSE_SPEED = 0.1;
    }
}
