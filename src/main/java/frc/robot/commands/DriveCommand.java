/*----------------------------------------------------------------------------*/
/* Copyright (c) 2022 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
 
package frc.robot.commands;
 
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import java.util.function.DoubleSupplier;
 
public class DriveCommand extends CommandBase {
  private final DriveTrainSubsystem sub_driveTrainSubsystem;
  private DoubleSupplier m_sideways;
  private DoubleSupplier m_forward;
  private DoubleSupplier m_rotation;
  private DoubleSupplier m_throttle;
 
  public DriveCommand(DriveTrainSubsystem subsystem, DoubleSupplier sideways, DoubleSupplier forward, DoubleSupplier twist, DoubleSupplier throttle) {
    sub_driveTrainSubsystem = subsystem;
    m_forward = forward;
    m_rotation = twist;
    m_throttle = throttle;
    
    addRequirements(sub_driveTrainSubsystem);
  }
 
  @Override
  public void execute() {
    sub_driveTrainSubsystem.m_arcadeDrive(m_sideways.getAsDouble(), m_forward.getAsDouble(), m_rotation.getAsDouble(), (-m_throttle.getAsDouble()+1)/2);
  }
}