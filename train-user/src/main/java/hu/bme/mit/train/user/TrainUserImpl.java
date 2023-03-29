package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private boolean lock = false;

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
		if(!lock){
			this.joystickPosition = joystickPosition;
			controller.setJoystickPosition(joystickPosition);
		}
	}

	@Override
	public void lockSpeed() {
		lock = true;
	}

	@Override
	public void releaseSpeed() {
		lock = false;
	}
}
