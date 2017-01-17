package org.usfirst.frc.team2554.robot;
import java.lang.Math;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends SampleRobot {
	RobotDrive myRobot; //change this later
    Joystick controller;
    double averageXaxisMag, averageYaxisMag;
    final double DEADZONE = 0.15;

	public Robot() {
		myRobot.setExpiration(0.1);
		myRobot = new RobotDrive(IO.driveTrain[0], IO.driveTrain[1], IO.driveTrain[2], IO.driveTrain[3]);
		averageXaxisMag = 0;
		averageYaxisMag = 0;
	}

	public void robotInit() {

	}

	public void autonomous() {

	}

	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			if(controller.getRawAxis(IO.stickLeftX)/controller.getRawAxis(IO.stickLeftX) == -controller.getRawAxis(IO.stickLeftY)/controller.getRawAxis(IO.stickLeftY)){
				myRobot.mecanumDrive_Cartesian(0, 0, ( controller.getRawAxis(IO.stickLeftY) - controller.getRawAxis(IO.stickLeftY) ) / 2.0, 0);
			}
			else{
				if(Math.abs(controller.getRawAxis(IO.stickLeftX)) > DEADZONE && Math.abs(controller.getRawAxis(IO.stickRightX)) > DEADZONE)
					averageXaxisMag = ( controller.getRawAxis(IO.stickLeftX) + controller.getRawAxis(IO.stickRightX) ) / 2.0;
				if(Math.abs(controller.getRawAxis(IO.stickLeftY)) > DEADZONE && Math.abs(controller.getRawAxis(IO.stickRightY)) > DEADZONE)
				averageYaxisMag = ( controller.getRawAxis(IO.stickLeftY) + controller.getRawAxis(IO.stickLeftY) ) / 2.0;
				myRobot.mecanumDrive_Cartesian(averageXaxisMag, averageYaxisMag, 0, 0);
			}
		}
	}

	public void test() {
	}
}
