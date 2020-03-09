package frc.robot.rigo;

import java.util.ArrayList;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.Notifier;

public class ReactiveLeds {

	private I2C i2;
	private ArrayList<Character> cmdQueue = new ArrayList<Character>();
	private Notifier arduinoCommThread = new Notifier(new CommandCenter());

	public ReactiveLeds() {
		i2 = new I2C(Port.kOnboard, 4);
		arduinoCommThread.startPeriodic(0.05);
	}

    public void sendToArduino(char input)
    {
		byte[] WriteData = new byte[1];
        WriteData[0] = (byte) input;
		i2.writeBulk(WriteData);
	}

	public void addCmd(Character cmd) {
		cmdQueue.add(cmd);
    }
    
    public class CommandCenter implements Runnable {
		boolean hasArduinoLink = false;

		@Override
		public void run() {
			sendToArduino('Z');
			if (cmdQueue.size() == 0) {

			} else {
				sendToArduino(cmdQueue.get(0));
				cmdQueue.remove(0);

			}
		}		
	}


}
