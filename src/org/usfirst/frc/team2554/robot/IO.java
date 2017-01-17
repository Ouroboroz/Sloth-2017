package org.usfirst.frc.team2554.robot;

public class IO {
	//Controller Ports
	final public static int joystickPort = 0;
	final public static int controllerPort = 1;
	//Front Left, Back Left, Front Right, Back Right
	final static int driveTrain[] = {0,1,3,4};
	//Mapping of the Axis on the Joystick
		/*
		 1 is the L Y Axis
		 2 is L Trigger
		 3 is R Trigger
		 5 is the R Y Axis
		 */
		final public static int stickLeftX = 1;
		final public static int stickLeftY = 2;
		final public static int stickRightX = 4;
		final public static int stickRightY = 5;
	}
