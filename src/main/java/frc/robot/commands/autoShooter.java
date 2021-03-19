package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.ShooterLoader;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.*;

public class autoShooter extends CommandBase {
    private final ShooterLoader m_ShooterLoader;
    private final Shooter m_Shooter;
    private final Intake m_Intake;

    private double m_time;

    private Timer m_timer = new Timer();

    public autoShooter(Shooter subsytem, ShooterLoader loaderSubsystem, Intake intakeSubsystem, double time){
        m_time = time;
        m_Shooter = subsytem;
        m_ShooterLoader = loaderSubsystem;
        m_Intake = intakeSubsystem;
        addRequirements(m_ShooterLoader, m_Shooter, m_Intake);
    }

    public void initialize(){
        m_timer.reset();
        m_timer.start();
        m_ShooterLoader.stopLoader();
        m_Intake.stopIntake();
    }

    public void execute(){
        //System.out.println(m_timer.get());
        m_Shooter.startMotor();
        m_ShooterLoader.startLoader();
        m_Intake.startIntake();
    }


    public boolean isFinished(){
        return m_timer.hasPeriodPassed(m_time);
    }

    public void end(boolean interrupted){
        System.out.println("Made it to end");
        m_Shooter.stopMotor();
        m_ShooterLoader.stopLoader();
        m_Intake.stopIntake();
        m_timer.stop();
        m_timer.reset();
    }
}
