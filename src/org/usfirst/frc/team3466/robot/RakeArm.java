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
	
	public void moveUp()
    {	// set rake motor direction to UP (IN)
    	if (!rakeDetTop.get()) 
    		motorRake.set(max_motor_speed);
    	else
    		motorRake.stopMotor();
    }
    
	public void moveDn()
    {	// set rake motor direction to UP (IN)
    	if (!rakeDetTop.get()) 
    		motorRake.set(-max_motor_speed);
    	else
    		motorRake.stopMotor();
    }
	public void stop() {
		motorRake.stopMotor();
	}
	@Override
	protected void initDefaultCommand() { }	
}
