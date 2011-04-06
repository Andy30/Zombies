/**
 * Clip.java
 */

package com.surreycompsoc.zombies;


/**
 * @author chris
 */
public class Clip {

  /** Max num of rounds that the Clip can hold at once. */
  private int size;
  
  /**
   * Constructor for objects of class Clip.
   * 
   * @param size set the num of rounds that the Clip can hold, when full
   */
  public Clip(int size) {
    this.size = size;
  }
  
  /**
   * Depletes the number of rounds in the Clip by 1.
   */
  public void fire() {
    this.size--;
  }
}
