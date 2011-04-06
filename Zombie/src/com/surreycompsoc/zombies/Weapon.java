/**
 * Weapon.java
 */

package com.surreycompsoc.zombies;


/**
 * Generic container class which "contains" a bunch of behaviour that specifies how a Weapon works. E.g. Clip, Damage etc.
 * 
 * @author Christopher Kilding
 */
public class Weapon {

  /** The Clip containing rounds that can be fired off. */
  private Clip clip;
  
  /** The extra rounds a Weapon has which aren't loaded into the Clip at the time. */
  private int stockRounds;
  
}
