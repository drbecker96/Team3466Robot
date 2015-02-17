package org.usfirst.frc.team3466.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DigitalInput;

import org.usfirst.frc.team3466.robot.PortDefinitions;

public class Carriage extends Subsystem {

	Jaguar motorCarr;
	private final double max_motor_speed = 0.5;
	
    DigitalInput carrDetTop;
    DigitalInput carrDetBtm;
	
	public Carriage()
	{
		motorCarr = new Jaguar(PortDefinitions.CarrMoveChannel);

		carrDetTop = new DigitalInput(PortDefinitions.CarrDetTopChannel);// all the way up
    	
    	carrDetBtm = new DigitalInput(PortDefinitions.CarrDetBtmChannel);// all the way down
 	}
	
	public void init() {
	/*while(!carrDetBtm.get())
		//moveDn();
	System.out.println("Running: init Carriage");
*/
	}
	public void moveUp(double Z) {
//    	if (carrDetTop.get())
		{
			if(Z <= 0.5){
				Z = 0.5;
			}
    		motorCarr.set(Z);
    		System.out.println("Running: moveUp motor Carriage ");
    	}
/*    	else{
    		motorCarr.stopMotor();
    		System.out.println("Running: moveUp motorStop Carriage. CarrTop Limit: "+carrDetTop.get());
    	}
*/
	}
	public void moveDn(double Z) {
  //  	if (carrDetBtm.get())    		
    	{ 
		    if(Z <= 0.05){
	    		Z = 0.05;
	    	}else if(Z >= 0.60){
	    		Z = 0.60;
	    	}
			motorCarr.set(-Z);
			System.out.println("Running: moveDn motor Carriage ");
		}
/*    	else
    	{
    		motorCarr.stopMotor();
    		System.out.println("Running: moveDn motorStop Carriage. CarrBtm Limit: "+carrDetBtm.get());
    	} 
*/
	}
	public void stop() {
		motorCarr.stopMotor();
//		System.out.println("Running: stop motorStop Carriage ");
	}

	@Override
	protected void initDefaultCommand() { }
}
