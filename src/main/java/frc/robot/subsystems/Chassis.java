// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ChassisConstants;;

public class Chassis extends SubsystemBase {
  private SparkMax leftFront = new SparkMax(ChassisConstants.MOTOR_LF_ID, MotorType.kBrushless);
  private SparkMax leftBack = new SparkMax(ChassisConstants.MOTOR_LB_ID, MotorType.kBrushless);
  private SparkMax rightFront = new SparkMax(ChassisConstants.MOTOR_RF_ID, MotorType.kBrushless);
  private SparkMax rightBack = new SparkMax(ChassisConstants.MOTOR_RB_ID, MotorType.kBrushless);
  /** Creates a new Chassis. */
  public Chassis() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setLeftMotorSpeed (double speed){
    leftFront.set(speed);
    leftBack.set(speed);
  }
  public void setRightMotorSpeed (double speed){
    rightFront.set(speed);
    rightBack.set(speed);
  }
  public void setChassisSpeed(double leftSpeed, double rightSpeed){
    setLeftMotorSpeed(leftSpeed);
    setRightMotorSpeed(rightSpeed);
  }
}
