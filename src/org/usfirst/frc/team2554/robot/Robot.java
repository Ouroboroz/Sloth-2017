package org.usfirst.frc.team2554.robot;
import java.lang.Math;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
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
		controller = new Joystick(IO.controllerPort);
	}

	public void robotInit() {

	}

	public void autonomous() {

	}

	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		while (isOperatorControl() && isEnabled()) {
			//if both sticks are going in different directions
			if(checkSign(controller.getRawAxis(IO.stickLeftY)) == -checkSign(controller.getRawAxis(IO.stickRightY))){
				if(controller.getRawAxis(IO.stickLeftY) > DEADZONE && controller.getRawAxis(IO.stickRightY) > DEADZONE){
					averageYaxisMag = (controller.getRawAxis(IO.stickLeftY)-controller.getRawAxis(IO.stickRightY))/2.0;
				}
				else
					averageYaxisMag = 0;
				myRobot.mecanumDrive_Cartesian(0, 0, averageYaxisMag/5, 0);
			}
			//if both are going in same directions
			if(checkSign(controller.getRawAxis(IO.stickLeftX)) == checkSign(controller.getRawAxis(IO.stickRightX))){
				if(controller.getRawAxis(IO.stickLeftY) > DEADZONE && controller.getRawAxis(IO.stickRightX) > DEADZONE)
					averageXaxisMag = (controller.getRawAxis(IO.stickLeftX)+controller.getRawAxis(IO.stickRightX))/2.0;
				else
					averageXaxisMag = 0;
				if(controller.getRawAxis(IO.stickLeftY) > DEADZONE && controller.getRawAxis(IO.stickRightX) > DEADZONE)
					averageYaxisMag = (controller.getRawAxis(IO.stickLeftY)+controller.getRawAxis(IO.stickRightY))/2.0;
				else
					averageYaxisMag = 0;
				myRobot.mecanumDrive_Cartesian(averageXaxisMag/5, averageYaxisMag/5, 0, 0);
			}
			//press the A button for emergency shutdown B)
			if(controller.getRawButton(1)){
				myRobot.mecanumDrive_Cartesian(0, 0, 0, 0);
				myRobot.drive(0, 0);
			}
			//hehe some fun! :D
			if(controller.getRawButton(2)){
				controller.setRumble(RumbleType.kRightRumble, 0.5);
			}
		}
	}

	public void test() {
	}
	public int checkSign(double checkNum){
		if(checkNum < 0)
			return -1;
		if(checkNum > 0)
			return 1;
		return 0;
	}
}
