package hu.bme.mit.train.controller;

import static org.junit.jupiter.api.Assertions.*;

class TrainControllerImplTest {

    @org.junit.jupiter.api.Test
    void followSpeed() {
        TrainControllerImpl controller = new TrainControllerImpl();
        controller.setSpeedLimit(-2);
        controller.followSpeed();
        assertEquals(0, controller.getReferenceSpeed());
    }
}