/**
 *
 * @author Jeffrey Creighton
 *
 */
import java.util.*;

public class Main {

    static Random random = new Random();
    private static Cell currentCell;
    static Cell[][] grid = new Cell[5][5];
    //Fill the grid with the correct cell information here

    //
    static final double modeCheck = 0.1;

    public static void main(String[] args) {

        boolean notDone = true;

        currentCell = grid[0][0];

        double r = 0.0;//r is set to exlpore immediately 

        do {//Start loop

            if (r < modeCheck) {
                //Explore -- Perform a random action
            } else {
                //Exploit -- Perform calculated action
            }

            r = random.nextDouble(); //find next mode
        } while (notDone);
    }

    private static void explore() {

    }

    private static void exploit() {

    }

    private static void updateRobot() {
    }

    private static void updateGUI() {
    }
}
