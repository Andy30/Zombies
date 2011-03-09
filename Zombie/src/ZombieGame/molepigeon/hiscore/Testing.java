/**
 * Testing.java
 */

package ZombieGame.molepigeon.hiscore;
/**
 * @author Michael
 */
public class Testing {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Hiscore score = new Hiscore();             //New scoring system.
    System.out.println("Made a Kill. Combo is now "+score.onKill());        //Makes a kill.
    System.out.println("Score is now "+score.getScore());
    System.out.println("Kill/Death ratio is now "+score.getKDR());
    System.out.println(" ");
    System.out.println("Made a Kill. Combo is now "+score.onKill());        //Makes a kill.
    System.out.println("Score is now "+score.getScore());
    System.out.println("Kill/Death ratio is now "+score.getKDR());
    System.out.println(" ");
    System.out.println("Made a Kill. Combo is now "+score.onKill());        //Makes a kill.
    System.out.println("Score is now "+score.getScore());
    System.out.println("Kill/Death ratio is now "+score.getKDR());
    System.out.println(" ");
    score.onDeath();                           //You died.
    System.out.println("Died. Combo is now "+score.getCombo());
    System.out.println(" ");
    System.out.println("Made a Kill. Combo is now "+score.onKill());        //Makes a kill.
    System.out.println("Score is now "+score.getScore());
    System.out.println("Kill/Death ratio is now "+score.getKDR());
    System.out.println(" ");
    System.out.println("Made a Kill. Combo is now "+score.onKill());        //Makes a kill.
    System.out.println("Score is now "+score.getScore());
    System.out.println("Kill/Death ratio is now "+score.getKDR());
    System.out.println(" ");
    System.out.println("Waiting for 5 seconds...");        //Waits.
    waiting(5000);
    System.out.println(" ");
    System.out.println("Made a Kill. Combo is now "+score.onKill());        //Makes a kill.
    System.out.println("Score is now "+score.getScore());
    System.out.println("Kill/Death ratio is now "+score.getKDR());
    System.out.println(" ");
    System.out.println("Test completed. Score should be 24.");
	  
//	double test = 2.5;
//	System.out.println(test*2);
    
  }
  
  public static void waiting (int n){
    long t0, t1;
    t0 =  System.currentTimeMillis();
    do{
        t1 = System.currentTimeMillis();
    }
    while (t1 - t0 < n);
}
}
