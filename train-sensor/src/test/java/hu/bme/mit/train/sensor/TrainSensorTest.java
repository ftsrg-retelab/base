package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

     TrainController mockedTrainController;
     TrainSensor sensor;
     TrainUser mockedTrainUser;

    @BeforeEach
    public void before() {
        mockedTrainController = mock(TrainController.class);
        mockedTrainUser = mock(TrainUser.class);
        sensor = new TrainSensorImpl(mockedTrainController, mockedTrainUser);
    }

    @Test
    @DisplayName("Setting a negative value")
    public void GoingUnderAbsoluteLimit() {
        sensor.overrideSpeedLimit(-50);
        Mockito.verify(mockedTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    @DisplayName("Setting a value over 500")
    public void GoingOverAbsoluteLimit() {
        sensor.overrideSpeedLimit(9001);
        Mockito.verify(mockedTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    @DisplayName("Setting the limit to less than half")
    public void SetLimitToLessThanHalf() {
        sensor.overrideSpeedLimit(500);
        when(mockedTrainController.getReferenceSpeed()).thenReturn(400);
        sensor.overrideSpeedLimit(50);
    }

    @Test
    @DisplayName("No alarm triggered")
    public void AlarmDoesNotTrigger() {
        sensor.overrideSpeedLimit(500);
        sensor.overrideSpeedLimit(0);
        when(mockedTrainController.getReferenceSpeed()).thenReturn(200);
        sensor.overrideSpeedLimit(100);
        Mockito.verify(mockedTrainUser, never()).setAlarmState(true);
    }
}
