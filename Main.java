import hu.bme.mit.train.system.TrainSystem;

public class Main{
  public static void main(String[] arg){
    TrainSystem system = new TrainSystem();
    system.getController().setJoystickPosition(0);    
  }  

}
