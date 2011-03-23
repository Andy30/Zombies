package updatingZombieCode;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	private BufferedImage sourceImage;
	
	public ImageLoader()  {
		
	}
	
	public int getHeight()  {
		return sourceImage.getHeight();
	}
	
	public int getWidth()  {
		return sourceImage.getWidth();
	}
	
	public Image getImage(String ref)  {
		
		try  {
			sourceImage = ImageIO.read(new File (ref));
		} catch (IOException e)  {
			System.out.print(e);
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		Image image = gc.createCompatibleImage(this.sourceImage.getWidth(), this.sourceImage.getHeight(), Transparency.BITMASK);
		image.getGraphics().drawImage(this.sourceImage, 0, 0, null);
		
		return image;
	}
}
