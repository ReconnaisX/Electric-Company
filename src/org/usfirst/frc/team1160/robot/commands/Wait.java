package org.usfirst.frc.team1160.robot.commands;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command{

	private double finTime;
	//private double startTime;
	
	public Wait(double finTime){
		requires(Robot.lights);
		//this.startTime = Robot.lights.time.get();
		this.finTime = finTime;
	}
	
	@Override
	protected void initialize() {
		Robot.lights.startTime();
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.lights.done(finTime);
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
