package updatingZombieCode;

/**
 * @author Andy Jenkins, Dan Cassey
 */
public class Peel extends Character {

  private String[][]  roger      = {{ "roger_peel.jpg" }, {"explosion_clip_art_13149.jpg"} };
  private int         xPosition;
  private int         yPosition;
  private boolean     alive;

  /**
   * Create a new Dr Peel character
   * 
   * @param xMovement
   *          the speed at which Peel can move horizontally
   * @param yMovement
   *          the speed at which Peel can move vertically
   * @param xPosition
   *          the x co-ordinate of Peel's starting position
   * @param yPosition
   *          the y co-ordinate of Peel's starting position
   */
  public Peel(int xMovement, int yMovement, int xPosition, int yPosition) {
    super(xMovement, yMovement);
    this.initializeImages(roger);
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    alive = true;
  }

  /**
   * Get Peel's current x co-ordinate
   * 
   * @return Peel's current x co-ordinate
   */
  public int getXPosition() {
    return this.xPosition;
  }

  /**
   * Get Peel's current y co-ordinate
   * 
   * @return Peel's current y co-ordinate
   */
  public int getYPosition() {
    return this.yPosition;
  }

  /**
   * Get Peel's current health status
   * 
   * @return true if Peel is alive, false otherwise
   */
  public boolean isAlive() {
    return alive;
  }

  /**
   * Moves the Peel character a given amount
   * 
   * @param delta
   *          the amount to move
   */
  public void move(double delta) {
    xPosition += (delta * getXMovement()) / 1000;
    if (xPosition < 0) {
      xPosition = 0;
    }
    if (xPosition + getImageWidth() > 800) {
      xPosition = 800 - getImageWidth();
    }

    yPosition += (delta * getYMovement()) / 1000;
    if (yPosition < 0) {
      yPosition = 0;
    }
    if (yPosition + getImageHeight() > 600) {
      yPosition = 600 - getImageHeight();
    }
  }

}
