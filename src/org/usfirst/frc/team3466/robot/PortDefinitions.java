package org.usfirst.frc.team3466.robot;


public class PortDefinitions {
	
	public static final int JoyStickLeftStick = 0;
	public static final int JoyStickRightStick = 1;
	
	public static final int JSbuttonCarrUp = 1;
	public static final int JSbuttonCarrDn = 2;
	public static final int JSbuttonRakeUp = 3;
	public static final int JSbuttonRakeDn = 4;

	// INPUTS - roboRIO Digital I/O channels
	public static final int CSconfifSwitch3 = 9;  // Robot SW configuration switches
	public static final int CSconfifSwitch2 = 8;
	public static final int CSconfifSwitch1 = 7;

	public static final int CarrDetTopChannel = 6;	// Carriage position detection
	public static final int CarrDetMidChannel = 5;
	public static final int CarrDetBtmChannel = 4;

	public static final int RakeDetTopChannel = 3;	// Rake Arm position detection
	public static final int RakeDetMidChannel = 2;
	public static final int RakeDetBtmChannel = 1;
	// UNUSED
	public static final int UnusedInputChannel = 0;

	// PWM OUTPUTS - roboRIO Channels
	public static final int UnusedOutput5 = 9;
	public static final int UnusedOutput4 = 8;
	public static final int UnusedOutput3 = 7;
	public static final int UnusedOutput2 = 6;
	public static final int UnusedOutput1 = 5;
	
	public static final int RakeMoveChannel = 4;	// RakeArm Movement
	public static final int CarrMoveChannel = 3;	// Carriage Movement

	public static final int DriveOutputChannelR  = 2;
	public static final int DriveOutputChannelL  = 1;
	// UNUSED
	public static final int UnusedOutput0 = 0;	
}