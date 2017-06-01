 package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.commands.blink.blink;
import org.usfirst.frc.team1160.robot.commands.blink.blinkAll;
import org.usfirst.frc.team1160.robot.commands.blink.blinkMany;
import org.usfirst.frc.team1160.robot.commands.light.lightDark;
import org.usfirst.frc.team1160.robot.commands.light.lightDarkAll;
import org.usfirst.frc.team1160.robot.commands.light.lightUp;
import org.usfirst.frc.team1160.robot.commands.light.lightUpAll;
import org.usfirst.frc.team1160.robot.commands.light.lightUpTower;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This class houses ALL of the light up sequences.
 * If I did this over, I would use individual command files for each of the sequences.
 * Oh well.
 */
public class lightUpGroup extends CommandGroup {

	private int iterations;
	
    public lightUpGroup(int sequence,int iterations) {
    	this.iterations = iterations;
    	switch (sequence)
    	{
    		case 1:
    			sequenceOne();
    			break;
    		case 2:
    			bothDown();
    			break;
    		case 3:
    			skipLight();
    			break;
    		case 4:
    			clockwiseRays();
    			break;
    		case 5:
    			bothCaterpillar();
    			break;
    			
    	}
    }
	public void sequenceOne() //light up bottom tier to top tier, then the rays in the same order, then blink for a bit
	{
		for (int i = 0; i < iterations; i++)
		{
			
			addSequential(new debugPrint("On iteration " + (i+1) + " of " + (iterations) + " of the default sequence.\n"));
			double waitTime = Math.random()+1;
			
			//bottom tier
			addSequential(new lightUp(0,0));
			addSequential(new Wait(waitTime));
			
			//tier 2
			addSequential(new lightUp(0,1));
			addSequential(new Wait(waitTime));
			
			//tier 3
			addSequential(new lightUp(0,2));
			addSequential(new Wait(waitTime));
			
			//tier 4
			addSequential(new lightUp(0,3));
			addSequential(new Wait(waitTime));
			
			//tier 5
			addSequential(new lightUp(1,0));
			addSequential(new Wait(waitTime));			
			
			//sequence is over!
			//addSequential(new lightDarkAll());
			
			//now for the rays, which use pcm 4-7
			
			//tier 1
			addSequential(new lightUp(0,4));
			addSequential(new lightUp(1,5));
			addSequential(new Wait(waitTime));		
			//tier 2
			addSequential(new lightUp(0,5));
			addSequential(new lightUp(1,6));
			addSequential(new Wait(waitTime));
			//tier 3
			addSequential(new lightUp(0,6));
			addSequential(new lightUp(1,7));
			addSequential(new Wait(waitTime));	
			//tier 4
			addSequential(new lightUp(0,7));
			addSequential(new lightUp(2,4));
			addSequential(new Wait(waitTime));	
			//tier 5
			addSequential(new lightUp(1,4));
			addSequential(new lightUp(2,5));
			addSequential(new Wait(waitTime));
			
			//blink
			for (int j = 0; j < 3;j++)
			{
				addSequential(new blinkAll(1,1));
				addSequential(new Wait(1));
			}
			addSequential(new lightDarkAll());
			addSequential(new Wait(1));
		}
	}
	public void sequenceTwo()
	{
		//for (int i = 0)
	}
	/*public void sequenceAll()
	{
		addSequential(new lightUpAll());
	}*/
	public void clockwiseRays() //tower only caterpillar (no snake, only caterpillar up) AND clockwise rays
	{
		
		for (int i = 0; i < iterations; i++)
		{
			addSequential(new debugPrint("On iteration " + (i+1) + " of " + (iterations) + " of the clockwise rays sequence.\n"));
			double waitTime = 0.5;
			
			//bottom tier
			addSequential(new blinkMany(new int[][]{{0,0},{0,4}},waitTime));
			
			//tier 2
			addSequential(new blinkMany(new int[][]{{0,1},{0,5}},waitTime));
			
			//tier 3
			addSequential(new blinkMany(new int[][]{{0,2},{0,6}},waitTime));
			
			//tier 4
			addSequential(new blinkMany(new int[][]{{0,3},{0,7}},waitTime));
			
			//tier 5
			addSequential(new blinkMany(new int[][]{{1,0},{1,4}},waitTime));
			
			//tier 4 of tower, right hand side of rays, going down
			addSequential(new blinkMany(new int[][]{{0,0},{2,5}},waitTime));
			
			addSequential(new blinkMany(new int[][]{{0,1},{2,4}},waitTime));
			
			addSequential(new blinkMany(new int[][]{{0,2},{1,7}},waitTime));
			
			addSequential(new blinkMany(new int[][]{{0,3},{1,6}},waitTime));
			
			addSequential(new blinkMany(new int[][]{{1,0},{1,5}},waitTime));
		}
	}
	public void bothCaterpillar() //this will use the blinkMany function, this thing snakes
	{
		for (int i = 0; i < iterations; i++)
		{
			addSequential(new debugPrint("On iteration " + (i+1) + " of " + (iterations) + " of the bothCaterpillar sequence.\n"));
			double waitTime = 0.2;
			
			//bottom tier
			addSequential(new blinkMany(new int[][]{{0,4},{1,5},{0,0}},waitTime));
			
			//tier 2
			addSequential(new blinkMany(new int[][]{{0,5},{1,6},{0,1}},waitTime));
			
			//tier 3
			addSequential(new blinkMany(new int[][]{{0,6},{1,7},{0,2}},waitTime));
			
			//tier 4
			addSequential(new blinkMany(new int[][]{{0,7},{2,4},{0,3}},waitTime));
			
			//tier 5
			addSequential(new blinkMany(new int[][]{{1,4},{2,5},{1,0}},waitTime));
			
			//tier 4
			addSequential(new blinkMany(new int[][]{{0,7},{2,4},{0,3}},waitTime));
			
			//tier 3
			addSequential(new blinkMany(new int[][]{{0,6},{1,7},{0,2}},waitTime));
			
			//tier 2
			addSequential(new blinkMany(new int[][]{{0,5},{1,6},{0,1}},waitTime));
		}
	}
	/*public void rayCaterpillar() //blinkTwo function here!
	{
		addSequential(new lightUpTower());
		for (int i = 0; i < iterations; i++)
		{
			double waitTime = 0.2;
			
			//bottom tier
			addSequential(new blinkMany(new int[][]{{0,4},{1,5}},waitTime));
			
			//tier 2
			addSequential(new blinkMany(new int[][]{{0,5},{1,6}},waitTime));
			
			//tier 3
			addSequential(new blinkMany(new int[][]{{0,6},{1,7}},waitTime));
			
			//tier 4
			addSequential(new blinkMany(new int[][]{{0,7},{2,4}},waitTime));
			
			//tier 5
			addSequential(new blinkMany(new int[][]{{1,4},{2,5}},waitTime));
			
			//back down
			//tier 4
			addSequential(new blinkMany(new int[][]{{0,7},{2,4}},waitTime));
			//tier 3
			addSequential(new blinkMany(new int[][]{{0,6},{1,7}},waitTime));
			//tier 2
			addSequential(new blinkMany(new int[][]{{0,5},{1,6}},waitTime));
		}
		addSequential(new lightDarkAll());
	}*/
	/*public void trueTowerCaterpillar() //it's actually not
	{
		for (int i = 0; i < iterations; i++)
		{
			double waitTime = 0.2;
			
			//bottom tier
			addSequential(new lightUp(0,0));
			addSequential(new Wait(1));
			
			//tier 2
			addSequential(new lightUp(0,1));
			addSequential(new Wait(1));
			//tier 3
			addSequential(new lightUp(0,2));
			addSequential(new Wait(1));
			//tier 4
			addSequential(new lightUp(0,3));
			addSequential(new Wait(1));
			//tier 5
			addSequential(new lightUp(1,0));
			addSequential(new Wait(1));
			
			//go dark
			addSequential(new lightDark(1,0));
			addSequential(new Wait(1));
			
			addSequential(new lightDark(0,3));
			addSequential(new Wait(1));
			
			addSequential(new lightDark(0,2));
			addSequential(new Wait(1));
			
			addSequential(new lightDark(0,1));
			addSequential(new Wait(1));
			
			addSequential(new lightDark(0,0));
			//addSequential(new Wait(1));
		}
	}*/
	public void bothDown() //tower starts from top and goes down.  does not caterpillar, just goes down.
	{					   //rays start at top and go down both sides.  no caterpillar either
		double waitTime = 0.2;
		for (int i = 0;i<iterations;i++)
		{
			addSequential(new debugPrint("On iteration " + (i+1) + " of " + (iterations) + " of the bothDown sequence.\n"));
			addSequential(new blinkMany(new int[][]{{1,0},{1,4},{2,5}},waitTime));
			addSequential(new blinkMany(new int[][]{{0,3},{0,7},{2,4}},waitTime));
			addSequential(new blinkMany(new int[][]{{0,2},{0,6},{1,7}},waitTime));
			addSequential(new blinkMany(new int[][]{{0,1},{0,5},{1,6}},waitTime));
			addSequential(new blinkMany(new int[][]{{0,0},{0,4},{1,5}},waitTime));
		}
	}
	public void skipLight() //tower tiers 1 and 3 light up first, then 2 and 4 light up
	{						// ditto for the rays
		for (int i = 0;i < iterations;i++)
		{
			addSequential(new debugPrint("On iteration " + (i+1) + " of " + (iterations) + " of the skipLight sequence.\n"));
			double waitTime = 0.2;
			addSequential(new blinkMany(new int[][]{{0,0},{0,2},{0,4},{0,6},{1,5},{1,7}},waitTime));
			addSequential(new blinkMany(new int[][]{{0,1},{0,3},{0,5},{0,7},{1,6},{2,4}},waitTime));
		}
	}
}
