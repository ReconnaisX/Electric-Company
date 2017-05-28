package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LightSystem extends Subsystem {

	public TimedLED one,two,three,four,five,six,seven,eight,nine,ten;
	public Timer time;
	static LightSystem instance;

	private LightSystem()
	{
		one = new TimedLED(0);
		two = new TimedLED(1);
		three = new TimedLED(2);
		four = new TimedLED(3);
		
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
		one.light();
		two.light();
		three.light();
		four.light();
	}
	public void allDark()
	{
		one.dark();
		two.dark();
		three.dark();
		four.dark();
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

