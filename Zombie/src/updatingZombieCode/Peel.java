package updatingZombieCode;

import java.awt.Image;

public class Peel extends Character {
	
	private String[][] roger = { {"/roger_peel.jpg" }, { "/explosion_clip_art_13149.jpg" } };
	private Image[][] rogerImages;
	private ImageLoader loadImages;
	private int xPosition;
	private int yPosition;
	private boolean deadOrAlive;
	private int setFrame;
	
	public Peel(int xMovement, int yMovement, int xPosition, int yPosition) {
		super(xMovement, yMovement);
		initializeImages(roger, rogerImages, loadImages);
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		deadOrAlive = true;
	}
	
	public int getImageHeight()  {
		return loadImages.getHeight();
	}
	
	public int getImageWidth()  {
		return loadImages.getWidth();
	}
	
	public int getXPosition()  {
		return this.xPosition;
	}
	
	public int getYPosition()  {
		return this.yPosition;
	}
	
	public boolean alive()  {
		return deadOrAlive;
	}
	
	public void move(double delta)  {
		xPosition += (delta * getxMovement())/1000;
		if(xPosition < 0) { xPosition = 0; }
		if(xPosition + loadImages.getWidth() > 800) { xPosition = 800 - loadImages.getWidth(); }
		
		yPosition += (delta * getyMovement())/1000; 
		if(yPosition < 0){ yPosition = 0; }
		if(yPosition + loadImages.getHeight() > 600){ yPosition = 600 - loadImages.getHeight(); }
	}	

}
