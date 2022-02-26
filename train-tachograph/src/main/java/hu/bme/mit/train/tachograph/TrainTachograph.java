package hu.bme.mit.train.tachograph;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.controller.TrainControllerImpl;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.sensor.TrainSensorImpl;
import hu.bme.mit.train.user.TrainUserImpl;

import java.time.LocalTime;

public class TrainTachograph {

    private TrainController controller = new TrainControllerImpl();
    private TrainUser user = new TrainUserImpl(controller);
    private TrainSensor sensor = new TrainSensorImpl(controller, user);
    private Table<LocalTime, Integer, Integer> infoTable;

    public TrainTachograph() {
        infoTable
                = HashBasedTable.create();

        infoTable.put(java.time.LocalTime.now(), user.getJoystickPosition(), controller.getReferenceSpeed());
    }

    public void AddValuesToTachograph(LocalTime time, Integer joystickPosition, Integer referenceSpeed) {
        infoTable.put(
                time,
                joystickPosition,
                referenceSpeed
        );
    }

    public boolean TableIsEmpty() { return infoTable.isEmpty(); }

    public TrainController getController() {
        return controller;
    }

    public TrainSensor getSensor() {
        return sensor;
    }

    public TrainUser getUser() {
        return user;
    }

}
