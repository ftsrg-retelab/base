package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.interfaces.TrainTachograph;


public class TrainUserImpl implements TrainUser {

	private TrainController controller;
	private int joystickPosition;
	private boolean AlarmFlag=false;

	public TrainUserImpl(TrainController controller) {
		this.controller = controller;
	}

	@Override
	public boolean getAlarmFlag() {
		return AlarmFlag;
	}

	@Override
	public int getJoystickPosition() {
		return joystickPosition;
	}

	@Override
	public void overrideJoystickPosition(int joystickPosition) {
		this.joystickPosition = joystickPosition;
		controller.setJoystickPosition(joystickPosition);
		tachograph.putTachographTable();
	}

}
