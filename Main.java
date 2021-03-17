import hu.bme.mit.train.system.TrainSystem;

public class Main{

  Timer timer = new Timer("Timer");


  public static void main(String[] arg){
    TrainSystem system = new TrainSystem();
    system.getController().setJoystickPosition(0); 


    TimerTask task = new TimerTask() {
      public void run() {
        system.getController().followSpeed();
      }
    };
    timer.schedule(task, 0, 0.5);

  }  

}
