package updatingZombieCode;

import java.awt.Rectangle;

/**
 * @author Andy Jenkins
 */
public class Windows extends Enemy {

	private String[][] windows = { { "windows_logo.jpg" } };

	/**
	 * Create a new windows character
	 * 
	 * @param peel
	 *            the peel to chase
	 * @param xWindowPosition
	 *            the x co-ordinate of this windows logo
	 * @param yWindowPosition
	 *            the y co-ordinate of this windows logo
	 */
	public Windows(Character chara, int xPosition, int yPosition) {
		super(chara, xPosition, yPosition);
		this.initializeImages(windows);
	}

}
