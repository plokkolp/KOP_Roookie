package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Chassis;

public class ChassisControl extends Command {
  private Chassis m_Chassis;
  private Supplier<Double> leftStickY, rightStickY;
  public ChassisControl(Chassis m_Chassis, Supplier<Double> leftStickY, Supplier<Double> rightStickY) {
    this.m_Chassis = m_Chassis;
    this.leftStickY = leftStickY;
    this.rightStickY = rightStickY;
    addRequirements(m_Chassis);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_Chassis.setChassisSpeed(-leftStickY.get(), -rightStickY.get());
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
