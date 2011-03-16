package updatingZombieCode;

import java.awt.Image;

/**
 * Class describing a generic Character that takes part in the game.
 * 
 * @author Andy30, Chris
 */
public abstract class Character extends MovingImage {

  /** Rate of change of movement in the x direction. */
  private int xMovementRate;
  /** Rate of change of movement in the y direction. */
  private int yMovementRate;
  /** X coordinate of top left pixel of image. */
  private int xPosition;
  /** Y coordinate of top left pixel of image. */
  private int yPosition;
  /** Array of names of the Character's image files on the file system. */
  private String[][] fileNames;
  /** The Character's specified images, loaded into memory. */
  private Image[][] loadedImages;
  /** Reference to the ImageLoader, which takes a bunch of filenames as Strings and reads in their respective Images to an array */
  private ImageLoader loadImages;
  
  /**
   * Constructor for a generic Character.
   * @param fileNames 
   * 
   * @param xPosition
   *          X coordinate of top left pixel of image
   * @param yPosition
   *          Y coordinate of top left pixel of image
   * @param xMovementRate
   * @param yMovementRate
   */
  public Character(String[][] fileNames, int xPosition, int yPosition, int xMovementRate, int yMovementRate) {
    this.fileNames = fileNames;
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    this.xMovementRate = xMovementRate;
    this.yMovementRate = yMovementRate;
  }

  /**
   * @return the current rate of change of movement in the x direction
   */
  // Class for group power ups. I.e. Here I could increase all members speed.

  public int getXMovementRate() {
    return xMovementRate;
  }

  /**
   * @param xMovementRate
   *          the new rate of change of movement in the x direction
   */
  public void setXMovementRate(int xMovementRate) {
    this.xMovementRate = xMovementRate;
  }

  /**
   * @return the current rate of change of movement in the y direction
   */
  public int getYMovementRate() {
    return yMovementRate;
  }

  /**
   * @param yMovementRate
   *          the new rate of change of movement in the y direction
   */
  public void setYMovementRate(int yMovementRate) {
    this.yMovementRate = xMovementRate;
  }
  
  /**
   * @return the current x-coordinate of the top-leftmost pixel of the Character's image
   */
  public int getXPosition()  {
    return this.xPosition;
  }
  
  /**
   * 
   * @return the current y-coordinate of the top-leftmost pixel of the Character's image
   */
  public int getYPosition()  {
    return this.yPosition;
  }
  
  /**
   * @return height of an arbitrary image in the collection of images that was loaded in
   */
  public int getImageHeight()  {
    return loadImages.getHeight();
  }
  
  /**
   * 
   * @return width of an arbitrary image in the collection of images that was loaded in
   */
  public int getImageWidth()  {
    return loadImages.getWidth();
  }

  /**
   * Move the Character.
   * 
   * @param delta
   *          ???
   */
  public void move(double delta) {
    xPosition += (delta * this.xMovementRate) / 1000;
    if (xPosition < 0) {
      xPosition = 0;
    }
    if (xPosition + loadImages.getWidth() > 800) {
      xPosition = 800 - loadImages.getWidth();
    }

    yPosition += (delta * this.yMovementRate) / 1000;
    if (yPosition < 0) {
      yPosition = 0;
    }
    if (yPosition + loadImages.getHeight() > 600) {
      yPosition = 600 - loadImages.getHeight();
    }
  }
  
  /**
   * Load up images from disk.
   */
  protected void loadInImages() {
    initializeImages(fileNames, loadedImages, loadImages);
  }
}
