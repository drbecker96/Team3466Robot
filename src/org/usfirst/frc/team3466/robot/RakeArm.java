package org.usfirst.frc.team3466.robot;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3466.robot.PortDefinitions;

public class RakeArm extends Subsystem{
	
	public Jaguar motor;
	private final double max_motor_speed = 1.0;
	
    DigitalInput rakeDetTop;
    DigitalInput rakeDetMid;
    DigitalInput rakeDetBtm;
    
	
	public RakeArm()
	{
		motor = new Jaguar(PortDefinitions.RakeMoveChannel);
		
		rakeDetTop = new DigitalInput(PortDefinitions.RakeDetTopChannel);
		rakeDetMid = new DigitalInput(PortDefinitions.RakeDetMidChannel);
		rakeDetBtm = new DigitalInput(PortDefinitions.RakeDetBtmChannel);		
	}
	public void init() {
	while(!rakeDetBtm.get())
		moveDn();
	}
	
	public void moveUp()
    {	// set rake motor direction to UP (IN)
    	if (!rakeDetTop.get()) 
    		motor.set(max_motor_speed);
    	else
    		motor.stopMotor();
    }
    
	public void moveDn()
    {	// set rake motor direction to UP (IN)
    	if (!rakeDetTop.get()) 
    		motor.set(-max_motor_speed);
    	else
    		motor.stopMotor();
    }
	public void stop() {
		motor.stopMotor();
	}
	@Override
	protected void initDefaultCommand() { }	
}
