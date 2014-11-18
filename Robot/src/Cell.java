/**
 *
 * @author Jeffrey Creighton
 * 
 */
public class Cell {

    private int goodness = 0;
    private int rewardsUp = 0;
    private int rewardsDown = 0;
    private int rewardsLeft = 0;
    private int rewardsRight = 0;

    private int armRot;
    private int rakeRot;

    public Cell(int arm, int rake) { //grid positions
        this.armRot = arm;
        this.rakeRot = rake;
    }

    public void setGoodness(int i) { //comment test
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
    
    public int getrewardsUp() {
    	return rewardsUp;
    }
    public int getrewardsDown() {
    	return rewardsDown;
    }
    public int getrewardsLeft() {
    	return rewardsLeft;
    }
    public int getrewardsRight() {
    	return rewardsRight;
    }
    public void setRewardsUp(int newRewards) {
    	rewardsUp = newRewards;
    }
    public void setRewardsDown(int newRewards) {
    	rewardsDown = newRewards;
    }
    public void setRewardsLeft(int newRewards) {
    	rewardsLeft = newRewards;
    }
    public void setRewardsRight(int newRewards) {
    	rewardsRight = newRewards;
    }
    

}
