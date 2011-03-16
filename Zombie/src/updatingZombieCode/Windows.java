package updatingZombieCode;

import java.awt.Image;
import java.awt.Rectangle;

public class Windows extends Enemy {

	private String[][] windows = { {"/windows_logo.jpg" } };
	private Image[][] windowsImages;
	private ImageLoader loadImages;
	private int xWindowPosition;
	private int yWindowPosition;
	private int xCharPosition;
	private int yCharPosition;
	private boolean deadOrAlive;
	private Rectangle enemyWindow;
	private Rectangle characterRect;
	private Peel peel;
	
	public Windows(Peel peel, int xCharPosition, int yCharPosition, int xWindowPosition, int yWindowPosition) {
		super(peel, xCharPosition, yCharPosition);
		initializeImages(windows, windowsImages, loadImages);
		this.xWindowPosition = xWindowPosition;
		this.yWindowPosition = yWindowPosition;
		this.xCharPosition = xCharPosition;
		this.yCharPosition = yCharPosition;
		deadOrAlive = true;
		this.peel = peel; 
	}
	
	public int getImageHeight()  {
		return loadImages.getHeight();
	}
	
	public int getImageWidth()  {
		return loadImages.getWidth();
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
	
	public boolean collidesWith()  {
		characterRect.setBounds(xCharPosition, yCharPosition, peel.getImageWidth(), peel.getImageHeight());
		enemyWindow.setBounds(xWindowPosition, yWindowPosition, peel.getImageWidth(), peel.getImageHeight());
		return characterRect.intersects(enemyWindow);
	}

}
