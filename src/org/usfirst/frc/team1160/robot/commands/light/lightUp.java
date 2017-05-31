package org.usfirst.frc.team1160.robot.commands.light;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class lightUp extends Command {
	
	private int x;
	private int y;
	
    public lightUp(int x,int y) {
        requires(Robot.lights);
        this.x = x;
        this.y = y;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println(x + " " + y);
    	Robot.lights.array[x][y].light();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
