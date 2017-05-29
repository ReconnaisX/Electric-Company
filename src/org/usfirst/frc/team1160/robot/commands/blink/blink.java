package org.usfirst.frc.team1160.robot.commands.blink;

import org.usfirst.frc.team1160.robot.commands.Wait;
import org.usfirst.frc.team1160.robot.commands.light.lightDark;
import org.usfirst.frc.team1160.robot.commands.light.lightUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class blink extends CommandGroup {

    public blink(int x, int y, double waitTime) {
    	addSequential(new lightUp(x,y));
    	addSequential(new Wait(waitTime));
    	addSequential(new lightDark(x,y));
        
    }
}
