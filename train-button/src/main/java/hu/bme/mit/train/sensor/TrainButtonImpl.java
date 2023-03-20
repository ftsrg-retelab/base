package hu.bme.mit.train.button;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainButton;

public class TrainButtonImpl implements TrainButton {

	private TrainController controller;

	public TrainButtonImpl(TrainController controller) {
		this.controller = controller;
	}

	@Override
	public void enableForceStopMode(boolean mode){
		controller.setForceStopMode(mode);
	}
}
