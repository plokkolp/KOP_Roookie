package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ChassisControl;
import frc.robot.subsystems.Chassis;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private Chassis m_Chassis = new Chassis();

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
    m_Chassis.setDefaultCommand(new ChassisControl(m_Chassis, () -> m_driverController.getLeftY(), () -> m_driverController.getRightY()));
  }

  private void configureBindings() {  }

  public Command getAutonomousCommand() {
    return null;
  }
}
