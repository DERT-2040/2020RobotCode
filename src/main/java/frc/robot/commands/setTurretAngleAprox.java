package frc.robot.commands;

import frc.robot.subsystems.Turret;
import frc.robot.subsystems.VisionCommunication;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class setTurretAngleAprox extends CommandBase {
    private final Turret m_Turret;
    private final VisionCommunication m_VisionCommunication;
    private double x;
    private int deadband = 2;
    
    public setTurretAngleAprox(Turret subsystem, VisionCommunication subsystemVision){
        m_Turret = subsystem;
        m_VisionCommunication = subsystemVision;
        addRequirements(m_Turret, m_VisionCommunication);
    }

    public void execute(){
        x = m_VisionCommunication.getAngleAprox();
        if(x > deadband && x != 999){
            m_Turret.turnTurret(.1);
        }
        else if(x < -deadband){
            m_Turret.turnTurret(-.1);
        }
        else if(x <= deadband && x >= -deadband && x != 999){
            m_Turret.turnTurret(0);
        }
    }

    public boolean isFinished(){
        return false;
    }
} 