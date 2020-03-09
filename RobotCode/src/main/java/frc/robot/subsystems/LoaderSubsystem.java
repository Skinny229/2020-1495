package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;




public class LoaderSubsystem extends SubsystemBase
{

    private VictorSP victorSP;

    public LoaderSubsystem(int shooterPort, boolean isInverted){
        System.out.println("Shooter Subsystem with Victor PWM PORT:"  + shooterPort);
        victorSP = new VictorSP(shooterPort);
        victorSP.setSafetyEnabled(false);
        victorSP.setInverted(isInverted);
    }


    public void shootForward(double speed){
        speed = Math.abs(speed);
        victorSP.set(speed);
    }


}