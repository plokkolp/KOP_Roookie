// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Chassis;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ChassisControl extends Command {
  private Chassis m_Chassis;
  private Supplier<Double> leftStickY, rightStickY;
  /** Creates a new ChassisControl. */
  public ChassisControl(Chassis m_Chassis, Supplier<Double> leftStickY, Supplier<Double> rightStickY) {
    this.m_Chassis = m_Chassis;
    this.leftStickY = leftStickY;
    this.rightStickY = rightStickY;
    // Use addRequirements() here to declare subsystem dependencies.命令必須要求控制子系統，命令要併在子系統上面，才不會有命令跟非命令同時控制子系統。建構函式從子系統intrue丟進來
    addRequirements(m_Chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Chassis.setChassisSpeed(-leftStickY.get(), -rightStickY.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
