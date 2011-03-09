package ZombieGame;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImageLoader {

	//Only want 1 image loader class so it doesn't take up memory
	
	private static ImageLoader single = new ImageLoader();
	
	private HashMap<String, Sprite> images = new HashMap<String, Sprite>();
	
	public Sprite getSprite(String ref)  {
		
		//If the image reference is not equal to null, cast it to a sprite.
		//Should be using a try and catch.
		if(images.get(ref) != null)  {
			return (Sprite)  images.get(ref);
		}
		
		BufferedImage sourceImage = null;
		
		try  {
			sourceImage = ImageIO.read(new File (ref));
		} catch (IOException e)  {
			System.out.print(e);
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		
		Image image = gc.createCompatibleImage(sourceImage.getWidth(), sourceImage.getHeight(), Transparency.BITMASK);
		image.getGraphics().drawImage(sourceImage, 0, 0, null);
		Sprite sprite = new Sprite(image);
		images.put(ref, sprite);
		
		return sprite;
	}
	
	public static ImageLoader get()  {
		return single;
	}
}
