package updatingZombieCode;

/**
 * @author Andy Jenkins, Dan Cassey
 */
public abstract class Character extends MovingImage {

  private int xMovement;
  private int yMovement;

  /**
   * Creates a new character
   * 
   * @param xMovement
   *          the speed at which this character can move horizontally
   * @param yMovement
   *          the speed at which this character can move vertically
   */
  public Character(int xMovement, int yMovement) {
    this.xMovement = xMovement;
    this.yMovement = yMovement;
  }

  /**
   * Gets the current horizontal speed of this character
   * 
   * @return the current horizontal speed of this character
   */
  public int getXMovement() {
    return xMovement;
  }

  /**
   * Sets the horizontal speed for this character
   * 
   * @param xMovement
   *          the new horizontal speed for this character
   */
  public void setXMovement(int xMovement) {
    this.xMovement = xMovement;
  }

  /**
   * Gets the current vertical speed of this character
   * 
   * @return the current vertical speed of this character
   */
  public int getYMovement() {
    return yMovement;
  }

  /**
   * Sets vertical speed for this character
   * 
   * @param yMovement
   *          the new vertical speed for this character
   */
  public void setYMovement(int yMovement) {
    this.yMovement = yMovement;
  }

}
