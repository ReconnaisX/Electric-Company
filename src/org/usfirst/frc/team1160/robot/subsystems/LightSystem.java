package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LightSystem extends Subsystem {

	//public TimedLED one,two,three,four,five,six,seven,eight,nine,ten;
	public TimedLED[][] array;
	public Timer time;
	static LightSystem instance;

	private LightSystem()
	{
		array = new TimedLED[3][4];
		for (int i = 0; i < 3; i++)
		{
			if (i == 2)
			{
				for (int j = 0; j < 2; j++)
				{
					array[i][j] = new TimedLED(i,j);
				}
				break;
			}
			for (int j = 0; j < 4; j++)
			{
				array[i][j] = new TimedLED(i,j);
			}
		}
		/*
		one = new TimedLED(0,0);
		two = new TimedLED(0,1);
		three = new TimedLED(0,2);
		four = new TimedLED(0,3);
		*/
		
		time = new Timer();
	}
	public static LightSystem getInstance()
	{
		if (instance == null)
		{
			instance = new LightSystem();
		}
		return instance;
	}
	public void startTime()
	{
		time.reset();
		time.start();
	}
	public boolean done(double finTime){
		if(time.get() >= finTime){
			time.start();
			return true;
		}
		return false;
	}
	public void allLight()
	{
		for (int i = 0; i < 3; i++)
		{
			if (i == 2)
			{
				for (int j = 0; j < 2; j++)
				{
					array[i][j].light();
				}
				break;
			}
			for (int j = 0; j < 4; j++)
			{
				array[i][j].light();
			}
		}
	}
	public void allDark()
	{
		for (int i = 0; i < 3; i++)
		{
			if (i == 2)
			{
				for (int j = 0; j < 2; j++)
				{
					array[i][j].dark();
				}
				break;
			}
			for (int j = 0; j < 4; j++)
			{
				array[i][j].dark();
			}
		}
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

