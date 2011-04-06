/**
 * Clip.java
 */

package com.surreycompsoc.zombies;

/**
 * @author chris
 */
public class Clip {

  /**
   * Max num of rounds that the Clip can hold at once. Once set, this can obviously never change - that would be physically
   * impossible.
   */
  private final int maxSize;
  /** The current num of rounds in the Clip. */
  private int       currentSize;

  /**
   * Constructor for objects of class Clip. We assume that the Clip starts fully loaded.
   * 
   * @param maxSize
   *          the num of rounds that the Clip can hold when full
   */
  public Clip(int maxSize) {
    this.maxSize = maxSize;
    this.currentSize = maxSize;
  }

  /**
   * Depletes the number of rounds in the Clip by 1.
   */
  public void fire() {
    this.currentSize--;
  }

  /**
   * Reload the Clip to full capacity. It's up to the caller to reduce the number of extra rounds by the relevant amount - if this
   * is your desired behaviour.
   */
  public void reload() {
    this.currentSize = this.maxSize;
  }
  
  /**
   * Partially reload the Clip by adding the specified number of rounds to it. Would most likely be used if you had little ammo left and couldn't do a complete restock.
   * @param amount the number of rounds to add to the Clip
   */
  public void reload(int amount) {
    int newNum = this.currentSize += amount;
    
    // Can only reload the clip with the specified amount if the Clip can physically hold the new number of rounds.
    if (newNum <= this.maxSize) {
      this.currentSize = newNum;
    }
  }
}
