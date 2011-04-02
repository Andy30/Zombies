package updatingZombieCode;

import java.awt.Rectangle;

/**
 * @author Andy Jenkins
 */
public class Windows extends Enemy {

  private String[][] windows       = { { "windows_logo.jpg" }};
  private int        xWindowPosition;
  private int        yWindowPosition;
  private boolean    alive;
  private Rectangle  enemyWindow   = new Rectangle();
  private Rectangle  characterRect = new Rectangle();
  private Peel       peel;

  /**
   * Create a new windows character
   * 
   * @param peel
   *          the peel to chase
   * @param xWindowPosition
   *          the x co-ordinate of this windows logo
   * @param yWindowPosition
   *          the y co-ordinate of this windows logo
   */
  public Windows(Peel peel, int xWindowPosition, int yWindowPosition) {
    super(peel);
    this.initializeImages(windows);
    this.xWindowPosition = xWindowPosition;
    this.yWindowPosition = yWindowPosition;
    alive = true;
    this.peel = peel;
  }

  /**
   * Gets this windows logo's current x co-ordinate
   * 
   * @return this windows logo's current x co-ordinate
   */
  public int getXPosition() {
    return this.xWindowPosition;
  }

  /**
   * Gets this windows logo's current y co-ordinate
   * 
   * @return this windows logo's current y co-ordinate
   */
  public int getYPosition() {
    return this.yWindowPosition;
  }

  /**
   * Gets whether this windows logo is dead or alive
   * 
   * @return true if alive, false otherwise
   */
  public boolean isAlive() {
    return alive;
  }

  /**
   * Check to see if this windows logo collides with the character it's chasing
   * 
   * @return true if the characters collide, false otherwise
   */
  public boolean collidesWith() {
    characterRect.setBounds(peel.getXPosition(), peel.getYPosition(), peel.getImageWidth(), peel.getImageHeight());
    enemyWindow.setBounds(xWindowPosition, yWindowPosition, peel.getImageWidth(), peel.getImageHeight());
    return characterRect.intersects(enemyWindow);
  }

}
