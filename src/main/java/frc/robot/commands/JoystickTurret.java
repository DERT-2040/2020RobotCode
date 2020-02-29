package frc.robot.commands;

import frc.robot.subsystems.Turret;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

public class JoystickTurret extends CommandBase {
    private final Turret m_Turret;
    private DoubleSupplier m_rotation;
    
    public JoystickTurret(Turret subsystem, DoubleSupplier rotation){
        m_Turret = subsystem;
        addRequirements(m_Turret);
        m_rotation = rotation;
    }

    public void execute(){
        m_Turret.turnTurretDeadband(-1 * m_rotation.getAsDouble());
    }

    public boolean isFinished(){
        return false;
    }
} 