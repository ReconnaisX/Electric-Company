package org.usfirst.frc.team1160.robot.commands.blink;

import org.usfirst.frc.team1160.robot.commands.Wait;
import org.usfirst.frc.team1160.robot.commands.light.lightDark;
import org.usfirst.frc.team1160.robot.commands.light.lightUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Make some number of LEDs blink some number of times!  You can specify.
 * Also works with just one LED, but then you should probably use just blink().
 */
public class blinkMany extends CommandGroup {

    public blinkMany(int[][] arr,double waitTime) {
    	System.out.println("BlinkingMany");
       for (int i = 0;i<arr.length;i++)
       {
    	   addSequential(new lightUp(arr[i][0],arr[i][1]));
       }
       addSequential(new Wait(waitTime));
       for (int i = 0;i<arr.length;i++)
       {
    	   addSequential(new lightDark(arr[i][0],arr[i][1]));
       }
       addSequential(new Wait(waitTime));
    }
}
