package frc.robot.rigo;

import java.util.ArrayList;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.Notifier;

public class ReactiveLeds {

	I2C i2;

	public ArrayList<String> cmdQueue = new ArrayList<String>();

	Notifier notify = new Notifier(new CommandCenter());

	public ReactiveLeds() {
		i2 = new I2C(Port.kOnboard, 4);
		notify.startPeriodic(0.05);
	}

	public void sendToArduino(String input) {
		char[] CharArray = input.toCharArray();
		byte[] WriteData = new byte[CharArray.length];
        for (int i = 0; i < CharArray.length; i++) 
        {
			WriteData[i] = (byte) CharArray[i];
		}

		i2.writeBulk(WriteData);
	}

	public void addCmd(String cmd) {
		cmdQueue.add(cmd);
    }
    
    public class CommandCenter implements Runnable {
		boolean hasArduinoLink = false;

		@Override
		public void run() {
			sendToArduino("Z");
			if (cmdQueue.size() == 0) {

			} else {
				sendToArduino(cmdQueue.get(0));
				cmdQueue.remove(0);

			}
		}		
	}


}
