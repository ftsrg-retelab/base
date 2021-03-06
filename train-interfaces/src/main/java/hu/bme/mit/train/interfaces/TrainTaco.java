package hu.bme.mit.train.interfaces;

public interface TrainTaco {

    int getJoystickPosition();

    boolean getAlarmFlag();

    void overrideJoystickPosition(int joystickPosition);

}