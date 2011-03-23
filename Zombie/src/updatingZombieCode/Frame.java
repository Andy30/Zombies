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
		
		int FWidth = 800;
		int FHeight = 600;
		
		JFrame frame = new JFrame("2D Game");
		
		frame.setIgnoreRepaint(true);
		frame.setBounds( 0, 0, FWidth, FHeight);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		GameCanvas game = new GameCanvas();
		
		frame.add(game);
		
		frame.setVisible(true);
		
	}
}
