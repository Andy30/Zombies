package updatingZombieCode;

import javax.swing.JFrame;

/**
 * @author Andy Jenkins
 */
public class Frame extends JFrame {

	private static Frame instance = null;
	
	public Frame() {
		super("2D Game");
	}

	public static Frame getInstance(){
		return instance;
	}
	
	/**
	 * The starting point of the game, creates a Swing (*shudder*) window and
	 * adds the game canvas to it.
	 * 
	 * @param args
	 *            the command line input arguments
	 */
	public static void main(String args[]) {
		// A bit of swing.

		int frameWidth = 800;
		int frameHeight = 600;

		instance = new Frame();

		instance.setIgnoreRepaint(true);
		instance.setBounds(0, 0, frameWidth, frameHeight);
		instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GameCanvas game = new GameCanvas(frameWidth, frameHeight);

		instance.add(game);

		instance.setVisible(true);
		game.addNotify();

	}
}
