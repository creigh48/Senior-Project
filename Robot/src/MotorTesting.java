import java.io.*;

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;
import lejos.nxt.Button;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

public class MotorTesting {
	
	private static final int positionMinus90 = -90;
	private static final int positionMinus45 = -45;
	private static final int position0 = 0;   //for the arms
	private static final int position45 = 45;
	private static final int position90 = 90;
	
	private static BTConnection btc; //bluetooth
	private static DataInputStream dis;
	private static DataOutputStream dos;
	
	public static void main(String[] args){
		
		Motor.A.setSpeed(120); //rake
		Motor.B.setSpeed(120); //arm
		
		

				
		Button.waitForAnyPress();
	}
	
	private static void testMotors(){
		
		int i = 0;
		while(i < 1){
		Delay.msDelay(250);
		moveMotors(position45,positionMinus45);
		Delay.msDelay(250);
		moveMotors(position90,position45);
		Delay.msDelay(250);
		moveMotors(positionMinus45,positionMinus90);
		Delay.msDelay(250);
		moveMotors(position45,positionMinus45);
		i++;
		}
	}
	
	public static int moveMotors(int motorA, int motorB){
		
		motorA(motorA);
		motorB(motorB);
		return Motor.C.getTachoCount();
	}
	
	private static int motorA(int degree){
		
		Motor.A.rotateTo(degree);
		return Motor.C.getTachoCount();

	}
	
	private static int motorB(int degree){
		
		Motor.B.rotateTo(degree);
		return Motor.C.getTachoCount();

	}
	
}
