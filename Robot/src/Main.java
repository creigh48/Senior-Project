/**
 *
 * @author Jeffrey Creighton
 *
 */
import java.util.*;

public class Main {

    static Random random = new Random();
    private static Cell currentCell;
    private static Cell prevCell;
    
    private static int xVal = 0;
    private static int yVal = 0;
    
    static Cell[][] grid = new Cell[5][5];
    //Fill the grid with the correct cell information here

    //
    static final double modeCheck = 0.1;

    public static void main(String[] args) {

        boolean notDone = true;
        double r = 0.0;//r is set to exlpore immediately 
        
        currentCell = grid[xVal][yVal];//default starting cell 
        
        do {//Start loop

            if (r < modeCheck) {
                //Explore -- Perform a random action
            } else {
                //Exploit -- Perform calculated action
            }

            r = random.nextDouble(); //find next mode
        } while (notDone);
    }

    /**
     * Makes the next move made by the robot exploration
     */
    private static void explore() {
        boolean notFound = true;
        
    }

    /**
     * Makes the next move made by the robot exploitation
     */
    private static void exploit() {

    }

    /**
     * 
     */
    private static void updateRobot() {
    }

    /**
     * 
     */
    private static void updateGUI() {
    }
}
