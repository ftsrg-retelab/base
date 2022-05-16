package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class FollowThread extends Thread{
    TrainController trainController;
    public FollowThread(TrainController tc){
        trainController = tc;
    }
    public void run(){
        while (true){
            trainController.followSpeed();
        }
    }
}
