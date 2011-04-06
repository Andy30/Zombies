package updatingZombieCode;

import java.awt.Rectangle;

/**
 * @author Andy Jenkins
 */
public abstract class Enemy extends MovingImage {

	private Character chara;
	private Rectangle enemyWindow = new Rectangle();
	private Rectangle characterRect = new Rectangle();
	private double delta;

	/**
	 * Creates a new enemy at the given position
	 * 
	 * @param peel the Peel to chase
	 */
	public Enemy(Character chara, int xPosition, int yPosition) {
		super(xPosition, yPosition);
		this.chara = chara;
		this.delta = 3;
	}
	
	public Character getChar() {
		return this.chara;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}

	/**
	 * Move towards the given co-ordinates
	 * 
	 * @param checkX the x co-ordinate to move towards
	 * @param checkY the y co-ordinate to move towards
	 */
	public void moveTowards()  {
		
	// Get the distance between the friendly and the Zombie.
	int dx = chara.getX() - this.getX();
	int dy = chara.getY() - this.getY();
	
	// Move the given distance delta towards the enemy.
	int dxPrime = (int) (delta * Math.sin(Math.atan(dx/dy)));
	int dyPrime = (int) (delta * Math.cos(Math.atan(dx/dy)));
	
	this.move(dxPrime, dyPrime);
	}
	
	/**
	 * Check to see if this windows logo collides with the character it's
	 * chasing
	 * 
	 * @return true if the characters collide, false otherwise
	 */
	public boolean collidesWith() {
		characterRect.setBounds(getChar().getX(), getChar().getY(), getChar()
				.getImageWidth(), getChar().getImageHeight());
		enemyWindow.setBounds(getX(), getY(), getChar()
				.getImageWidth(), getChar().getImageHeight());
		return characterRect.intersects(enemyWindow);
	}
	
}
