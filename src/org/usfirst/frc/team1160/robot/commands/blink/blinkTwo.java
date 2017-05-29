package org.usfirst.frc.team1160.robot.commands.blink;

import org.usfirst.frc.team1160.robot.commands.Wait;
import org.usfirst.frc.team1160.robot.commands.light.lightDark;
import org.usfirst.frc.team1160.robot.commands.light.lightUp;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class blinkTwo extends CommandGroup {

    public blinkTwo(int x,int y,int a,int b,double waitTime) {
        addSequential(new lightUp(x,y));
        addSequential(new lightUp(a,b));
        addSequential(new Wait(waitTime));
        addSequential(new lightDark(x,y));
        addSequential(new lightDark(a,b));
        
    }
}
