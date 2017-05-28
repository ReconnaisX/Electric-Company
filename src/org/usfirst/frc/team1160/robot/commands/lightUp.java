package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.commands.Wait;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class lightUp extends Command {
	
	
	
    public lightUp() {
        requires(Robot.lights);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	sequenceOne();
    	/*Robot.lights.startTime();
    	Robot.lights.one.light();
    	//wait for five seconds
    	
    	Robot.lights.two.light();*/
    }
    private void sequenceOne()
    {
    	
    	Robot.lights.startTime();
    	Robot.lights.array[0][0].light();
    	new Wait(50);
    	Robot.lights.array[0][1].light();
    	new Wait(50);
    	Robot.lights.array[0][2].light();
    	new Wait(50);
    	Robot.lights.array[0][3].light();
    	new Wait(50);
    	Robot.lights.array[1][0].light();
    	new Wait(50);
    	Robot.lights.array[1][1].light();
    	new Wait(50);
    	Robot.lights.array[1][2].light();
    	new Wait(50);
    	Robot.lights.array[1][3].light();
    	new Wait(50);
    	Robot.lights.array[2][0].light();
    	new Wait(50);
    	Robot.lights.array[2][1].light();
    	
    	//Robot.lights.allDark();
    	
    	/*
    	Robot.lights.array[1][0].light();
    	new Wait()
    	*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
