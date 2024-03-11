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
        this.joystickPosition = joystickPosition;
        controller.setJoystickPosition(joystickPosition);

        // Check if speed limit has been reached after setting joystick position
        if (controller.isSpeedLimitReached()) {
            // Provide feedback to the user here
            System.out.println("Warning: Speed limit reached!");
			System.out.println("You will not be able to make the train faster.");
        }
    }
}