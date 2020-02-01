package frc.robot.commands;

import frc.robot.subsystems.Lift;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class moveLiftDown extends CommandBase {
  private final Lift m_Lift;

  /**
   * @param subsystem The subsystem used by this command.
   */
  public moveLiftDown(Lift subsystem) {
    m_Lift = subsystem;
    addRequirements(subsystem);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      m_Lift.moveLiftDown();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_Lift.getBottomLimitSwitch();
  }
}