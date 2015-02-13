package org.usfirst.frc.team3466.robot;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team3466.robot.PortDefinitions;

public class RakeArm extends Subsystem{
	
	public Jaguar motorRake;
	private final double max_motor_speed = 1.0;
	
    DigitalInput rakeDetTop;
    DigitalInput rakeDetBtm;
    
	
	public RakeArm()
	{
		motorRake = new Jaguar(PortDefinitions.RakeMoveChannel);
		
		rakeDetTop = new DigitalInput(PortDefinitions.RakeDetTopChannel);

		rakeDetBtm = new DigitalInput(PortDefinitions.RakeDetBtmChannel);		
	}
	public void init() {
	/*while(!rakeDetBtm.get())
		moveDn();
	*/
	}
	
	public void moveIn()
    {	// set rake motor direction to UP (IN)
    	if (!rakeDetTop.get()) 
    		motorRake.set(max_motor_speed);
    	else {
    		motorRake.stopMotor();
    		System.out.println("Running: moveUp motorStop RakeArm. RakeTop Limit: "+rakeDetTop.get());
    	}
    }
    
	public void moveOut()
    {	// set rake motor direction to UP (IN)
    	if (!rakeDetBtm.get()) 
    		motorRake.set(-max_motor_speed);
    	else {
    		motorRake.stopMotor();
    		System.out.println("Running: moveUp motorStop RakeArm. RakeBtm Limit: "+rakeDetBtm.get());
    	}
    }
	public void stop() {
		motorRake.stopMotor();
	}
	@Override
	protected void initDefaultCommand() { }	
}
