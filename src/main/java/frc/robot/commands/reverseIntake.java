package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class reverseIntake extends CommandBase {
    private final Intake m_Intake;
    
    public reverseIntake(Intake subsytem){
        m_Intake = subsytem;
        addRequirements(m_Intake);
    }

    public void execute(){
        m_Intake.reverseIntake();
    }

    public boolean isFinished(){
        return true;
    }
}