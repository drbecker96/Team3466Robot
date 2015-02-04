package org.usfirst.frc.team3466.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class NTDrive extends Subsystem {
	public Talon motorL;
	public Talon motorR;
	
	public NTDrive()
	{
		motorL = new Talon(PortDefinitions.DriveOutputChannelL);
		motorR = new Talon(PortDefinitions.DriveOutputChannelR);
	}
	
	public void moveFwd(double val) {
		 motorL.set(val); 
		 motorR.set(-val); // negative because the motors face in opposite directions
	}
	public void turnRight(double val) {
		motorL.set(val); // forwards
		motorR.set(val); // backwards
	}
	public void turnLeft(double val) {
		motorL.set(-val); // backwards
		motorR.set(-val); // forwards
	}
	public void stop() {
		motorL.set(0.0);
		motorR.set(0.0);
	}	
	public void setLR(double valL, double valR) {
		motorL.set(valL);
		motorR.set(-valR); // negative because the motors face in opposite directions
	}
	@Override
	protected void initDefaultCommand() { }
}
