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
   * Partially reload the Clip by adding the specified number of rounds to it. Would most likely be used if you had little ammo left
   * and couldn't do a complete restock. If you attempt to pass in some massive amount of extra rounds that would overstuff the
   * Clip, or if you attempt to pass in zero or a negative number of rounds, the method fails and returns false.
   * 
   * @param amount
   *          the number of rounds to add to the Clip
   * @return whether the reload operation could be completed
   */
  public boolean reload(int amount) {
    boolean success = false;

    // Can't reload with fewer than 1 round - that would be pointless.
    if (amount > 0) {
      int newNum = this.currentSize += amount;

      // Can only reload the clip with the specified amount if the Clip can physically hold the new number of rounds.
      if (newNum <= this.maxSize) {
        this.currentSize = newNum;
        success = true;
      }
    }
    return success;
  }
}
