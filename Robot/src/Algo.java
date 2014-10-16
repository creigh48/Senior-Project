
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
                case 1: moveUp();
                    break;
                case 2: moveDown();
                    break;
                case 3: moveRight();
                    break;
                case 4: moveLeft();
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
    
    private static void moveUp() {
        
    }
    
    private static void moveDown() {
        
    }
    
    private static void moveLeft() {
        
    }
    
    private static void moveRight() {
        
    }
}
