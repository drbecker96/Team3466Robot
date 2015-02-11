package org.usfirst.frc.team3466.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;

import org.usfirst.frc.team3466.robot.PortDefinitions;

public class RoDrive extends Subsystem {
	DriverStation joystick;
	Joystick PS3_Control;
	Joystick Attack_Stick;
	Joystick Xbox_Control;
	int axis;
	int button;
	int POV;
	int time;
	int count;
	public static Joystick port;
	public static double LY;
	public static double RY;
	public static String Control;
	public static int Drive; //arcade = 0, tank = 1, mecanum = 2

	public void init()
	{
		PS3_Control = new Joystick(PortDefinitions.JoyStickDualAct);
		Attack_Stick = new Joystick(PortDefinitions.JoyStickAttack);
		Xbox_Control = new Joystick(PortDefinitions.JoyStickXbox);
		Control = null;
		count = 0;
		Drive = -1;
		for(time = 0; port == null && count == 10; time = time++){	//Untested code -todo test code loop to see if it properly selects
			axis = joystick.getStickAxisCount(time);
			button = joystick.getStickButtonCount(time);
			POV = joystick.getStickPOVCount(time);
			if(axis == 4 && button == 12){
				port = Attack_Stick;
				LY = port.getRawAxis(PortDefinitions.Ext3DX);
				RY = port.getRawAxis(PortDefinitions.Ext3DY);
				Control = "Extreme 3D";
				Drive = 0;
				break;
			}
			else if(axis == 6 && button == 10){
				port = Xbox_Control;
				LY = port.getRawAxis(PortDefinitions.XboxAxisLY);
				RY = port.getRawAxis(PortDefinitions.XboxAxisRY);
				Control = "Xbox";
				Drive = 1;
				break;
			}
			else if(axis == 4 && button == 12 && POV == 4){
				port = PS3_Control;
				LY = port.getRawAxis(PortDefinitions.DualActY);
				RY = port.getRawAxis(PortDefinitions.DualActZR);
				Control = "PS3";
				Drive = 1;
				break;
			}
			else if(time > 2){
				time = 0;
			}
			count++;
		}
		if(axis == 0 && button == 0 && POV == 0){
		System.out.println("Controller can't be found or is not plugged in. "+time);
		}
		else{
		System.out.println("Robot Controls set to: "+Control+".");
		}
		/*//if(DriverStation.getStickAxisCount(PortDefinitions.JoyStickAttack) > 0){
			
		//}
	myRobot.tankDrive(-leftStick.getY(), -leftStick.getThrottle()); 
	System.out.println(" "+leftStick.getY()+" :Y-Axis "+leftStick.getThrottle()+" :Throttle-Axis");
*/	}
	public void Drive(int Drive){
		if(Drive == 0){
			arcade(LY,RY);
		}else if(Drive == 1){
			tank(LY,RY);
		}else if(Drive == 2){
			System.out.println("Mecanum Control not yet implemented.");
		}else{
			System.out.println("An Error has occured when trying to get the proper drive type, please disable and re-enable the robot to try and solve this problem.");
		}
	}
	private void arcade(double LeftY, double RightY){
		Robot.myRobot.arcadeDrive(-LeftY, RightY);
	}
	private void tank(double LeftY, double RightY){
		Robot.myRobot.tankDrive(-LeftY, -RightY);
	}	
	
	@Override
	protected void initDefaultCommand() { }

}
