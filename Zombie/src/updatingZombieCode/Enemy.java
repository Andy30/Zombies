package updatingZombieCode;

/**
 * @author Andy Jenkins
 */
public abstract class Enemy extends MovingImage {

	private int xCharPosition;
	private int yCharPosition;
	
	/**
	 * Creates a new enemy at the given position
	 * 
	 * @param peel the Peel to chase
	 */
	public Enemy(Peel peel) {	
		//TODO - Create a method to look at which type of Characters have been created instead of just making a Peel.
	}
	
	/**
	 * Move towards the given co-ordinates
	 * 
	 * @param checkX the x co-ordinate to move towards
	 * @param checkY the y co-ordinate to move towards
	 */
	public void moveTowards(double checkX, double checkY)  {
		this.yCharPosition += (int) (this.yCharPosition + ((checkY - this.yCharPosition)/50000));
		this.xCharPosition += (int) (this.xCharPosition + ((checkX - this.xCharPosition)/50000));			
	}
	
}
