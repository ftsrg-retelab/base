package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;

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
		int min = 0;
		int zero = 90;
		int max = 180;

		if (joystickPosition > (zero -max/16) && joystickPosition < (zero+max / 16)) {
			this.joystickPosition = min;
		} else {
			this.joystickPosition = joystickPosition;
		}
		
		controller.setJoystickPosition(joystickPosition);
	}

}
