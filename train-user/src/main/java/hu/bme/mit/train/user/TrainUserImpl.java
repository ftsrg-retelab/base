package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainUserImpl implements TrainUser {

	23private TrainController controller;
	private int joystickPosition;

	public TrainUserImpl(TrainController controller) {
		//Set controller
		this.controller = controller;
	}

	@Override
	public boolean getAlarmFlag() {
		//Return false
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

}
