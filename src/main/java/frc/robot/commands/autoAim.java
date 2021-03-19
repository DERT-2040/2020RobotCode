package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.VisionCommunication;
import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj.Timer;

public class autoAim extends CommandBase {
    private final Turret m_Turret;
    private final VisionCommunication m_VisionCommunication;
    private double x;
    private int deadband = 2;

    private double m_time;

    private Timer m_timer = new Timer();
    
    public autoAim(Turret subsystem, VisionCommunication subsystemVision, double time){
        m_time = time;
        m_Turret = subsystem;
        m_VisionCommunication = subsystemVision;
        addRequirements(m_Turret, m_VisionCommunication);
    }
    
    public void initialize(){
        m_Turret.turnTurret(0);
        m_timer.reset();
        m_timer.start();
    }

    public void execute(){
        x = m_VisionCommunication.getAngleAprox();
        if(x != 999){
            System.out.println(x);
            if(x <= deadband && x >= -deadband){
                m_Turret.turnTurret(0);
            }
            else if(x < -deadband){
                m_Turret.turnTurret(-.15);
            }
            else if(x > deadband){
                m_Turret.turnTurret(.15);
            }
        }
        else{
            m_Turret.turnTurret(0);
        }
    }

    public boolean isFinished(){
        return m_timer.hasPeriodPassed(m_time);
    }

    public void end(boolean interrupted){
        m_Turret.turnTurret(0);
        m_timer.stop();
        m_timer.reset();
    }
} 
