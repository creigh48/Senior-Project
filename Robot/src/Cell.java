/**
 *
 * @author Jeffrey Creighton
 * 
 */
public class Cell {

    private int goodness = 0;

    private int armRot;
    private int rakeRot;

    public Cell() {

    }

    public void setGoodness(int i) {
        goodness = i;
    }

    public int getGoodness() {
        return goodness;
    }

    public int getArmRot() {
        return this.armRot;
    }

    public int getRakeRot() {
        return this.rakeRot;
    }

}