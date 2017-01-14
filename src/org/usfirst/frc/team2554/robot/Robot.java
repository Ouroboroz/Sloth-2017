package org.usfirst.frc.team2554.robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends SampleRobot {
	RobotDrive myRobot = new RobotDrive(0, 1); //change this later
    Joystick controller;
    double averageXaxisMag, averageYaxisMag;

	public Robot() {
		myRobot.setExpiration(0.1);
	}

	public void robotInit() {

	}

	public void autonomous() {

	}

	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
            averageXaxisMag = ( controller.getRawAxis(1) + controller.getRawAxis(4) ) / 2.0;
            averageYaxisMag = ( controller.getRawAxis(2) + controller.getRawAxis(5) ) / 2.0;
            // myRobot.mecanumDrive_Polar();
		}
	}

	public void test() {
	}
}
