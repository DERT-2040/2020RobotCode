package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


public class Lift extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  DigitalInput topLimitSwitch = new DigitalInput(1);
  DigitalInput bottomLimitSwitch = new DigitalInput(2);

  private static final double deadband = 0.1;
  private static final double movingSpeed = 0.5;

  private static final int rightLiftMotorID = 8;
  private static final int leftLiftMotorID = 9;
  private WPI_TalonSRX m_rightLiftMotor = new WPI_TalonSRX(rightLiftMotorID);
  private WPI_TalonSRX m_leftLiftMotor = new WPI_TalonSRX(leftLiftMotorID);
  SpeedControllerGroup m_LiftMotors = new SpeedControllerGroup(m_rightLiftMotor, m_leftLiftMotor);

  public void moveLiftDeadband(double liftSpeed){
    if(liftSpeed <= deadband && liftSpeed >= -(deadband)){
      liftSpeed = 0;
    }
    m_LiftMotors.set(liftSpeed);
  }

  public void moveLiftUp(){
    m_LiftMotors.set(movingSpeed);
  }

  public void moveLiftDown(){
    m_LiftMotors.set(-movingSpeed);
  }

  public void stopLift(){
    m_LiftMotors.set(0);
  }

  public boolean getTopLimitSwitch(){
    return topLimitSwitch.get();
  }

  public boolean getBottomLimitSwitch(){
    return bottomLimitSwitch.get();
  }
}