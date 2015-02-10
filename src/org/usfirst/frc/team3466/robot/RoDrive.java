package org.usfirst.frc.team3466.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.*;
import org.usfirst.frc.team3466.robot.PortDefinitions;

public class RoDrive extends Subsystem {
	RobotDrive myRobot;
	DriverStation joystick;
	Joystick DualAct_Stick;
	Joystick Attack_Stick;
	Joystick Xbox_Control;
	public void init()
	{
		DualAct_Stick = new Joystick(PortDefinitions.JoyStickDualAct);
		Attack_Stick = new Joystick(PortDefinitions.JoyStickAttack);
		Xbox_Control = new Joystick(PortDefinitions.JoyStickXbox);
		/*//if(DriverStation.getStickAxisCount(PortDefinitions.JoyStickAttack) > 0){
			
		//}
	myRobot.tankDrive(-leftStick.getY(), -leftStick.getThrottle()); 
	System.out.println(" "+leftStick.getY()+" :Y-Axis "+leftStick.getThrottle()+" :Throttle-Axis");
*/	}
	
	@Override
	protected void initDefaultCommand() { }

}
