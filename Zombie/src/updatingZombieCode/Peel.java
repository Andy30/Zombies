package updatingZombieCode;

/**
 * @author Andy Jenkins, Dan Cassey
 */
public class Peel extends Character {

  private String[][]  roger      = {{ "roger_peel.jpg" }, {"explosion_clip_art_13149.jpg"}};

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
  public Peel(int xPosition, int yPosition) {
    super(xPosition, yPosition);
    this.initializeImages(roger);
  }

}
