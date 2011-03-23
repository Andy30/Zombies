package updatingZombieCode;

import java.awt.Graphics;
import java.awt.Image;

/**
 * @author Andy Jenkins, Dan Cassey
 */
public abstract class MovingImage {

  // The array of still frames for this animated image
  private Image[][] imageArray;
  
  /** Used by draw to use the "Alive" frames */
  public static final int ALIVE = 0;
  /** Used by draw to use the "Dead" frames */
  public static final int DEAD = 1;
  
  private int frame = 0;
  
  /**
   * Gets image data from files into image objects
   * 
   * @param ref
   *          an array of strings containing references to the image files
   */
  public void initializeImages(String[][] ref) {
    // TODO - Change for loop depending on how many movement actions there are.
    imageArray = new Image[ref.length][ref[0].length];
    for (int z = 0; z < imageArray.length; z++) {
      for (int t = 0; t < imageArray[0].length; t++) {
        imageArray[z][t] = ImageLoader.getImage(ref[z][t]);
      }
    }
  }

  /**
   * Paint this image to the screen
   * 
   * @param graphic the buffer to paint this image to
   * @param frameSet the set of frames to use when painting this image
   * @param x the x co-ordinate of the position to paint the image
   * @param y the y co-ordinate of the position to paint the image
   */
  public void draw(Graphics graphic, int frameSet, int x, int y) {
    switch (frameSet){
      case ALIVE:
        graphic.drawImage(imageArray[ALIVE][frame], x, y, null);
        break;
      case DEAD:
        graphic.drawImage(imageArray[DEAD][frame], x, y, null);
        break;
    }
  }
  
  /**
   * Get the height of this image
   * 
   * @return the height of this image
   */
  public int getImageHeight(){
    return imageArray[0][0].getHeight(null);
  }
  
  /**
   * Get the width of this image
   * 
   * @return the width of this image
   */
  public int getImageWidth(){
    return imageArray[0][0].getWidth(null);
  }
}
