package org.usfirst.frc.team2554.robot;

//Daniel's Code
import java.lang.Math;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Robot extends SampleRobot {
	RobotDrive myRobot; // change this later
	Joystick controller;
	double averageXaxisMag, averageYaxisMag, averageZaxisMag;
	final double DEADZONE = 0.15;
	Victor intake;
	ADXRS450_Gyro gyro;

	public Robot() {
		myRobot = new RobotDrive(IO.driveTrain[0], IO.driveTrain[1], IO.driveTrain[2], IO.driveTrain[3]);
		averageXaxisMag = 0;
		averageYaxisMag = 0;
		controller = new Joystick(IO.controllerPort);
		intake = new Victor(IO.rollerPort);
		gyro = new ADXRS450_Gyro();
	}

	public void robotInit() {
		gyro.calibrate();
	}

	public void autonomous() {

	}

	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		int thanksArjun = 0;
//		gyro.reset();
//		gyro.calibrate();
		while (isOperatorControl() && isEnabled()) {
			if (checkSign(isAboveDeadZone(controller.getRawAxis(IO.stickLeftX))) == checkSign(
					isAboveDeadZone(controller.getRawAxis(IO.stickRightX)))) {
				averageXaxisMag = (isAboveDeadZone(controller.getRawAxis(IO.stickLeftX))
						+ isAboveDeadZone((controller.getRawAxis(IO.stickRightX)))) / 2.0;
			}
			if (checkSign(isAboveDeadZone(controller.getRawAxis(IO.stickLeftY))) == checkSign(
					isAboveDeadZone(controller.getRawAxis(IO.stickRightY)))) {
				averageYaxisMag = (isAboveDeadZone(controller.getRawAxis(IO.stickLeftY))
						+ isAboveDeadZone((controller.getRawAxis(IO.stickRightY)))) / 2.0;
				averageZaxisMag = 0;
			} else if (checkSign(isAboveDeadZone(controller.getRawAxis(IO.stickLeftY))) == -checkSign(
					isAboveDeadZone(controller.getRawAxis(IO.stickRightY)))) {
				averageZaxisMag = (isAboveDeadZone(controller.getRawAxis(IO.stickLeftY))
						- isAboveDeadZone((controller.getRawAxis(IO.stickRightY)))) / 2.0;
			} else {
				myRobot.mecanumDrive_Cartesian(0, 0, 0, 0);
			}
			myRobot.mecanumDrive_Cartesian(averageXaxisMag / 2.0, averageYaxisMag / 2.0, -(averageZaxisMag) / 2.0,
					0);

			if (controller.getRawButton(6)) // Right Bumper
				intake.setSpeed(-1.0);
			else
				intake.setSpeed(0.0);

			//System.out.println("Thanks for nothing, Dan: " + gyro.getAngle());

			myRobot.setExpiration(.1);
		}

	}

	public void test() {
	}

	public double isAboveDeadZone(double checkNum) {
		return (Math.abs(checkNum) > DEADZONE) ? checkNum : 0;
	}

	public int checkSign(double checkNum) {
		if (checkNum < 0)
			return -1;
		if (checkNum > 0)
			return 1;
		return 0;
	}
}
