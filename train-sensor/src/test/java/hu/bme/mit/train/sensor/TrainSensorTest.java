package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainSensor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TrainSensorTest {

    TrainSensorImpl sensor;

    @Mock
    TrainController controller;

    @Mock
    TrainUser user;

    @Before
    public void init()
    {
        MockitoAnnotations.initMocks(this);
        sensor = new TrainSensorImpl(controller, user);

    }

    @Test
    public void TestAlarmsLowerMaringCommunication()
    {

       sensor.overrideSpeedLimit(-273);
       sensor.overrideSpeedLimit(5);
       org.mockito.InOrder inOrderUser = inOrder(user);
       org.mockito.InOrder inOrderController = inOrder(controller);
       inOrderUser.verify(user).setAlarmState(true);
        inOrderUser.verify(user).setAlarmState(false);
        inOrderController.verify(controller).setSpeedLimit(-273);
        inOrderController.verify(controller).setSpeedLimit(5);
    }

    @Test
    public void TestAlarmsUpperMaringCommunication()
    {
        sensor.overrideSpeedLimit(600);
        org.mockito.InOrder inOrderUser = inOrder(user);
        org.mockito.InOrder inOrderController = inOrder(controller);
        inOrderUser.verify(user).setAlarmState(true);
        inOrderController.verify(controller).setSpeedLimit(600);
    }

    @Test
    public void TestAlarmsDiffMaringCommunication()
    {
        when(controller.getReferenceSpeed()).thenReturn(400);
        sensor.overrideSpeedLimit(15);
        org.mockito.InOrder inOrderUser = inOrder(user);
        org.mockito.InOrder inOrderController = inOrder(controller);
        inOrderController.verify(controller).getReferenceSpeed();
        inOrderUser.verify(user).setAlarmState(true);
    }

    @Test
    public void TestUserDefaultValue()
    {
       assertEquals(user.getAlarmState(),false);

    }





}
