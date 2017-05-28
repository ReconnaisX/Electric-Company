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
    	Robot.lights.one.light();
    	new Wait(5);
    	Robot.lights.two.light();
    	new Wait(5);
    	Robot.lights.three.light();
    	new Wait(5);
    	Robot.lights.allDark();
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
