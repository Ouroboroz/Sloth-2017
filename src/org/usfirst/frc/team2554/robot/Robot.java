package org.usfirst.frc.team2554.robot;

//Daniel's Code
import java.lang.Math;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;

public class Robot extends SampleRobot {
	RobotDrive myRobot; // change this later
	Joystick controller;
	double averageXaxisMag, averageYaxisMag, averageZaxisMag;
	final double DEADZONE = 0.15;

	public Robot() {
		myRobot = new RobotDrive(IO.driveTrain[0], IO.driveTrain[1], IO.driveTrain[2], IO.driveTrain[3]);
		averageXaxisMag = 0;
		averageYaxisMag = 0;
		controller = new Joystick(IO.controllerPort);
	}

	public void robotInit() {

	}

	public void autonomous() {

	}

	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		int thanksArjun = 0;
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
				System.out.println("thanks for nothing arjun");
				System.out.println(thanksArjun++);
				// thanksArjun++;
			}
			myRobot.mecanumDrive_Cartesian(averageXaxisMag, averageYaxisMag / 2.0, averageZaxisMag / 2.0, 0);
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
