package updatingZombieCode;

import java.awt.Graphics;
import java.awt.Image;


public abstract class MovingImage  {

	public MovingImage()  {
	}
	
	public Image[][] initializeImages(String[][] ref, Image[][] imageArray, ImageLoader images)  {	 
		//TODO - Change for loop depending on how many movement actions there are.
		for (int z = 0; z < 4; z++)  {
		for (int t = 0; t < 4; t++)  {
		imageArray[z][t] = images.getImage(ref[z][t]);
		}
		}
		return imageArray;
	}
	
	public void draw(Graphics graphic, Image image, int x, int y)  {
		graphic.drawImage(image, x, y, null);
	}
	
	public Image getImage(Image[][] images, int z, int t)  {
		return images[z][t];
	}
}
