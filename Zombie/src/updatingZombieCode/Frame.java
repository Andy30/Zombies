package updatingZombieCode;

import javax.swing.JFrame;

/**
 * @author Andy Jenkins
 */
public class Frame {

	/**
	 * The starting point of the game, creates a Swing (*shudder*) window and adds the game canvas to it.
	 * 
	 * @param args the command line input arguments
	 */
	public static void main(String args[])  {
		//A bit of swing.
		
		int frameWidth = 800;
		int frameHeight = 600;
		
		JFrame frame = new JFrame("2D Game");
		
		frame.setIgnoreRepaint(true);
		frame.setBounds( 0, 0, frameWidth, frameHeight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameCanvas game = new GameCanvas(frameWidth, frameHeight);
		
		frame.add(game);
		
		frame.setVisible(true);
		game.addNotify();
		
	}
}
