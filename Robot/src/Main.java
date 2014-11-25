/**
 *
 * @author Jeffrey Creighton
 *
 */
public class Main {
    static RobotGUI gui = new RobotGUI();
    static Algo algo = new Algo();
    private static boolean moving = true;
    
    
    
    public static void main(String[] args){
        gui.setVisible(true);
        gui.updateCells(Algo.grid, Algo.getCurrentCell(), Algo.getPreviousCell());
    }
    
    
    public static void startMoving(){
        algo.step();
        gui.updateCells(Algo.grid, Algo.getCurrentCell(), Algo.getPreviousCell());
    }
    
    public static void reset(){
        Algo.resetAlgo();
        gui.updateCells(Algo.grid, Algo.getCurrentCell(), Algo.getPreviousCell());
    }
}
    

