package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import frc.robot.subsystems.*;

public class autoCommandGroup extends SequentialCommandGroup {

    public autoCommandGroup(Drivetrain m_drive, Shooter m_shooter, ShooterLoader m_loader, Intake m_intake, Turret m_turret, VisionCommunication m_visionCommunication){
        addCommands(
            new autoAim(m_turret, m_visionCommunication, 5),

            new autoShootPrep(m_shooter, 3),

            new autoShooter(m_shooter, m_loader, m_intake, 5),

            new autoDrive(m_drive, 1, 0.5)
        );
    }
}