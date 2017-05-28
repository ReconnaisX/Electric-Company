package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TimedLED extends Subsystem {

    Solenoid lightSwitch;
    
    //kyle's comment: we won't need instances in this case, as we will be dealing 
    //with tons of these LEDs, not just one
    
    //static TimedLED instance;
    
    /*public static TimedLED getInstance()
    {
    	if (instance == null)
    	{
    		instance = new TimedLED();
    	}
    	return instance;
    }*/
    public TimedLED(int port)
    {
    	lightSwitch = new Solenoid(port);
    	
    }
    public void light()
    {
    	lightSwitch.set(true);
    }
    public void dark()
    {
    	lightSwitch.set(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

