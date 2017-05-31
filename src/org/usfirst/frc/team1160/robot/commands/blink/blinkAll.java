package org.usfirst.frc.team1160.robot.commands.blink;

import org.usfirst.frc.team1160.robot.commands.Wait;
import org.usfirst.frc.team1160.robot.commands.light.lightDarkAll;
import org.usfirst.frc.team1160.robot.commands.light.lightUpAll;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class blinkAll extends CommandGroup {

    public blinkAll(int iterations,int waitTime) { //this assumes that the lights are on to begin with
    	for (int i = 0;i < iterations;i++)
    	{
    		addSequential(new lightDarkAll());
	    	addSequential(new Wait(waitTime));
	    	addSequential(new lightUpAll());
    	}
        
    }
}
