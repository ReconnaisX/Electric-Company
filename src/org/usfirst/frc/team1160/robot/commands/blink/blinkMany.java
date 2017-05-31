package org.usfirst.frc.team1160.robot.commands.blink;

import org.usfirst.frc.team1160.robot.commands.Wait;
import org.usfirst.frc.team1160.robot.commands.light.lightDark;
import org.usfirst.frc.team1160.robot.commands.light.lightUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class blinkMany extends CommandGroup {

    public blinkMany(int[][] arr,double waitTime) {
       for (int i = 0;i<arr.length;i++)
       {
    	   addSequential(new lightUp(arr[i][0],arr[i][1]));
       }
       addSequential(new Wait(waitTime));
       for (int i = 0;i<arr.length;i++)
       {
    	   addSequential(new lightDark(arr[i][0],arr[i][1]));
       }
    }
}
