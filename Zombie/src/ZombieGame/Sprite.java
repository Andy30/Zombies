package ZombieGame;

import java.awt.Graphics;
import java.awt.Image;

public class Sprite {
	
	private Image image1;
	
	public Sprite(Image image1)  {
		this.image1 = image1;
	}
	
	public int getWidth()  {
		return image1.getWidth(null);
	}
	
	public int getHeight()  {
		return image1.getHeight(null);
	}
	
	public void Draw(Graphics graphic, int x, int y)  {
		graphic.drawImage(image1, x, y, null);
	}

}
