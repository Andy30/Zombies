package updatingZombieCode;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Andy Jenkins, Dan Cassey
 */
public class ImageLoader {
	
  /**
	 * Loads an image in from a specified file path and returns an image object for this image
	 * 
	 * @param ref the file path of the image
	 * @return a new image object for this image
	 */
	public static Image getImage(String ref)  {
		BufferedImage sourceImage = null;
		try  {
			sourceImage = ImageIO.read(new File (ref));
		} catch (IOException e)  {
			System.out.print(e);
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		Image image = gc.createCompatibleImage(sourceImage.getWidth(), sourceImage.getHeight(), Transparency.BITMASK);
		image.getGraphics().drawImage(sourceImage, 0, 0, null);
		
		return image;
	}
}
