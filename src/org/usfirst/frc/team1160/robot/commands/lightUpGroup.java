 package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.commands.blink.blink;
import org.usfirst.frc.team1160.robot.commands.blink.blinkAll;
import org.usfirst.frc.team1160.robot.commands.blink.blinkTwo;
import org.usfirst.frc.team1160.robot.commands.light.lightDark;
import org.usfirst.frc.team1160.robot.commands.light.lightDarkAll;
import org.usfirst.frc.team1160.robot.commands.light.lightUp;
import org.usfirst.frc.team1160.robot.commands.light.lightUpAll;
import org.usfirst.frc.team1160.robot.commands.light.lightUpTower;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
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
    			sequenceTwo();
    			break;
    		case 3:
    			sequenceAll();
    			break;
    		case 4:
    			towerCaterpillar();
    			break;
    		case 5:
    			rayCaterpillar();
    			break;
    		case 6:
    			bothCaterpillar();
    			break;
    		case 7:
    			trueTowerCaterpillar();
    			break;
    		case 8:
    			test();
    			break;
    			
    	}
    }
	public void sequenceOne() //light up bottom tier to top tier, then the rays in the same order, then blink for a bit
	{
		for (int i = 0; i < iterations; i++)
		{
			int waitTime = (int)(Math.random()*2)+1;
			
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
				addSequential(new blinkAll(1));
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
	public void sequenceAll()
	{
		addSequential(new lightUpAll());
	}
	public void towerCaterpillar()
	{
		
		addSequential(new blink(0,0,0.2));
		for (int i = 0; i < iterations; i++)
		{
			double waitTime = 0.2;
			
			//bottom tier
			//addSequential(new blink(0,0,waitTime));
			
			//tier 2
			addSequential(new blink(0,1,waitTime));
			
			//tier 3
			addSequential(new blink(0,2,waitTime));
			
			//tier 4
			addSequential(new blink(0,3,waitTime));
			
			//tier 5
			addSequential(new blink(1,0,waitTime));
			
			addSequential(new blink(0,3,waitTime));
			addSequential(new blink(0,2,waitTime));
			addSequential(new blink(0,1,waitTime));
			addSequential(new blink(0,0,waitTime));
			
		}
	}
	public void bothCaterpillar() //this will use the blinkTwo function
	{
		for (int i = 0; i < iterations; i++)
		{
			double waitTime = 0.2;
			
			//bottom tier
			addSequential(new blinkTwo(1,1,0,0,waitTime));
			
			//tier 2
			addSequential(new blinkTwo(1,2,0,1,waitTime));
			
			//tier 3
			addSequential(new blinkTwo(1,3,0,2,waitTime));
			
			//tier 4
			addSequential(new blinkTwo(2,0,0,3,waitTime));
			
			//tier 5
			addSequential(new blinkTwo(2,1,1,0,waitTime));
		}
	}
	public void rayCaterpillar() //blinkTwo function here!
	{
		addSequential(new lightUpTower());
		for (int i = 0; i < iterations; i++)
		{
			double waitTime = 0.2;
			
			//bottom tier
			addSequential(new blinkTwo(0,4,1,5,waitTime));
			
			//tier 2
			addSequential(new blinkTwo(0,5,1,6,waitTime));
			
			//tier 3
			addSequential(new blinkTwo(0,6,1,7,waitTime));
			
			//tier 4
			addSequential(new blinkTwo(0,7,2,4,waitTime));
			
			//tier 5
			addSequential(new blinkTwo(1,4,2,5,waitTime));
			
			//back down
			//tier 4
			addSequential(new blinkTwo(0,7,2,4,waitTime));
			//tier 3
			addSequential(new blinkTwo(0,6,1,7,waitTime));
			//tier 2
			addSequential(new blinkTwo(0,5,1,6,waitTime));
		}
		addSequential(new lightDarkAll());
	}
	public void trueTowerCaterpillar() //it's actually not
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
	}
	public void test()
	{
		new Solenoid(0,7).set(true);
		addSequential(new lightUp(0,0));
	}
	
}
