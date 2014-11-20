
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
    
    private static final int n = 5;
    
    static Cell[][] grid = {
    	{new Cell(0,0), new Cell(-45,45), new Cell(45,90), new Cell(-90,45), new Cell(-45,45)},
    	//{new Cell(), new Cell(), new Cell(), new Cell(), new Cell()}
    	
    						
    						};
    //Fill the grid with the correct cell information here
    //grid[0][0] = new Cell(0,0);
    //grid[0][1] = new Cell(-45,45);
    //grid[0][2] = new Cell(45,90);
    //grid[0][3] = new Cell(-90,45);
    //grid[0][4] = new Cell(-45,45);
   
    //parameter to explore/exploit
    static final double modeCheck = 0.1;

    //r is set to exlpore immediately
    private static double r = 0.0; 
    
    public static void step() {
        boolean notDone = true;
        currentCell = grid[xVal][yVal];//default starting cell 

        if (r < modeCheck) {
            explore();
        } else {
            exploit();
        }

        updateRobot();
        updateGUI();
        r = random.nextDouble(); //find next mode
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
        boolean moved = false;
        double n = 0.1;
        //find the cell with the greatest goodness value
        double right = n*grid[xVal+1][yVal].getGoodness() + grid[xVal+1][yVal].getrewardsRight();
        double left = n*grid[xVal-1][yVal].getGoodness() + grid[xVal-1][yVal].getrewardsLeft();
        double up = n*grid[xVal][yVal+1].getGoodness() + grid[xVal][yVal+1].getrewardsUp();
        double down = n*grid[xVal][yVal-1].getGoodness() + grid[xVal][yVal-1].getrewardsDown();
        
        if(right > left && right > up && right > down) {
            moved = moveRight();
        }
        else if(left > right && left > up && left >down){
            moved = moveLeft();
        }
        else if(up > right && up >left && up > down){
            moved = moveUp();
        }
        else if(down > right && down > left && down > up){
            moved = moveDown();
        }
        else
            explore();
    }

    /**
     * Send the new position to the robot
     */
    private static void updateRobot() {
        //use position information from currentCell
        //to move the robot
    }

    /**
     * Send the new information to the GUI
     */
    private static void updateGUI() {    
        //Use this information to update the position which the robot is in
    }
    
    private static boolean moveUp() {
        boolean success = false;
        if(yVal > 0) {
            yVal = yVal - 1;            
            //prevCell = currentCell;
            //currentCell = grid[xVal][yVal];
            success = true;
        }
        return success;
    }
    
    private static boolean moveDown() {
        boolean success = false;
        if(yVal < n){
            yVal = yVal + 1;                        
            //prevCell = currentCell;
            //currentCell = grid[xVal][yVal];
            success = true;
        }
        return success;
    }
    
    private static boolean moveLeft() {
        boolean success = false;
        if(xVal > 0) {
            xVal = xVal - 1;                        
            //prevCell = currentCell;
            //currentCell = grid[xVal][yVal];
            success = true;
        }
        return success;
    }
    
    private static boolean moveRight() {
        boolean success = false;
        if(xVal < n) {
            xVal = xVal + 1;                        
            //prevCell = currentCell;
            //currentCell = grid[xVal][yVal];
            success = true;
        }
        return success;
    }
    
    public static Cell[][] getGrid(){
        return grid;
    }
}
