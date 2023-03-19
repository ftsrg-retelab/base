package hu.bme.mit.train.button;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainButtonImpl implements TrainButton {

	private TrainController controller;

	public TrainSensorImpl(TrainController controller) {
		this.controller = controller;
	}
	@Override
	private void enableForceStopMode(boolean){
		controller.setForceStopMode(boolean);
	}
}
