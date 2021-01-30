package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ShooterLoader extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  private static final int intakeMotorID = 12;
  private WPI_TalonSRX m_intakeMotor = new WPI_TalonSRX(intakeMotorID);

  public void startLoader(){
    m_intakeMotor.set(-.75);
  }

  public void stopLoader(){
    m_intakeMotor.set(0);
  }
}