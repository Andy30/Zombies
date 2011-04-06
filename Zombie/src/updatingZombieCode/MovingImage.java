package updatingZombieCode;

import java.awt.Graphics;
import java.awt.Image;

/**
 * @author Andy Jenkins, Dan Cassey
 */
public abstract class MovingImage {

	private Image[][] imageArray;
	private int xPosition;
	private int yPosition;
	/** Used by draw to use the "Alive" frames */
	public static final int ALIVE = 0;
	/** Used by draw to use the "Dead" frames */
	public static final int DEAD = 1;
	private int frame = 0;
	private boolean alive;

	public MovingImage(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		alive = true;
	}

	/**
	 * Get the height of this image
	 * 
	 * @return the height of this image
	 */
	public int getImageHeight() {
		return imageArray[0][0].getHeight(null);
	}

	/**
	 * Get the width of this image
	 * 
	 * @return the width of this image
	 */
	public int getImageWidth() {
		return imageArray[0][0].getWidth(null);
	}

	/**
	 * Get Peel's current x co-ordinate
	 * 
	 * @return Peel's current x co-ordinate
	 */
	public int getX() {
		return this.xPosition;
	}

	/**
	 * Get Peel's current y co-ordinate
	 * 
	 * @return Peel's current y co-ordinate
	 */
	public int getY() {
		return this.yPosition;
	}

	/**
	 * Gets image data from files into image objects
	 * 
	 * @param ref
	 *            an array of strings containing references to the image files
	 */
	public void initializeImages(String[][] ref) {
		// TODO - Change for loop depending on how many movement actions there
		// are.
		imageArray = new Image[ref.length][ref[0].length];
		for (int i = 0; i < imageArray.length; i++) {
			for (int j = 0; j < imageArray[i].length; j++) {
				imageArray[i][j] = ImageLoader.getImage(ref[i][j]);
			}
		}
	}

	/**
	 * Paint this image to the screen
	 * 
	 * @param graphic
	 *            the back buffer to paint this image to
	 * @param frameSet
	 *            the set of frames to use when painting this image
	 * @param x
	 *            the x co-ordinate of the position to paint the image
	 * @param y
	 *            the y co-ordinate of the position to paint the image
	 */
	public void draw(Graphics graphic, int frameSet, int x, int y) {
		switch (frameSet) {
		case ALIVE:
			graphic.drawImage(imageArray[ALIVE][frame], x, y, null);
			break;
		case DEAD:
			graphic.drawImage(imageArray[DEAD][frame], x, y, null);
			break;
		}
	}

	/**
	 * Moves the Peel character a given amount
	 * 
	 * @param delta
	 *            the amount to move
	 */
	public void move(int dX, int dY) {

		if (xPosition < 0) {
			xPosition = 0;
		} else if (xPosition + getImageWidth() > Frame.getInstance().getWidth()) {
			xPosition = Frame.getInstance().getWidth() - getImageWidth();
		} else {
			xPosition = xPosition + dX;
		}

		if (yPosition < 0) {
			yPosition = 0;
		} else if (yPosition + getImageWidth() > Frame.getInstance()
				.getHeight()) {
			yPosition = Frame.getInstance().getHeight() - getImageWidth();
		} else {
			yPosition = yPosition + dY;
		}

	}

	/**
	 * Get Peel's current health status
	 * 
	 * @return true if Peel is alive, false otherwise
	 */
	public boolean isAlive() {
		return alive;
	}
}
