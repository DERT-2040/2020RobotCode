package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  private static final int shooterMotorID = 5;
  private CANSparkMax m_shooterMotor = new CANSparkMax(shooterMotorID, MotorType.kBrushless);

  public void startMotor(){
      m_shooterMotor.set(1);
  }

  public void stopMotor(){
      m_shooterMotor.set(0);
  }
}
