package org.usfirst.frc.team3466.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;

import org.usfirst.frc.team3466.robot.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	NTDrive ntDrive;
//	RakeArm rakeArm;
	Carriage carriage;
    public static RobotDrive myRobot;
//  RoDrive Robo;
    Joystick leftStick;
    JoystickButton buttonCarrUp;
    JoystickButton buttonCarrDn;
	static int m_autoPeriodicLoop;
    final static double motorSpeed = 0.30;// 0.2;// way too slow - during autonomous
    
    DigitalInput configSwitch1;
    DigitalInput configSwitch2;
    DigitalInput configSwitch3;
 	
	/**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	ntDrive = new NTDrive();
    	myRobot = new RobotDrive(ntDrive.motorL, ntDrive.motorR);
    	leftStick = new Joystick(PortDefinitions.JoyStickAttack);

    	buttonCarrUp = new JoystickButton(leftStick, PortDefinitions.JSbuttonCarrUp);
    	buttonCarrDn = new JoystickButton(leftStick, PortDefinitions.JSbuttonCarrDn);
    	carriage = new Carriage();
    	carriage.init();

/*    	configSwitch3 = new DigitalInput(9);	// Robot SW configuration switches
    	configSwitch2 = new DigitalInput(8);
    	configSwitch1 = new DigitalInput(7);	
 */   }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousInit() {
		m_autoPeriodicLoop = 0;
		// add this line to keep the motor running without setting speed in every periodic
		myRobot.setSafetyEnabled(true);
		// I suspect setting this to false is not a legal thing to do during a competition
    }
    public void autonomousPeriodic() {
    	m_autoPeriodicLoop++;
    	if (isEnabled()) {
    		if (m_autoPeriodicLoop < 300)
    			myRobot.arcadeDrive(0.5, -0.235);// try to compensate for different wheel speeds on each side
    		else
    			myRobot.stopMotor();
    	}
	}// end autonomousPeriodic
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        if (isOperatorControl() && isEnabled()) {
        	// Set the motor's output.
        	// This takes a number from -1 (100% speed in reverse) to +1 (100% speed going forward)
        	double 
        		dx = leftStick.getRawAxis(PortDefinitions.Ext3DX),
        		dy = leftStick.getRawAxis(PortDefinitions.Ext3DY);
        			
        	myRobot.arcadeDrive(-dy, -dx);
//        	System.out.println(" " + dy +" :DY Axis "+ dx + " : DX -Axis");
        	
	        	
	        if (buttonCarrUp.get()){ 
	        	double rslt = leftStick.getRawAxis(PortDefinitions.Ext3DSlide);
//	        	System.out.println("Carriage Up pwr : " + rslt);
	        	carriage.moveUp(-rslt);
	        }
	        else if (buttonCarrDn.get()){
	        	double rslt = leftStick.getRawAxis(PortDefinitions.Ext3DSlide);
//	        	System.out.println("Carriage Dn pwr : " + rslt);
	        	carriage.moveDn(-rslt);
	        }
	        else{
	        	carriage.stop();
	        }
        }
    } // end teleopPeriodic

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	System.out.println("We dont need no stinkin' test! - Our machine just works");

    } 
    
}
