package updatingZombieCode;

/**
 * @author Andy Jenkins, Dan Cassey
 */
public abstract class Character extends MovingImage {

	/**
	 * Creates a new character
	 * 
	 * @param xMovement
	 *            the speed at which this character can move horizontally
	 * @param yMovement
	 *            the speed at which this character can move vertically
	 */
	public Character(int xPosition, int yPosition) {
		super(xPosition, yPosition);
	}

}
