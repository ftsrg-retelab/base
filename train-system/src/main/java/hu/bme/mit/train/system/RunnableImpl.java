package hu.bme.mit.train.system;

import hu.bme.mit.train.interfaces.TrainController;

public class RunnableImpl implements Runnable{
    private TrainController controller;
    public RunnableImpl(TrainController c){
        this.controller = c;
    }
    public Boolean r = true;
    public void run(){
        while(r){
            controller.followSpeed();
            try{
                Thread.sleep(1000);
            }catch(Exception e){
            }
        }
    }
}
