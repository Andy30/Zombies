/**
 * Weapon.java
 */

package com.surreycompsoc.zombies;

import java.util.Random;

/**
 * Generic container class which "contains" a bunch of behaviour that specifies how a Weapon works. E.g. Clip, Damage etc.
 * 
 * @author Christopher Kilding
 */
public class Weapon {

  /** The Clip containing rounds that can be fired off. */
  private Clip clip;

  /** The extra rounds a Weapon has which aren't loaded into the Clip at the time. */
  private int  stockRounds;

  /**
   * The base damage done per round. This changes slightly every time the weapon is fired with a random number to simulate the
   * varying degrees of accuracy without the need to model individual rounds with bounding boxes. This is the maximum amount of
   * damage a standard round can do if it were to land a critical hit on the target.
   */
  private int  baseDamagePerRound;

  /**
   * Constructor for objects of class Weapon.
   * 
   * @param clip
   *          the conceptual model of the Clip for this Weapon
   * @param stockRounds
   *          the number of extra rounds that the Weapon will start with
   * @param baseDamagePerRound
   *          the maximum amount of damage done by a standard round
   */
  public Weapon(Clip clip, int stockRounds, int baseDamagePerRound) {
    this.clip = clip;
    this.stockRounds = stockRounds;
    this.baseDamagePerRound = baseDamagePerRound;
  }

  /**
   * Fires the Weapon, which basically updates its various components.
   * 
   * @return the amount of damage done by the round that was fired
   */
  public double fire() {
    // Attempt to deplete 1 round from the Clip
    boolean couldFire = this.clip.fire();
    // The variable containing how much damage the round will do.
    // (If there's no rounds left, the damage defaults to zero.)
    double damageDealt = 0;

    // If there was ammo in the Clip, fire() would have returned true. Continue with the firing behaviour.
    // If not, the Clip was empty, so stop now.
    if (couldFire == true) {
      // Generate random number to simulate the loss in damage effectiveness that would be caused by a round that hit a non-critical
      // location / bounced off armour instead of landing a critical hit.
      double lossInEffectiveness = new Random().nextDouble();

      damageDealt = this.baseDamagePerRound - lossInEffectiveness;
    }

    return damageDealt;
  }
}
