# verification-lab

This is a sample application for the verification laboratory.

## Overview

The application represents a simple train controller system with the following three components.

* Sensor: The sensor can detect the change in the speed limit of the track and can signal in such cases to the controller.
* Controller: The controller is responsible for controlling the reference speed of the train. The reference speed is set by the user, but the speed limit must also be kept.
* User: The user can manipulate the reference speed of the train using a joystick.

Setting the reference speed of the train works in the following way. The user can set the position of a joystick, which can be zero or a positive/negative number. In each time unit, the controller adds the position of the joystick to the current reference speed, therefore the reference speed does not change if the position is zero, it is incremented if the position is positive and it is decremented if the position is negative. After each change, the speed limit is checked and enforced. The figure below illustrates an example.

![speed example](doc/speed_example.png)

First, the reference speed and the joystick is both at zero. At the first time unit, the joystick is set to a positive value, thus the reference speed is also incremented. As the joystick remains at a positive value, the reference speed is incremented again. However, it reaches the speed limit so in the next step it is not incremented even though the joystick still has a positive value. Later, the joystick is set to a negative position for one time unit, making the reference speed to decrease as well.
