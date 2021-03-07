package hu.bme.mit.train.sensor;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.awt.*;
import java.time.LocalDateTime;

@GwtCompatible
public class Tachograph {

    LocalDateTime currentTime;
    Point joystickPosition;
    Float referenceSpeed;

    Table<LocalDateTime, Point, Float> dataTable;

    public Tachograph(Point position, Float speed){
        dataTable = HashBasedTable.create();
        currentTime = LocalDateTime.now();
        joystickPosition=position;
        referenceSpeed=speed;
        dataTable.put(currentTime,joystickPosition,referenceSpeed);
    }

}