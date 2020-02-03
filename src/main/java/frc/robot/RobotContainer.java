/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static edu.wpi.first.wpilibj.XboxController.Button;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_Drivetrain = new Drivetrain();
  private final Shooter m_Shooter = new Shooter();
  private final Intake m_Intake = new Intake();
  private final Lift m_Lift = new Lift();
  private final Turret m_Turret = new Turret();
  private final ShooterLoader m_ShooterLoader = new ShooterLoader();
  private final VisionCommunication m_VisionCommunication = new VisionCommunication();

  Joystick m_LeftJoystick = new Joystick(0);
  XboxController m_Controller = new XboxController(2);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
    m_Lift.setDefaultCommand(new JoystickLift(m_Lift, () -> m_Controller.getY(GenericHID.Hand.kLeft)));
    m_Drivetrain.setDefaultCommand(new JoystickDrive(m_Drivetrain, () -> m_LeftJoystick.getY(), () -> m_LeftJoystick.getX(), () ->  m_LeftJoystick.getZ()));
    m_Turret.setDefaultCommand(new JoystickTurret(m_Turret, () -> m_Controller.getX(GenericHID.Hand.kLeft)));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_Controller, Button.kBumperLeft.value).whenPressed(new Shoot(m_Shooter)).whenReleased(new stopShoot(m_Shooter));
    new JoystickButton(m_Controller, Button.kBumperRight.value).whenPressed(new loadBalls(m_ShooterLoader)).whenPressed(new intakeBalls(m_Intake)).whenReleased(new stopLoader(m_ShooterLoader)).whenReleased(new stopIntake(m_Intake));
    new JoystickButton(m_Controller, Button.kA.value).whenPressed(new intakeBalls(m_Intake)).whenReleased(new stopIntake(m_Intake));
    new JoystickButton(m_Controller, Button.kY.value).whenPressed(new moveLiftUp(m_Lift)).whenReleased(new stopLift(m_Lift));
    new JoystickButton(m_Controller, Button.kX.value).whenPressed(new moveLiftDown(m_Lift)).whenReleased(new stopLift(m_Lift));
    new JoystickButton(m_Controller, Button.kB.value).whenPressed(new getVisionData(m_VisionCommunication));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  //Add an autonomous command still
  public Command getAutonomousCommand() {
    return null;
  }
}
