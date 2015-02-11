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
	RakeArm rakeArm;
	Carriage carriage;
    public static RobotDrive myRobot;
    RoDrive Robo;
    Joystick leftStick;
   // Joystick rightStick;
    JoystickButton buttonCarrUp;
    JoystickButton buttonCarrDn;
    JoystickButton buttonRakeUp;
    JoystickButton buttonRakeMid;
    JoystickButton buttonRakeDn;
    public int JoyaxisCount;
    
	static int m_autoPeriodicLoop;
    final static double motorSpeed = 0.2;// during autonomous
    
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
//    	myRobot.setExpiration(0.1); - TODO - is this necessary?
    	//leftStick = new Joystick(PortDefinitions.JoyStickAttack);
    	//rightStick = new Joystick(PortDefinitions.JoyStickRightStick);

    	buttonCarrUp = new JoystickButton(RoDrive.port, PortDefinitions.JSbuttonCarrUp);
    	buttonCarrDn = new JoystickButton(RoDrive.port, PortDefinitions.JSbuttonCarrDn);
    	buttonRakeUp = new JoystickButton(RoDrive.port, PortDefinitions.JSbuttonRakeUp);
    	buttonRakeDn = new JoystickButton(RoDrive.port, PortDefinitions.JSbuttonRakeDn);
    	
    	rakeArm = new RakeArm();
    	rakeArm.init();
    	carriage = new Carriage();
    	carriage.init();
    	Robo = new RoDrive();
    	Robo.init();

      	configSwitch3 = new DigitalInput(9);	// Robot SW configuration switches
    	configSwitch2 = new DigitalInput(8);
    	configSwitch1 = new DigitalInput(7);	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousInit() {
		m_autoPeriodicLoop = 0;
		// add this line to keep the motor running without setting speed in every periodic
		myRobot.setSafetyEnabled(false);		
		// I suspect this is not a legal thing to do at a competition
    }
    public void autonomousPeriodic() {
    	m_autoPeriodicLoop++;
    	if (isEnabled()) {
    		if (m_autoPeriodicLoop < 400)
    		{
    			if (m_autoPeriodicLoop < 200) {
	    	    	if (m_autoPeriodicLoop >= 000 && m_autoPeriodicLoop < 100)
	    	    	    ntDrive.moveFwd(motorSpeed);
	    	    	else if (m_autoPeriodicLoop >= 100 && m_autoPeriodicLoop < 125)
	    	    	    ntDrive.stop(); 
	    	    	else if (m_autoPeriodicLoop >= 125 && m_autoPeriodicLoop < 175)
	    	    		ntDrive.turnRight(motorSpeed);
	    	    	else // if (m_autoPeriodicLoop >= 175 && m_autoPeriodicLoop < 200)
	    	    		ntDrive.stop();
    			} else {
	    	    	if (m_autoPeriodicLoop >= 200 && m_autoPeriodicLoop < 300)
	    	    	    ntDrive.moveFwd(motorSpeed);
	    	    	else if (m_autoPeriodicLoop >= 300 && m_autoPeriodicLoop < 325)
	    	    	    ntDrive.stop();
	    	    	else if (m_autoPeriodicLoop >= 325 && m_autoPeriodicLoop < 375)
	    	    		ntDrive.turnRight(motorSpeed);
	    	    	else // if (m_autoPeriodicLoop >= 375 && m_autoPeriodicLoop < 400)
	    	    	    ntDrive.stop();
    			}
    		} else {
    			if (m_autoPeriodicLoop < 600) {
	    	    	if (m_autoPeriodicLoop >= 400 && m_autoPeriodicLoop < 500)
	    	    	    ntDrive.moveFwd(motorSpeed);    			
			       	else if (m_autoPeriodicLoop >= 500 && m_autoPeriodicLoop < 525)
			       		ntDrive.stop();
			    	else if (m_autoPeriodicLoop >= 525 && m_autoPeriodicLoop < 575)
			    	    ntDrive.turnRight(motorSpeed);
			    	else // if (m_autoPeriodicLoop >= 575 && m_autoPeriodicLoop < 600)
			    	    ntDrive.stop();
    			} else {
			    	if (m_autoPeriodicLoop >= 600 && m_autoPeriodicLoop < 700)
			    	    ntDrive.moveFwd(motorSpeed);
			    	else if (m_autoPeriodicLoop >= 700 && m_autoPeriodicLoop < 725)
			    		ntDrive.stop();
			    	else if (m_autoPeriodicLoop >= 725 && m_autoPeriodicLoop < 775)
			    	    ntDrive.turnRight(motorSpeed);
			    	else 
			    		ntDrive.stop();
    			}
    	    }
    	}
	}// end autonomousPeriodic
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        if (isOperatorControl() && isEnabled()) {
        	// Set the motor's output.
        	// This takes a number from -1 (100% speed in reverse) to +1 (100% speed going forward)
        	//myRobot.arcadeDrive(-RoDrive.LY, RoDrive.RY);
        	Robo.Drive(RoDrive.Drive);
        	System.out.println(" "+RoDrive.LY+" :Left-Axis "+RoDrive.RY+" :Right-Axis");
        	
        	
        if (buttonCarrUp.get()){ 
        	carriage.moveUp();
        }
        else if (buttonCarrDn.get()){
        	carriage.moveDn();
        }
        else{
        	carriage.stop(); //Unknown Errors: nullPointer Exception
        }

        if (buttonRakeUp.get()){
        	rakeArm.moveUp();
        }
        else if (buttonRakeDn.get()){
        	
        	rakeArm.moveDn();
        }
        else{
        	rakeArm.stop(); //Unknown Errors: nullPointer Exception
        }
        }
    } // end teleopPeriodic

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	System.out.println("We dont need no stinkin' test! - Our machine just works");
    /**
     * This function is called periodically during test mode
     */
    } 
    
}
