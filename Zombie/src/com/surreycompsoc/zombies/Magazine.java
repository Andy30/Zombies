/**
 * Magazine.java
 */

package com.surreycompsoc.zombies;

/**
 * State class modelling a Weapon's Magazine, which holds some rounds.
 * 
 * @author Christopher Kilding
 */
public class Magazine {

  /**
   * Max num of rounds that the Magazine can hold at once. Once set, this can obviously never change - that would be physically
   * impossible.
   */
  private final int maxSize;
  /** The current num of rounds in the Magazine. */
  private int       currentSize;

  /**
   * Constructor for objects of class Magazine. We assume that the Magazine starts fully loaded.
   * 
   * @param maxSize
   *          the num of rounds that the Magazine can hold when full
   */
  public Magazine(int maxSize) {
    this.maxSize = maxSize;
    this.currentSize = maxSize;
  }

  /**
   * Depletes the number of rounds in the Magazine by 1.
   * @return whether firing was successful (i.e. whether there were still enough rounds in the Magazine)
   */
  public boolean fire() {
    boolean success = false;
    
    if (this.currentSize > 0) {
      this.currentSize--;
      success = true;
    }
    
    return success;
  }

  /**
   * Reload the Magazine to full capacity. It's up to the caller to reduce the number of extra rounds by the relevant amount - if this
   * is your desired behaviour.
   */
  public void reload() {
    this.currentSize = this.maxSize;
  }

  /**
   * Partially reload the Magazine by adding the specified number of rounds to it. Would most likely be used if you had little ammo left
   * and couldn't do a complete restock. If you attempt to pass in some massive amount of extra rounds that would overstuff the
   * Magazine, or if you attempt to pass in zero or a negative number of rounds, the method fails and returns false.
   * 
   * @param amount
   *          the number of rounds to add to the Magazine
   * @return whether the reload operation could be completed
   */
  public boolean reload(int amount) {
    boolean success = false;

    // Can't reload with fewer than 1 round - that would be pointless.
    if (amount > 0) {
      int newNum = this.currentSize += amount;

      // Can only reload the Magazine with the specified amount if it can physically hold the new number of rounds.
      if (newNum <= this.maxSize) {
        this.currentSize = newNum;
        success = true;
      }
    }
    return success;
  }
  
  /**
   * @return current number of rounds in the Magazine
   */
  public int getCurrentNumRounds() {
    return this.currentSize;
  }
  
  /**
   * @return the maximum number of rounds that this Magazine can hold
   */
  public int getMaxSize() {
    return this.maxSize;
  }
}
