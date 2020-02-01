package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

public class JoystickDrive extends CommandBase {
    private final Drivetrain m_Drivetrain;
    private DoubleSupplier m_forward;
    private DoubleSupplier m_rotation;
    private DoubleSupplier m_zAxis;
    
    public JoystickDrive(Drivetrain subsytem, DoubleSupplier forward, DoubleSupplier rotation, DoubleSupplier zAxis){
        m_Drivetrain = subsytem;
        addRequirements(m_Drivetrain);
        m_forward = forward;
        m_rotation = rotation;
        m_zAxis = zAxis;
    }

    public void execute(){
        m_Drivetrain.driveDeadband(m_rotation.getAsDouble(), m_forward.getAsDouble(), m_zAxis.getAsDouble());
    }
}