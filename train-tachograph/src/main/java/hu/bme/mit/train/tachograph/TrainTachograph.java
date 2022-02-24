package hu.bme.mit.train.tachograph;

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

    private Table<CurrentTime,  JoystickPosition, ReferenceSpeed> table;

    public  TrainTachograph(){
        //konstruktor
    }

    public void AddValueTachograph(LoalTime time, Integer JPosition, Integer RSpeed){
        //elem hozzáadása a táblához
    }
}
