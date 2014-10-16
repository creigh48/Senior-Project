
/**
 *
 * @author Jeffrey Creighton
 * 
 */
import java.util.*;

public class Algo {
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
        while(notFound) {
            int choice = random.nextInt(2) + 1;
            switch (choice) {
                case 1: notFound = moveUp();
                    break;
                case 2: notFound = moveDown();
                    break;
                case 3: notFound = moveRight();
                    break;
                case 4: notFound = moveLeft();
                    break;
            }
        }
    }

    /**
     * Makes the next move made by the robot exploitation
     */
    private static void exploit() {
        
    }

    /**
     * Send the new position to the robot
     */
    private static void updateRobot() {
    }

    /**
     * Send the new information to the GUI
     */
    private static void updateGUI() {       
    }
    
    private static boolean moveUp() {
        boolean success = false;
        if(yVal > 0) {
            yVal = yVal -1;
            success = true;
        }
        return success;
    }
    
    private static boolean moveDown() {
        boolean success = false;
        if(yVal < 5){
            yVal = yVal -1;
            success = true;
        }
        return success;
    }
    
    private static boolean moveLeft() {
        boolean success = false;
        if(xVal > 0) {
            xVal = xVal -1;
            success = true;
        }
        return success;
    }
    
    private static boolean moveRight() {
        boolean success = false;
        if(xVal < 5) {
            xVal = xVal + 1;
            success = true;
        }
        return success;
    }
}
