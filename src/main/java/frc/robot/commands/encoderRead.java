package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import frc.robot.subsystems.AS5600EncoderPwm;
public class encoderRead extends PIDSubsystem {
    private final WPI_TalonSRX yourTalon = new WPI_TalonSRX(1);
    private final AS5600EncoderPwm encoder = new AS5600EncoderPwm(yourTalon.getSensorCollection());
    public encoderRead() {
        super(new PIDController(0, 0, 0));
    }
    @Override
    protected void useOutput(double output, double setpoint) {
        yourTalon.set(output);
    }
    @Override
    protected double getMeasurement() {
        System.out.print("yeet");
        return encoder.getPwmPosition();
    }
}