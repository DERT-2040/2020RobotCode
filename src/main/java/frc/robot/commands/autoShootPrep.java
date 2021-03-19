package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.*;

public class autoShootPrep extends CommandBase {
    private final Shooter m_Shooter;
    
    private double m_time;

    private Timer m_timer = new Timer();

    public autoShootPrep(Shooter subsytem, double time){
        m_time = time;
        m_Shooter = subsytem;
        addRequirements(m_Shooter);
    }

    public void initialize(){
        m_timer.reset();
        m_timer.start();
        m_Shooter.stopMotor();
    }

    public void execute(){
        m_Shooter.startMotor();
        //System.out.println("Auto");
    }


    public boolean isFinished(){
        return m_timer.hasPeriodPassed(m_time);
    }

    public void end(boolean interrupted){
        m_timer.stop();
        m_timer.reset();
    }
}
