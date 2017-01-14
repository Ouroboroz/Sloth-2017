package org.usfirst.frc.team2554.robot;
import java.lang.Math;
public class Vector {
	private double x, y, magnitude, direction;
    public Vector(double magnitude, double direction, boolean isNorth) {
    	x = magnitude*Math.sin(direction/180.0*Math.PI);
    	y = magnitude*Math.cos(direction/180.0*Math.PI);
    	this.magnitude = magnitude;
    	this.direction = direction;
    }
    public Vector(double xVal, double yVal){
    	x = xVal;
    	y = yVal;
    	magnitude = Math.sqrt(x*x+y*y);
    	direction = Math.atan(x/y)*180.0/Math.PI;
    }
    
    public Vector add(Vector nVector){
    	return new Vector(x + nVector.returnVal(1),y + nVector.returnVal(2));
    }
    public Vector subtract(Vector nVector){
    	return new Vector(x - nVector.returnVal(1),y - nVector.returnVal(2));
    }
    public double returnVal(int num){
    	switch(num){
    	case 1:
    		return x;
    	case 2:
    		return y;
    	case 3:
    		return magnitude;
    	case 4:
    		return direction;
    	default:
    		return 0.0;
    	}
    }
}
