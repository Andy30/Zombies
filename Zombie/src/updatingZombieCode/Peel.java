package updatingZombieCode;

/**
 * A more specific Character describing the inimitable Dr. Peel.
 * 
 * @author Andy30
 */
public class Peel extends Character {
	
  /**
   * crappyHardcodedImageFileLinks
   * FIXME this is going to cause lots of code duplication
   */
  private static String[][] crappyHardcodedImageFileLinks = { {"/roger_peel.jpg" }, { "/explosion_clip_art_13149.jpg" } };
  
	/** Whether he's still alive. */
	private boolean isAlive;
	
	/** FIXME I have no idea what this is, should it be in the superclass? */
	private int setFrame;
	
	/**
	 * Makes a Peel.
	 * @param xPosition
	 * @param yPosition
	 * @param xMovement
	 * @param yMovement
	 */
	public Peel(int xPosition, int yPosition, int xMovement, int yMovement) {
		super(crappyHardcodedImageFileLinks, xPosition, yPosition, xMovement, yMovement);
		

		isAlive = true;
	}

	
	/**
	 * @return Whether Roger is still alive
	 */
	public boolean alive()  {
		return isAlive;
	}

}
