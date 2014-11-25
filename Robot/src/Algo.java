
/**
 *
 * @author Jeffrey Creighton
 * 
 */
import java.util.*;

public class Algo {
    static RobotHandler handler = new RobotHandler();
    
    static Random random = new Random();
    private static Cell currentCell;
    private static Cell prevCell;
    
    private static int xVal = 0;
    private static int yVal = 0;
    
    private static final int n = 5;
    
    static Cell[][] grid = {
    	
    	{new Cell(0,0), new Cell(-45, 45), new Cell(-90,0), new Cell(-45,-90), new Cell(-90,90)},
    	{new Cell(-90, 45), new Cell(45,90), new Cell(-45,0), new Cell(-90,-45), new Cell(-45,90)},
    	{new Cell(0,-90), new Cell(0,-45), new Cell(-90,-90), new Cell(0,45), new Cell(0,90)},
    	{new Cell(45,-90), new Cell(45,-45), new Cell(45,0), new Cell(45, 45), new Cell(-45,-45)},
    	{new Cell(90,-90), new Cell(90,-45), new Cell(90,0), new Cell(90, 45), new Cell(90,90)}
    						
    	};
   
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
        
        int current_goodness = currentCell.getGoodness();
        
        double[] cell_list = new double[4];
        
        if( xVal < 4){
            cell_list[0] = current_goodness + n * (findLargest(getCellRewards(grid[xVal+1][yVal])) - current_goodness);
        }
        if(xVal > 0){
            cell_list[1] = current_goodness + n * (findLargest(getCellRewards(grid[xVal-1][yVal])) - current_goodness);
        }
        if(yVal < 4){
            cell_list[2] = current_goodness + n * (findLargest(getCellRewards(grid[xVal][yVal+1])) - current_goodness);
        }
        if(yVal > 0){
            cell_list[3] = current_goodness + n * (findLargest(getCellRewards(grid[xVal][yVal-1])) - current_goodness);
        }
        
        int largest = findLargestDouble(cell_list);
        if(largest == 0) {
            moved = moveRight();
        }
        else if(largest == 1){
            moved = moveLeft();
        }
        else if(largest == 2){
            moved = moveUp();
        }
        else if(largest == 3){
            moved = moveDown();
        }
        else
            explore();
    }

    private static int[] getCellRewards(Cell c){
        int[] rewards_list = new int[4];
        rewards_list[0] = (c.getrewardsUp());
        rewards_list[1] = (c.getrewardsDown());
        rewards_list[2] = (c.getrewardsLeft());
        rewards_list[3] = (c.getrewardsRight());
        return rewards_list;
    }
    
    private static int findLargestDouble(double[] list){
        int index = 0;
        double largest = list[0];
        for(int i = 0; i < list.length; i++) {
            if(list[i] > largest){
                largest = list[i];
                index = i;
            }
        }
        return index; 
    }
    private static int findLargest(int[] list){
        int index = 0;
        int largest = list[0];
        for(int i = 0; i < list.length; i++) {
            if(list[i] > largest){
                largest = list[i];
                index = i;
            }
        }
        return index;
    }
    /**
     * Send the new position to the robot
     */
    private static void updateRobot(int direction) {
        int new_rewards = handler.moveRobot(currentCell.getArmRot(), currentCell.getRakeRot());
        if(direction == 0){
            prevCell.setRewardsUp(new_rewards);
        }
        else if(direction == 1){
            prevCell.setRewardsDown(new_rewards);
        }
        else if(direction == 2){
            prevCell.setRewardsLeft(new_rewards);
        }
        else if(direction == 3){
            prevCell.setRewardsRight(new_rewards);
        }
        
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
            prevCell = currentCell;
            yVal = yVal + 1;
            currentCell = grid[xVal][yVal];
            
            updateRobot(0);
            
            success = true;
        }
        return success;
    }
    
    private static boolean moveDown() {
        boolean success = false;
        if(yVal < n){                        
            prevCell = currentCell;
            yVal = yVal -1;
            currentCell = grid[xVal][yVal];
            
            updateRobot(1);
            
            success = true;
        }
        return success;
    }
    
    private static boolean moveLeft() {
        boolean success = false;
        if(xVal > 0) {
            prevCell = currentCell;
            xVal = xVal - 1;
            currentCell = grid[xVal][yVal];
            
            updateRobot(2);
            
            success = true;
        }
        return success;
    }
    
    private static boolean moveRight() {
        boolean success = false;
        if(xVal < n) {
            prevCell = currentCell;
            xVal = xVal + 1;
            currentCell = grid[xVal][yVal];
            
            updateRobot(3);
            
            success = true;
        }
        return success;
    }
}
