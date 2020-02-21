package frc.robot.commands;

import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class stopTurret extends CommandBase {
    private final Turret m_Turret;

    public stopTurret(Turret subsystem){
        m_Turret = subsystem;
        addRequirements(m_Turret);
    }

    public void execute(){
        m_Turret.turnTurret(0);
    }    

    public boolean isFinished(){
        return true;
    }
}
