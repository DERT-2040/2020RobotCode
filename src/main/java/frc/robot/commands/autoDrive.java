package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.*;

public class autoDrive extends CommandBase {
    private final Drivetrain m_Drivetrain;
    
    private double m_time;
    private double m_speed;

    private Timer m_timer = new Timer();

    public autoDrive(Drivetrain subsytem, double time, double speed){
        m_time = time;
        m_Drivetrain = subsytem;
        m_speed = speed;
        addRequirements(m_Drivetrain);
    }

    public void initialize(){
        m_timer.reset();
        m_timer.start();
        m_Drivetrain.stop();
    }

    public void execute(){
        m_Drivetrain.driveDeadband(0, m_speed, 1);
        //System.out.println("Auto");
    }


    public boolean isFinished(){
        return m_timer.hasPeriodPassed(m_time);
    }

    public void end(boolean interrupted){
        System.out.println("first end");
        m_timer.stop();
        m_timer.reset();
        m_Drivetrain.stop();
    }
}
