package frc.robot.commands;

import frc.robot.subsystems.Lift;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

public class JoystickLift extends CommandBase {
    private final Lift m_Lift;
    private DoubleSupplier m_liftSpeed;
    
    public JoystickLift(Lift subsystem, DoubleSupplier liftSpeed){
        m_Lift = subsystem;
        addRequirements(m_Lift);
        m_liftSpeed = liftSpeed;
    }

    public void execute(){
        m_Lift.moveLiftDeadband(m_liftSpeed.getAsDouble());
    }

    public boolean isFinished(){
        return false;
    }
} 