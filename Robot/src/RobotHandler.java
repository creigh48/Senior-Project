/**
 *
 * @author Jeffrey Creighton
 * This class will act as the communications link between the computer and the robot.
 */
import java.util.Random;
public class RobotHandler {
    
    public RobotHandler(){
        //put all the connection info in here 
        
    }
    public int moveRobot(int armRot, int rakeRot){
        // tell the robot to move from here
        int distance_traveled = 0;
        Random random = new Random();
        distance_traveled = random.nextInt(10);
        //assign distance_traveled to the tachometer 
        return distance_traveled;
    }
          
}
