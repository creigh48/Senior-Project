/**
 *
 * @author Jeffrey Creighton
 */
import java.util.Random;
public class RobotHandler {
    
    public RobotHandler(){
        
    }
    public int moveRobot(int armRot, int rakeRot){
        int distance_traveled = 0;
        Random random = new Random();
        distance_traveled = random.nextInt(10);    
        return distance_traveled;
    }
          
}
