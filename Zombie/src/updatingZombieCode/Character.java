package updatingZombieCode;

public abstract class Character extends MovingImage {

	private int xMovement;
	private int yMovement;
	
	public Character(int xMovement, int yMovement) {
	}
	
	//Class for group power ups. I.e. Here I could increase all members speed.
	
	public int getxMovement() {
		return xMovement;
	}

	public void setxMovement(int xMovement) {
		this.xMovement = xMovement;
	}

	public int getyMovement() {
		return yMovement;
	}

	public void setyMovement(int yMovement) {
		this.yMovement = yMovement;
	}
	
}
