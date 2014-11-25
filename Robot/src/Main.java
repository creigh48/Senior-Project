/**
 *
 * @author Jeffrey Creighton
 *
 */
import java.util.*;

public class Main {
    static Algo algo = new Algo();
    static RobotGUI gui = new RobotGUI();
    private static boolean moving = true;
   
    
    
    public static void main(String[] args){
        gui.setVisible(true);
        gui.updateCells(algo.grid);
    }
    
    
    public static void startMoving(){
        algo.step();
        gui.updateCells(algo.grid);
    }
    
    public static void reset(){
        algo = new Algo();
        gui.updateCells(algo.grid);
    }
}
    

