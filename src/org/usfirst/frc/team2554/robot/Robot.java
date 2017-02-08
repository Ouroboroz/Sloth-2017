package org.usfirst.frc.team2554.robot;

//Daniel's Code
import java.lang.Math;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SampleRobot;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Joystick;
public class Robot extends SampleRobot {
	RobotDrive myRobot; //change this later
    Joystick controller;
    double averageXaxisMag, averageYaxisMag;
    final double DEADZONE = 0.15;
	DigitalInput limitSwitch;
	Victor shooterL, shooterR, hopper2;
    
=======
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Robot extends SampleRobot {
	RobotDrive myRobot; // change this later
	Joystick controller;
	double averageXaxisMag, averageYaxisMag, averageZaxisMag;
	final double DEADZONE = 0.15;
	Victor intake;
	//ADXRS450_Gyro gyro;
	AnalogInput ai;

>>>>>>> origin/master
	public Robot() {
		myRobot = new RobotDrive(IO.driveTrain[0], IO.driveTrain[1], IO.driveTrain[2], IO.driveTrain[3]);
		averageXaxisMag = 0;
		averageYaxisMag = 0;
		controller = new Joystick(IO.controllerPort);
<<<<<<< HEAD
    	limitSwitch = new DigitalInput(1);
    	shooterL = new Victor(IO.shooter1);
    	shooterR = new Victor(IO.shooter2);
    	hopper2 = new Victor(IO.hopper);

	}

	public void robotInit() {
		
=======
		intake = new Victor(IO.rollerPort);
		//gyro = new ADXRS450_Gyro();
		ai = new AnalogInput(0);
	}

	public void robotInit() {
		//gyro.calibrate();
>>>>>>> origin/master
	}

	public void autonomous() {

	}

	public void operatorControl() {
		myRobot.setSafetyEnabled(true);
		AnalogInput.setGlobalSampleRate(0.5);
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
			
			if (thanksArjun%50 == 0){
				System.out.println("Thanks for nothing arjuns: " + ai.getVoltage());
				//System.out.println("Thanks for nothing dan: " + ai.getVoltage());
			}
<<<<<<< HEAD
			//For later: Rght trg is Axis 3
			//Victor
			if(controller.getRawAxis(3) > 0.8)
			{
				shooterL.set(0.6);
				shooterR.set(0.6);
				//Timer.delay(0.5);
				hopper2.set(0.6);
			}
			else
			{
				shooterL.set(0.0);
				shooterR.set(0.0);
				//hopper2.set(0.3);
				if(limitSwitch.get())//Checks state of limit switch
					hopper2.set(0.0);
			}
=======
			thanksArjun++;
			myRobot.setExpiration(.1);
>>>>>>> origin/master
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
