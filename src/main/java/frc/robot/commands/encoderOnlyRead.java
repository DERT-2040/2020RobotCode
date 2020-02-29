package frc.robot.commands;

import frc.robot.subsystems.AS5600EncoderPwm;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class encoderOnlyRead extends CommandBase {
    private final AS5600EncoderPwm m_AS5600EncoderPwm;

    public encoderOnlyRead(AS5600EncoderPwm subsytem){
        m_AS5600EncoderPwm = subsytem;
        addRequirements(m_AS5600EncoderPwm);
    }

    public void execute(){
        m_AS5600EncoderPwm.getPwmPosition();
    }

    public boolean isFinished(){
        return true;
    }
}