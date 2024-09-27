package hu.bme.mit.train.user;

import java.util.Timer;
import java.util.TimerTask;

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
		return true;
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

	public TrainUserImpl(){
		super();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				controller.setJoystickPosition(joystickPosition);
			}
		}, 0, 1000);
	}
}
