
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
    private static ArrayList<Cell> cells= new ArrayList<Cell>();
    private static int xVal = 0;
    private static int yVal = 0;
    private int steps = 0;
    private static final int n = 5;
    
    
    static Cell[][] grid = {
    	
    	{new Cell(0,0), new Cell(-45, 45), new Cell(-90,0), new Cell(-45,-90), new Cell(-90,90)},
    	{new Cell(-90, 45), new Cell(45,90), new Cell(-45,0), new Cell(-90,-45), new Cell(-45,90)},
    	{new Cell(0,-90), new Cell(0,-45), new Cell(-90,-90), new Cell(0,45), new Cell(0,90)},
    	{new Cell(45,-90), new Cell(45,-45), new Cell(45,0), new Cell(45, 45), new Cell(-45,-45)},
    	{new Cell(90,-90), new Cell(90,-45), new Cell(90,0), new Cell(90, 45), new Cell(90,90)}
    						
    	};
   
    //parameter to explore/exploit
    static final double modeCheck = 0.8;

    //r is set to exlpore immediately
    private static double r = 0.0; 
    
    public static void step() {
        
        currentCell = grid[xVal][yVal];//default starting cell 

        if (r < modeCheck) {
            explore();
        } else {
            exploit();
        }


        r = random.nextDouble(); //find next mode
    }

    /**
     * Makes the next move made by the robot exploration
     */
    private static void explore() {
        boolean notFound = true;
        int choice = 0;
        while(notFound) {
            choice = random.nextInt(4) + 1;
            
            if(choice == 1){
                notFound = moveUp();
            }
            else if(choice == 2){
                notFound = moveDown();
            }
            else if(choice == 3){
                notFound = moveLeft();
            }
            else if(choice == 4){
                notFound = moveRight();
            }
        }
        System.out.println("random -- " + choice);
    }

    /**
     * Makes the next move made by the robot exploitation
     */
    private static void exploit() {
        boolean moved = false;
        double n = 0.1;    
        
        int current_goodness = currentCell.getGoodness();
        
        double[] cell_list = new double[4];
        
        if(yVal < 4 && yVal > 0 && xVal > 0 && xVal < 4){
            cell_list[0] = current_goodness + n * (findLargest(getCellRewards(grid[xVal+1][yVal])) - current_goodness);
        }
        if(yVal < 4 && yVal > 0 && xVal > 0 && xVal < 4){
            cell_list[1] = current_goodness + n * (findLargest(getCellRewards(grid[xVal-1][yVal])) - current_goodness);
        }
        if(yVal < 4 && yVal > 0 && xVal > 0 && xVal < 4){
            cell_list[2] = current_goodness + n * (findLargest(getCellRewards(grid[xVal][yVal-1])) - current_goodness);
        }
        if(yVal < 4 && yVal > 0 && xVal > 0 && xVal < 4){
            
            cell_list[3] = current_goodness + n * (findLargest(getCellRewards(grid[xVal][yVal+1])) - current_goodness);
        }
        
        int largest = findLargestDouble(cell_list);
        
        if(largest == 0) {
            currentCell.setGoodness((int) cell_list[0]);
            moved = moveUp();
        }
        else if(largest == 1){
            currentCell.setGoodness((int) cell_list[1]);
            moved = moveDown();
        }
        else if(largest == 2){
            currentCell.setGoodness((int) cell_list[2]);
            moved = moveLeft();
        }
        else if(largest == 3){
            currentCell.setGoodness((int) cell_list[3]);
            moved = moveRight();
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
    
    private static boolean moveUp() {
        boolean success = true;
        if(yVal < 4) {                        
            prevCell = currentCell;
            yVal = yVal + 1;
            System.out.println("Up");
            System.out.println(xVal + "," + yVal);
            currentCell = grid[xVal][yVal];
            
            updateRobot(0);
            
            success = false;
        }
        return success;
    }
    
    private static boolean moveDown() {
        boolean success = true;
        if(yVal > 0){                        
            prevCell = currentCell;
            yVal = yVal -1;
            System.out.println("Down");
            System.out.println(xVal + "," + yVal);
            currentCell = grid[xVal][yVal];
            
            updateRobot(1);
            
            success = false;
        }
        return success;
    }
    
    private static boolean moveLeft() {
        boolean success = true;
        if(xVal > 0) {
            prevCell = currentCell;
            xVal = xVal - 1;
            System.out.println("Left");
            System.out.println(xVal + "," + yVal);
            currentCell = grid[xVal][yVal];
            
            updateRobot(2);
            
            success = false;
        }
        return success;
    }
    
    private static boolean moveRight() {
        boolean success = true;
        if(xVal < 4) {
            prevCell = currentCell;
            xVal = xVal + 1;
            System.out.println("Right");
            System.out.println(xVal + "," + yVal);
            currentCell = grid[xVal][yVal];
            
            updateRobot(3);
            
            success = false;
        }
        return success;
    }    
    public static Cell getCurrentCell(){
        return currentCell;
    }
    public static Cell getPreviousCell(){
        return prevCell;
    }
    private static void returnToZero(){
        xVal = 0;
        yVal = 0;
        prevCell = currentCell;
        currentCell = grid[xVal][yVal];
    }
    private static void clearGrid(){
        for(int i = 0; i < 5; i ++){
            for(int j = 0; j < 5; j++){
                grid[i][j].clearCellValues();
            }
        }
    }
    public static void resetAlgo(){
        returnToZero();
        clearGrid();
        
    }
}
