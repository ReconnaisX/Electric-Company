package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.commands.blink.blinkAll;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class runSequence extends CommandGroup {

	int choice;
	int i; //number of iterations
	int bigI; //number of iterations of the command block //note to programming: ask kyle to explain
    public runSequence() {
    	bigI = 0;
    	addSequential(new lightUpGroup(1,20));
    	while (true)
    	{
    		choice = (int)(Math.random()*(4+1)) + 1;
    		if (choice == 6)
    		{
    			choice = 5;
    		}
    		switch (choice)
    		{
    			case 1: //10 to 30 seconds
    				i = 5;
    				break;
    			case 2:
    				i = 30;
    				break;
    			case 3:
    				i = 45;
    				break;
    			case 4:
    				i = 20;
    				break;
    			case 5:
    				i = 45;
    				break;
    			
    		}
    		addSequential(new lightUpGroup(choice,i));
    		addSequential(new blinkAll(5,1));
    		bigI++;
    		if (bigI == 10)
    		{
    			addSequential(new Wait(60)); //take a break for sixty seconds!
    			bigI = 0;
    		}
    	}
    }
}
