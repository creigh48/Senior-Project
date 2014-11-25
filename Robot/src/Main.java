/**
 *
 * @author Jeffrey Creighton
 *
 */
import java.util.*;

public class Main {
    public static void main(String[] args){
        Algo algo = new Algo();
        RobotGUI gui = new RobotGUI();
        gui.setVisible(true);
        gui.updateCells(algo.grid);
    }
}
