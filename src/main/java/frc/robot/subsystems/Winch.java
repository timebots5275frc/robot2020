
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.WinchConstants;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;

/**
 *
 */
public class Winch extends SubsystemBase {

	private WPI_TalonSRX winchTalon10;
	private WPI_VictorSPX winchVictor11;
	private DigitalInput limitSwitch2;

	private DoubleSolenoid solenoidRatchet;

	public Winch() {
		winchTalon10 = new WPI_TalonSRX(WinchConstants.WINCH_TALON_CHANNEL);
		winchVictor11 = new WPI_VictorSPX(WinchConstants.WINCH_VICTOR_CHANNEL);
		limitSwitch2 = new DigitalInput(WinchConstants.WINCH_LIMIT_CHANNEL);
		addChild("limitSwitch2", limitSwitch2);

		winchTalon10.configAllSettings(WinchConstants.getConfig());
		winchTalon10.setSensorPhase(true);
		winchTalon10.setInverted(InvertType.InvertMotorOutput);
		winchVictor11.follow(winchTalon10);
		winchVictor11.setInverted(InvertType.OpposeMaster); // inverse of the master
		winchTalon10.setNeutralMode(NeutralMode.Brake);
		winchVictor11.setNeutralMode(NeutralMode.Brake);
		zeroMotor();

		solenoidRatchet = new DoubleSolenoid(1, 7, 0);
		addChild("solenoidRatchet", solenoidRatchet);
	}

	@Override
	public void periodic() {
		// Put code here to be run every loop
	}

	/**
	 * DoubleSolenoid
	 * 
	 * @return the ratchet solenoid
	 */
	public DoubleSolenoid getSolenoid() {
		return solenoidRatchet;
	}

	public double rotationToPull(double rotations) {
		return rotations * WinchConstants.WINCH_DRUM_CIRCUMFERENCE;
	}

	public double pullToRotations(double pull) {
		return pull / WinchConstants.WINCH_DRUM_CIRCUMFERENCE;
	}

	public double rotationsToEnc(double rotations) {
		return rotations * 4096;
	}

	public WPI_TalonSRX getMotor() {
		return winchTalon10;
	}

	/**
	 * sets the master talon sensor position to zero
	 */
	public void zeroMotor() {
		winchTalon10.setSelectedSensorPosition(0);
	}

}
