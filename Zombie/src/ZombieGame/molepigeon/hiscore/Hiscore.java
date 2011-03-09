package ZombieGame.molepigeon.hiscore;

/**
 * Library to store and manipulate the player's score in zombie survival.
 * 
 * @author Molepigeon
 * @version 1.21
 * @since 02 Mar 2011
 * 
 * Release Notes
 * - Version 1.0
 * - - Started project. Score uses kill combo, reset after death.
 * - Version 1.1
 * - - Added time-based combo kills
 * - Version 1.2
 * - - Added kill/death ratio to score calculation
 * - - - This means if you die, you get a permanent reduction to your score bonus!
 * - - Fixed bug where level was reset on death, not combo.
 * - - Set score variable to double (was int) - now decimal scores are possible.
 * - Version 1.21
 * - - Fixed bug where combo was not incremented properly.
 * - - Fixed bug where multiplier was not taken into account properly.
 * - - Renamed package to represent Surrey CompSoc as well as Molepigeon.
 * - - Fixed bug where a kill/death ratio of 2.5 and combo of 2 would cause 
 *     a score addition of 4, not 5.
 * - - All variables are now doubles, not int.
 */
public class Hiscore {
	//Fields storing necessary data
	private double currentScore;  	//Stores the current score
	private double multiplier;    		//Stores the multiplier
	private double combo;         		//Stores the kill combo value
	private long lastKillTime; 		//Stores the time of the last kill.
	private double kills;         		//Stores the kill count.
	private double deaths;        		//Stores the death count.
	private double kdr;				//Stores the KDR.			
	// End Fields
	
	/**
	 * Constructor initialises the values to their defaults.
	 */
	public Hiscore(){
		currentScore = 0;
		multiplier = 1;
		combo = 0;
		lastKillTime = System.currentTimeMillis();
		deaths = 0;
		kills = 0;
	}
	
	///////Start KDR manipulation. ///////
	public void recalcKDR(){
		kdr = kills / (deaths+1);
	}
	
	public double getKDR(){
		return this.kdr;
	}
	///////End KDR manipulation ///////
	
	///////Start score manipulation.///////
	
	/**
	 * Getter for score. Useful for score display on UI?
	 */
	public double getScore(){
		return this.currentScore;
	}
	
	/**
	 * Setter for score. In case you want to hack the game. Comment on release.
	 * @param score
	 */
	public void setScore(int score){
		this.currentScore = score;
	}
	
	/**
	 * Incrementer for score. Combines combo and kill/death ratio,
	 * and increments the score accordingly.
	 * @return The combo (value of score addition)
	 */
	public double incScore(){
		this.recalcKDR();
	  this.currentScore += (combo * kdr * multiplier);
		return combo;
	}
	
	///////End score manipulation.///////
	
	
	///////Start multiplier manipulation.///////
	
	/**
	 * Gets the multiplier. Could be useful as a level indicator.
	 */
	public double getMulti(){
		return this.multiplier;
	}
	
	/**
	 * Sets the multiplier.
	 * @param multi
	 */
	public void setMulti(int multi){
		this.multiplier = multi;
	}
	
	/**
	 * Increments the multiplier. Adds one.
	 */
	public void incMulti(){
		this.multiplier += 1;
	}
	
	///////End multiplier manipulation.///////
	
	
	///////Start combo manipulation.///////
	
	/**
	 * Gets the combo. Useful for UI.
	 */
	public double getCombo(){
		return this.combo;
	}
	
	/**
	 * Increments the combo. Remember to call this method BEFORE incrementing the score,
	 * else the first kill won't be worth anything!
	 */
	public void incCombo(){
		this.combo += 1;
	}
	
	
	/**
	 * Resets the combo to zero.
	 */
	public void resetCombo(){
	  this.combo = 0;
	}
	
	
	
	///////End combo manipulation.///////
	
	
	///////Start quick methods.///////
	
/// Code following is depreciated and clashes with new code.
/// DO NOT UNCOMMENT ///
//	/**
//	 * On Kill. Increments combo then adds to score.
//	 */
//	public void onKill(){
//		this.incCombo();
//		this.incScore();
//	}
/// End depreciated code.
	
	/**
	 * On Kill. Checks timeout (currently 5 seconds) and increments score
	 * accordingly.
	 * 
	 * @return The amount score has been increased by.
	 */
	public double onKill(){
	  kills++;
	  if (lastKillTime > System.currentTimeMillis() - 5){
	    this.incCombo();
	    this.incScore();
	    lastKillTime = System.currentTimeMillis();
	    return this.combo;
	  } else {
	    this.resetCombo();
	    this.incCombo();
	    this.incScore();
	    lastKillTime = System.currentTimeMillis();
	    return this.combo;
	  }
	}
	
	/**
	 * On Death. Sets combo to zero.
	 */
	public void onDeath(){
		this.resetCombo();
		deaths++;
	}
	
	/**
	 * On level up. Adds one to the multiplier.
	 */
	public void onLevelUp(){
		this.incMulti();
	}
}
