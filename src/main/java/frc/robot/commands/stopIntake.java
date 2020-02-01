package frc.robot.commands;

import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class stopIntake extends CommandBase {
    private final Intake m_Intake;

    public stopIntake(Intake subsystem){
        m_Intake = subsystem;
        addRequirements(m_Intake);
    }

    public void execute(){
        m_Intake.stopIntake();
    }    

    public boolean isFinished(){
        return true;
    }
}