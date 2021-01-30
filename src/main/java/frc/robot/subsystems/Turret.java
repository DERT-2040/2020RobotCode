package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Turret extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  private static final int turretMotorID = 5;
  private WPI_TalonSRX m_turretMotor = new WPI_TalonSRX(turretMotorID);

  public void turnTurretDeadband(double turnSpeed){
    if(turnSpeed <= 0.1 && turnSpeed >= -0.1){
      turnSpeed = 0;
    }
    m_turretMotor.set(turnSpeed);
  }

  public void turnTurret(double turnSpeed){
    m_turretMotor.set(turnSpeed);
  }
}