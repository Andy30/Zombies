package updatingZombieCode;

import java.awt.Image;
import java.awt.Rectangle;

public class Windows extends Enemy {

	private String[][] windows = { {"windows_logo.jpg" } };
	private Image[][] windowsImages = new Image[1][1];
	private ImageLoader loadImages = new ImageLoader();
	private int xWindowPosition;
	private int yWindowPosition;
	private int xCharPosition;
	private int yCharPosition;
	private boolean deadOrAlive;
	private Rectangle enemyWindow = new Rectangle();
	private Rectangle characterRect = new Rectangle();
	private Peel peel;
	
	public Windows(Peel peel, int xCharPosition, int yCharPosition, int xWindowPosition, int yWindowPosition) {
		super(peel, xCharPosition, yCharPosition);
		this.windowsImages = initializeImages(windows, windowsImages, loadImages);
		this.xWindowPosition = xWindowPosition;
		this.yWindowPosition = yWindowPosition;
		this.xCharPosition = xCharPosition;
		this.yCharPosition = yCharPosition;
		deadOrAlive = true;
		this.peel = peel; 
	}
	
	public int getImageHeight()  {
		return windowsImages[0][0].getHeight(null);
	}
	
	public int getImageWidth()  {
		return windowsImages[0][0].getWidth(null);
	}
	
	public int getXPosition()  {
		return this.xWindowPosition;
	}
	
	public int getYPosition()  {
		return this.yWindowPosition;
	}
	
	public boolean alive()  {
		return deadOrAlive;
	}
	
	public Image getImageFrame(int direction, int frameNumber)  {
		return this.windowsImages[direction][frameNumber];
	}
	
	public boolean collidesWith()  {
		characterRect.setBounds(xCharPosition, yCharPosition, peel.getImageWidth(), peel.getImageHeight());
		enemyWindow.setBounds(xWindowPosition, yWindowPosition, peel.getImageWidth(), peel.getImageHeight());
		return characterRect.intersects(enemyWindow);
	}

}
