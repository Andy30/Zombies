package updatingZombieCode;

public abstract class Enemy extends MovingImage {

	private int xCharPosition;
	private int yCharPosition;
	
	public Enemy(Peel peel, int xCharPosition, int yCharPosition) {	
		//TODO - Create a method to look at which type of Characters have been created instead of just making a Peel.
	}
	
	public void moveTowards(double checkX, double checkY)  {
		this.yCharPosition += (int) (this.yCharPosition + ((checkY - this.yCharPosition)/10000));
		this.xCharPosition += (int) (this.xCharPosition + ((checkX - this.xCharPosition)/10000));			
	}
	
}
