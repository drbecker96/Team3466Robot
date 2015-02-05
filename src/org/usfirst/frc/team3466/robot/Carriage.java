package org.usfirst.frc.team3466.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team3466.robot.PortDefinitions;

public class Carriage extends Subsystem {

	public Jaguar motor;
	private final double max_motor_speed = 1.0;
	
    DigitalInput carrDetTop;
    DigitalInput carrDetMid;
    DigitalInput carrDetBtm;
	
	public Carriage()
	{
		motor = new Jaguar(PortDefinitions.CarrMoveChannel);

		carrDetTop = new DigitalInput(PortDefinitions.CarrDetTopChannel);// all the way up
    	carrDetMid = new DigitalInput(PortDefinitions.CarrDetMidChannel);// somewhere in the middle
    	carrDetBtm = new DigitalInput(PortDefinitions.CarrDetBtmChannel);// all the way down
 	}
	
	public void init() {
	while(!carrDetBtm.get())
		moveDn();
	}
	public void moveUp() {
    	if (!carrDetTop.get()) 
    		motor.set(max_motor_speed);
    	else
    		motor.stopMotor();
	}
	public void moveDn() {
    	if (!carrDetBtm.get()) 
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
