// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  
    //Joystick constants
    public static int DRIVE_JOYSTICK_PORT = 0;
    public static int BUTTONS_JOYSTICK_PORT = 1;
    public static int X = 0;
    public static int Y = 1;
    public static int Z = 2;
    public static int S = 3;

    //Motor Ports
    public static int FRONT_LEFT_MOTOR_PORT = 0;
    public static int FRONT_RIGHT_MOTOR_PORT = 1;
    public static int REAR_LEFT_MOTOR_PORT = 2;
    public static int REAR_RIGHT_MOTOR_PORT = 3;
    public static int LEFT_LIFT_MOTOR = 4;
    public static int RIGHT_LIFT_MOTOR = 5;

    //Other drive constants
    public static double TURN_ADJUST = 0.4;





    //Motor Speeds
    public static double LIFT_UP_SPEED = 1.0;
    public static double LIFT_DOWN_SPEED = -0.1;

    //Buttons
    public static boolean NOT_INTERRUPTIBLE = false;
    public static boolean INTERRUPTIBLE = true;

    public static int LIFT_UP_BUTTON = 0;
    public static int LIFT_DOWN_BUTTON = 1;
}
