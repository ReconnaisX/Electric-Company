package org.usfirst.frc.team1160.robot.commands.light;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class lightUpTower extends CommandGroup {

    public lightUpTower() { //lights up towers with no pause in between
    	addSequential(new lightUp(0,0));
    	addSequential(new lightUp(0,1));
    	addSequential(new lightUp(0,2));
    	addSequential(new lightUp(0,3));
    	addSequential(new lightUp(1,0));
    }
}
