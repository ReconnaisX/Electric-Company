package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.commands.blink.blinkAll;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * The final run sequence, combining various smaller patterns.
 * This brings everything together.
 */
public class runSequence extends CommandGroup {

	int choice;
	int i; //number of iterations
	int bigI; //number of iterations of the command block //note to programming: ask kyle to explain
    public runSequence() {
    	/*addSequential(new lightUpGroup(1,3));
    	for (int i = 0;i<4;i++)
    	{
    		for (int j = 0;j<5;j++)
    		{
	    		if (i == 0)
	    		{
	    			j += 1;
	    		}
	    		addSequential(new lightUpGroup(j+1,1));
    		}
    	}
    }*/
    	bigI = 0;
    	addSequential(new lightUpGroup(1,3));
    	//for (int xy = 0;xy<100;xy++)
    	//{
    		addSequential(new debugPrint("I got here"));
    		choice = (int)(Math.random()*(4+1) + 1);
    		if (choice == 6)
    		{
    			choice = 5;
    		}
    		switch (choice)
    		{
    			case 1: //sequenceOne(), default sequence
    				i = 5;
    				break;
    			case 2: //bothDown()
    				i = 15;
    				break;
    			case 3: //skipLight()
    				i = 15;
    				break;
    			case 4: //clockwiseRays()
    				i = 15;
    				break;
    			case 5: //bothCaterpillar()
    				i = 10;
    				break;
    			
    		}
    		addSequential(new lightUpGroup(choice,i));
    		addSequential(new blinkAll(3,1));
    		addSequential(new debugPrint("Successfully finished blink!"));
    		bigI++;
    		if (bigI == 10)
    		{
    			addSequential(new debugPrint("Taking a break!"));
    			addSequential(new Wait(30)); //take a break for thirty seconds!
    			bigI = 0;
    		}
    	//}
    }
}
