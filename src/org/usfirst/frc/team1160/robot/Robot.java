package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1160.robot.commands.lightUpGroup;
import org.usfirst.frc.team1160.robot.commands.runSequence;
import org.usfirst.frc.team1160.robot.commands.light.lightUp;
import org.usfirst.frc.team1160.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team1160.robot.subsystems.LightSystem;

/**
 * CURRENT ISSUES: 5/31/17
 *  - runSequence has a habit of just defaulting to choice = 2 and then crashing
 *  - you can use autonomousCommand.start() in the autonomousPeriodic() function in this file to alleviate
 *  that issue but it just ends up restarting after choice #2 crash
 *  - choice always ends up at #2--- why?
 *  - blinkAll might be the culprit
 *  - alternatively, the hardware limitations might be the cause
 *  
 *  6/1/17
 *  - everything should be fixed, run sequence will run 10x within and autonomousPeriodic() will revive it.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	//public static OI oi;
	public static LightSystem lights;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//oi = new OI();
		lights = LightSystem.getInstance();
		
		/*chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);*/
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		//lightUpGroup commands
		//1: default sequence
		//2: unused
		//3: turn all lights on
			//constant
		//4: tower caterpillar
		//5: ray caterpillar
		//6: both caterpillar
		//7: true caterpillar
			
		
		
		autonomousCommand = new runSequence();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		if (autonomousCommand == null)
		{
			autonomousCommand = new runSequence();
			autonomousCommand.start();
		}
		else
		{
			autonomousCommand.start();
		}
		
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
