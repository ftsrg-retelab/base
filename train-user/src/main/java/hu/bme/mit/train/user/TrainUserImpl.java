package hu.bme.mit.train.user;

import java.util.TimerTask;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
/*import org.junit.Test;
import static org.junit.Assert.*;

public class Testing {
	@Test 
	public void testalarm {
		assertFalse(getAlarmflag());
	}
}*/

public class TrainUserImpl extends TimerTask implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private boolean AlarmState;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
	}

	@Override
	public boolean getAlarmFlag() {


		return false;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		controller.setJoystickPosition(joystickPosition);
	}

	@Override
	public boolean getAlarmState() {
		return AlarmState;
	}

	@Override
	public void setAlarmState(boolean alarmState) {
		AlarmState=alarmState;
	}

	@Override
	public void run() {
		overrideJoystickPosition(getJoystickPosition());
		controller.followSpeed();
		
	}

}
