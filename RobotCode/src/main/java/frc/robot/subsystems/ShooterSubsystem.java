
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ShooterSubsystem extends SubsystemBase{

    private VictorSP victorSP;

    public ShooterSubsystem(int shooterPort, boolean isInverted){
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