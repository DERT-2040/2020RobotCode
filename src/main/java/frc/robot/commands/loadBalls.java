package frc.robot.commands;

import frc.robot.subsystems.ShooterLoader;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class loadBalls extends CommandBase {
    private final ShooterLoader m_ShooterLoader;
    
    public loadBalls(ShooterLoader subsytem){
        m_ShooterLoader = subsytem;
        addRequirements(m_ShooterLoader);
    }

    public void execute(){
        m_ShooterLoader.startLoader();
    }

    public boolean isFinished(){
        return true;
    }
}