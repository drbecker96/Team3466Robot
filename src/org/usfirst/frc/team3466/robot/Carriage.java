package org.usfirst.frc.team3466.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team3466.robot.PortDefinitions;

public class Carriage extends Subsystem {

	Jaguar motorCarr;
	private final double max_motor_speed = 0.2;
	
    DigitalInput carrDetTop;
    DigitalInput carrDetMid;
    DigitalInput carrDetBtm;
	
	public Carriage()
	{
		motorCarr = new Jaguar(PortDefinitions.CarrMoveChannel);

		carrDetTop = new DigitalInput(PortDefinitions.CarrDetTopChannel);// all the way up
    	carrDetMid = new DigitalInput(PortDefinitions.CarrDetMidChannel);// somewhere in the middle
    	carrDetBtm = new DigitalInput(PortDefinitions.CarrDetBtmChannel);// all the way down
 	}
	
	public void init() {
	/*while(!carrDetBtm.get())
		//moveDn();
	System.out.println("Running: init Carriage");
*/
	}
	public void moveUp() {
    	//if (!carrDetTop.get()){ 
    		motorCarr.set(max_motor_speed);
    System.out.println("Running: moveUp motor Carriage ");
    	/*}
    	else{
    		motorCarr.stopMotor();
    System.out.println("Running: moveUp motorStop Carriage ");
    	}*/
	}
	public void moveDn() {
    	//if (!carrDetBtm.get()){ 
    		motorCarr.set(-max_motor_speed);
    System.out.println("Running: moveDn motor Carriage ");
		/*}
    	else{
    		motorCarr.stopMotor();
    System.out.println("Running: moveDn motorStop Carriage ");
    	}*/
	}
	public void stop() {
		motorCarr.stopMotor();
    System.out.println("Running: stop motorStop Carriage ");
	}

	@Override
	protected void initDefaultCommand() { }
}
