package hu.bme.mit.train.controller;

public class Dashboard {


    private int speed;
    private int position;

    public Dashboard(int currentSpeed,int joyPosition){
        speed =currentSpeed;
        position = joyPosition;
    }

    public void showDashboard(){
        System.out.println("Speed : "+getSpeed() );
        System.out.println("joyPostion: "+getPosition());
    }
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
