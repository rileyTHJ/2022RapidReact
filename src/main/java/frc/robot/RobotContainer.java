// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.AimVerticalSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  /*
  --------------------------------------------------------Subsystems-------------------------------------------------------------------------
  */

  //Drive related subsystems

  private final DriveTrainSubsystem sub_driveTrainSubsystem = new DriveTrainSubsystem();
  
  //Lift related subsystems

  private final LiftSubsystem sub_liftSubsystem = new LiftSubsystem();

  //Aim related subsystems 

  private final AimVerticalSubsystem sub_aimVerticalSubsystem = new AimVerticalSubsystem();

  /*
  ---------------------------------------------------------Commands------------------------------------------------------------------------
  */
  
  //Lift related commands

  private final LiftUpCommand cmd_liftUpCommand = new LiftUpCommand(sub_liftSubsystem);
  private final LiftDownCommand cmd_liftDownCommand = new LiftDownCommand(sub_liftSubsystem);


  //Aim related commands

private final AimCommand cmd_aimCommand = new AimCommand(sub_aimVerticalSubsystem);

 private final AutoCommand cmd_autoCommand = new AutoCommand(sub_driveTrainSubsystem);


  /*
  --------------------------------------------------------Joysticks-----------------------------------------------------------------------------
  */
  private final Joystick driveJoystick = new Joystick(Constants.DRIVE_JOYSTICK_PORT);
  private final Joystick buttonsJoystick = new Joystick(Constants.BUTTONS_JOYSTICK_PORT);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
        sub_driveTrainSubsystem.setDefaultCommand(
      new DriveCommand(sub_driveTrainSubsystem, 
      () -> -driveJoystick.getRawAxis(Constants.X),
      () -> -driveJoystick.getRawAxis(Constants.Y), 
      () -> -driveJoystick.getRawAxis(Constants.Z),
      () -> driveJoystick.getRawAxis(Constants.S)));

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton b_liftUpButton = new JoystickButton(buttonsJoystick, Constants.LIFT_UP_BUTTON);
    b_liftUpButton.whileHeld(cmd_liftUpCommand, Constants.NOT_INTERRUPTIBLE);

    JoystickButton b_liftDownButton = new JoystickButton(buttonsJoystick, Constants.LIFT_DOWN_BUTTON);
    b_liftDownButton.whileHeld(cmd_liftDownCommand, Constants.NOT_INTERRUPTIBLE);


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return cmd_autoCommand;
  }
}
