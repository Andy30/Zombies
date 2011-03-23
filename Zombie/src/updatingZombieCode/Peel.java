package updatingZombieCode;

import java.awt.Image;

public class Peel extends Character {
	
	private String[][] roger = { {"roger_peel.jpg"}};
	private Image[][] rogerImages = new Image[4][4];
	private ImageLoader loadImages = new ImageLoader();
	private int xPosition;
	private int yPosition;
	private boolean alive;
	
	public Peel(int xMovement, int yMovement, int xPosition, int yPosition) {
		super(xMovement, yMovement);
		this.rogerImages = initializeImages(roger, rogerImages, loadImages);
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		alive = true;
	}
	
	public int getImageHeight()  {
		return rogerImages[0][0].getHeight(null);
	}
	
	public int getImageWidth()  {
		return rogerImages[0][0].getWidth(null);
	}
	
	public int getXPosition()  {
		return this.xPosition;
	}
	
	public int getYPosition()  {
		return this.yPosition;
	}
	
	public boolean isAlive()  {
		return alive;
	}
	
	public Image getImageFrame(int direction, int frameNumber)  {
		return this.rogerImages[direction][frameNumber];
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
