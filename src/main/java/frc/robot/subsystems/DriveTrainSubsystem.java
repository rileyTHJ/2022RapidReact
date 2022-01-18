// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
 
public class DriveTrainSubsystem extends SubsystemBase {

  private static TalonFX frontLeftMotor = new TalonFX(Constants.FRONT_LEFT_MOTOR_PORT);
  private static TalonFX rearLeftMotor = new TalonFX(Constants.REAR_LEFT_MOTOR_PORT);
  private static TalonFX frontRightMotor = new TalonFX(Constants.FRONT_RIGHT_MOTOR_PORT);
  private static TalonFX rearRightMotor = new TalonFX(Constants.REAR_RIGHT_MOTOR_PORT);
 

  public void DrivetrainSub() {

  }

  public void m_arcadeDrive(double sideways, double forward, double rotation, double throttle) {

    frontLeftMotor.setNeutralMode(NeutralMode.Brake);
    rearLeftMotor.setNeutralMode(NeutralMode.Brake);
    frontRightMotor.setNeutralMode(NeutralMode.Brake);
    rearRightMotor.setNeutralMode(NeutralMode.Brake);


    double leftPower = skim(((forward * throttle) - (rotation * throttle * Constants.TURN_ADJUST)));
    double rightPower = skim(((forward * throttle) + (rotation * throttle * Constants.TURN_ADJUST)));


      
    SmartDashboard.putNumber("leftPower", leftPower);
    SmartDashboard.putNumber("rightPower", rightPower);

    frontLeftMotor.set(TalonFXControlMode.PercentOutput, leftPower);
    frontRightMotor.set(TalonFXControlMode.PercentOutput, -rightPower);
    rearLeftMotor.set(TalonFXControlMode.PercentOutput, leftPower);
    rearRightMotor.set(TalonFXControlMode.PercentOutput, -rightPower);

  }

  public double skim(double num){
    //This method keeps the power value from being above or below the limits of the motor.

    //1 and -1 are the upper and lower bounds of the motor.
    if (num > 1.0) {
      return 1.0;
    } else if (num < -1.0) {
      return -1.0;
    }
    else{
      return num;
    } 
  }
 
 
}
