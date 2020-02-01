package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shoot extends CommandBase {
    private final Shooter m_Shooter;

    public Shoot(Shooter subsystem){
        m_Shooter = subsystem;
        addRequirements(m_Shooter);
    }

    public void execute(){
        m_Shooter.startMotor();
    }

    public void end(){
        m_Shooter.stopMotor();
    }
}
