package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
  private static final int frontLeftDeviceID = 20;
  private static final int rearLeftDeviceID = 1;
  private CANSparkMax m_frontLeftMotor = new CANSparkMax(frontLeftDeviceID, MotorType.kBrushless);
  private CANSparkMax m_rearLeftMotor = new CANSparkMax(rearLeftDeviceID, MotorType.kBrushless);
  SpeedControllerGroup m_leftMotors = new SpeedControllerGroup(m_frontLeftMotor, m_rearLeftMotor);

  private static final int frontRightDeviceID = 2;
  private static final int rearRightDeviceID = 3;
  private CANSparkMax m_frontRightMotor = new CANSparkMax(frontRightDeviceID, MotorType.kBrushless);
  private CANSparkMax m_rearRightMotor = new CANSparkMax(rearRightDeviceID, MotorType.kBrushless);
  SpeedControllerGroup m_rightMotors = new SpeedControllerGroup(m_frontRightMotor, m_rearRightMotor);




  private DifferentialDrive m_robotDrive;

  
  private double adjustedLeftAxisX;
  private double adjustedLeftAxisY;
  private double deadband = 0.1;

  

  public Drivetrain(){
    m_frontLeftMotor.restoreFactoryDefaults();
    m_rearLeftMotor.restoreFactoryDefaults();
    m_frontRightMotor.restoreFactoryDefaults();
    m_rearRightMotor.restoreFactoryDefaults();

    m_robotDrive = new DifferentialDrive(m_leftMotors, m_rightMotors);  
    m_robotDrive.setRightSideInverted(false);
  }

  public void driveDeadband(double getXAxis, double getYAxis, double getZAxis) {
    adjustedLeftAxisX = getXAxis * (getZAxis/2 + 0.5);
    adjustedLeftAxisY = getYAxis * (getZAxis/2 + 0.5);

    if(adjustedLeftAxisX < deadband && adjustedLeftAxisX > -(deadband)){
      adjustedLeftAxisX = 0;
    }

    if(adjustedLeftAxisY < deadband && adjustedLeftAxisY > -(deadband)){
      adjustedLeftAxisY = 0;
    }

    m_robotDrive.arcadeDrive(adjustedLeftAxisX, adjustedLeftAxisY);
  }

  public void drive(double getXAxis, double getYAxis, double getZAxis) {
    adjustedLeftAxisX = getXAxis * (getZAxis/2 + 0.5);
    adjustedLeftAxisY = getYAxis * (getZAxis/2 + 0.5);
    m_robotDrive.arcadeDrive(adjustedLeftAxisX, adjustedLeftAxisY);
  }

  public void drive(double getXAxis, double getYAxis) {
    m_robotDrive.arcadeDrive(adjustedLeftAxisX, adjustedLeftAxisY);
  }

  public double getRotations(){
    double rotations = 0;
    return rotations;
  }

  public void simpleDrive(double speed){
    m_robotDrive.arcadeDrive(speed, 0);
  }

  public void stop(){
    m_leftMotors.set(0);
    m_rightMotors.set(0);
  }
}