package hu.bme.mit.train.user;

import hu.bme.mit.train.clock.TrainClockTimer;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import java.util.Timer;

public class TrainUserImpl implements TrainUser {

	private final TrainClockTimer timerTask;
	private TrainController controller;
	private int joystickPosition;
	Timer controllerTimer = new Timer("Timer");

	public TrainUserImpl(TrainController controller, TrainClockTimer timerTask) {
		this.controller = controller;
		this.timerTask = timerTask;
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
		System.out.println("Changing joystick to: "+ joystickPosition);
		timerTask.interrupt();
		//controller.followSpeed();

	}

}
