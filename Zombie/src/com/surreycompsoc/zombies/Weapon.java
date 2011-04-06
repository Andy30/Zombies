/**
 * Weapon.java
 */

package com.surreycompsoc.zombies;

import java.awt.Image;
import java.util.Random;

/**
 * Generic container class which "contains" a bunch of behaviour that specifies how a Weapon works. E.g. Magazine, Damage etc.
 * 
 * @author Christopher Kilding
 */
public class Weapon {

  /** The Magazine containing rounds that can be fired off. */
  private Magazine  clip;

  /** The extra rounds a Weapon has which aren't loaded into the Magazine at the time. */
  private int   stockRounds;

  /**
   * The base damage done per round. This changes slightly every time the weapon is fired with a random number to simulate the
   * varying degrees of accuracy without the need to model individual rounds with bounding boxes. This is the maximum amount of
   * damage a standard round can do if it were to land a critical hit on the target.
   */
  private int   baseDamagePerRound;

  /**
   * Simplistic Image of the Weapon. This won't change based on the angle - no 3D simulation here - just a plain 2D image that is
   * rotated with the player.
   */
  private Image img;

  /**
   * Constructor for objects of class Weapon.
   * 
   * @param clip
   *          the conceptual model of the Magazine for this Weapon
   * @param stockRounds
   *          the number of extra rounds that the Weapon will start with
   * @param baseDamagePerRound
   *          the maximum amount of damage done by a standard round
   * @param img
   *          single Image of the weapon, viewed top-down
   */
  public Weapon(Magazine clip, int stockRounds, int baseDamagePerRound, Image img) {
    this.clip = clip;
    this.stockRounds = stockRounds;
    this.baseDamagePerRound = baseDamagePerRound;
    this.img = img;
  }

  /**
   * Fires the Weapon, which basically updates its various components.
   * 
   * @return the amount of damage done by the round that was fired
   */
  public double fire() {
    // Attempt to deplete 1 round from the Magazine
    boolean couldFire = this.clip.fire();
    // The variable containing how much damage the round will do.
    // (If there's no rounds left, the damage defaults to zero.)
    double damageDealt = 0;

    // If there was ammo in the Magazine, fire() would have returned true. Continue with the firing behaviour.
    // If not, the Magazine was empty, so stop now.
    if (couldFire == true) {
      // Generate random number to simulate the loss in damage effectiveness that would be caused by a round that hit a non-critical
      // location / bounced off armour instead of landing a critical hit.
      double lossInEffectiveness = new Random().nextDouble();

      damageDealt = this.baseDamagePerRound - lossInEffectiveness;
    }

    return damageDealt;
  }

  /**
   * @return the Weapon's Image
   */
  public Image getImage() {
    return this.img;
  }
}
