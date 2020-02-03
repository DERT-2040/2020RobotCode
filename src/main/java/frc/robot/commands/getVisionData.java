package frc.robot.commands;

import frc.robot.subsystems.VisionCommunication;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class getVisionData extends CommandBase {
    private final VisionCommunication m_VisionCommunication;
    
    public getVisionData(VisionCommunication subsytem){
        m_VisionCommunication = subsytem;
        addRequirements(m_VisionCommunication);
    }

    public void initialize(){
        m_VisionCommunication.getData();
    }

    public boolean isFinished(){
        return true;
    }
}