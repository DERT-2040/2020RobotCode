package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Intake extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  private static final int intakeMotorID = 7;
  private WPI_TalonSRX m_intakeMotor = new WPI_TalonSRX(intakeMotorID);

  public void startIntake(){
    m_intakeMotor.set(-0.5);
  }

  public void stopIntake(){
    m_intakeMotor.set(0);
  }
}