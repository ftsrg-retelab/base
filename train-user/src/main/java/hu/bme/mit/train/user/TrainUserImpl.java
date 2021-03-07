package hu.bme.mit.train.user;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainUserImpl implements TrainUser {

    private TrainController mController;
    private int mJoystickPosition;

    public TrainUserImpl(TrainController controller) {
        this.mController = controller;
    }

    @Override
    public boolean getAlarmFlag() {
        return false;
    }

    @Override
    public int getJoystickPosition() {
        return mJoystickPosition;
    }

    @Override
    public void overrideJoystickPosition(int joystickPosition) {
        this.mJoystickPosition = joystickPosition;
        mController.setJoystickPosition(joystickPosition);
    }
}
