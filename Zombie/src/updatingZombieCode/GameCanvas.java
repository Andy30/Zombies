package updatingZombieCode;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Andy Jenkins
 */
public class GameCanvas extends Canvas implements Runnable, KeyListener, MouseListener {

	private static final long serialVersionUID = -8863915821741897184L;
	private final int frameWidth;
	private final int frameHeight;
	private final double refreshRate = (1000/60);
	private BufferStrategy buffer;
	private Graphics graphics;
	private Thread t = null;
	private boolean finished = false;
	private int COUNT = 0;
	private Peel peel;
	private ArrayList<Windows> window = new ArrayList<Windows>();
	
	/**
	 * Creates a new canvas object which displays the game
	 * 
	 * Additionally, a Peel and 5 zombies are added to this canvas
	 * 
	 * @param frameWidth the width of this canvas
	 * @param frameHeight the height of this canvas
	 */
	public GameCanvas(int frameWidth, int frameHeight)  {
	  this.frameHeight = frameHeight;
	  this.frameWidth = frameWidth;
	  this.setIgnoreRepaint(true);
    this.setBounds(0, 0, this.frameWidth, this.frameHeight);
    this.setBackground(Color.white);
    this.setVisible(true);  
    this.peel = new Peel(10, 20, 25, 80);
    for(int x = 0; x < 5; x++){
      this.addRandomZombie();
    }
	}
	

	
	/**
	 * Method to be called to begin our game, creates/starts a new thread. (If there is no current game in progress) 
	 */
	public void startGame()  {
		if (t == null)  {
			t = new Thread(this);
			t.start();
		}
	}
	
	private void addRandomZombie(){
		Random ran = new Random();
		int[] hSide = {1, this.frameHeight};
		int[] vSide = {1, this.frameWidth};
		if(ran.nextInt(2) > 0){
			window.add(new Windows(peel, hSide[ran.nextInt(2)], ran.nextInt(frameWidth)));
		} else {
			window.add(new Windows(peel, vSide[ran.nextInt(2)], ran.nextInt(frameHeight)));
		}
	}
	
	/**
	 * Runs the game. (No Menu)
	 */
	public void addNotify()  {
		super.addNotify();
		this.createBufferStrategy(2);
		this.buffer = this.getBufferStrategy();
		this.addKeyListener(this);
		requestFocus();
		startGame();
	}
	
	/**
	 * Where the main game is run
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run()  {	
		while(true){
			
			update();
			render();
			draw();
			
			//Time we're going to give the machine to do it's garbage ext..
			int sleepTime = (int) refreshRate;
			
			try{
				Thread.sleep(sleepTime);
			}
			catch(Exception e){}
			if(COUNT == 5000){
				COUNT = 0;
				this.addRandomZombie();
			}
			COUNT++;
		}
	}
	
	/**
	 * Updates all entities in the canvas for where they should be in the next game frame
	 */
	public void update()  {
		peel.move(200);
		for(int y = 0; y < window.size(); y++)  {
			window.get(y).moveTowards(peel.getXPosition(), peel.getYPosition());
			if(window.get(y).collidesWith() == true){
				this.finished = true;
			}
		}
	}
	
	/**
	 * Draws to the back buffer. Unless draw is called it stays in back buffer and you can't see it.
	 */
	public void render()  {
		//get the back buffer.
		graphics = buffer.getDrawGraphics();
		//set the back buffer to our background colour (white)
		graphics.setColor(Color.white);
		//Turns everything on the screen white, allows us to paint new stuff.
		graphics.fillRect( 0, 0, frameWidth, frameHeight);
		
		// draw everything to the back buffer
		peel.draw(graphics, MovingImage.ALIVE, peel.getXPosition(), 
				peel.getYPosition());
		for(int y = 0; y < window.size(); y++)  {
			window.get(y).draw(graphics, MovingImage.ALIVE, window.get(y).getXPosition(),
					window.get(y).getYPosition());
		}
	}
	
	/**
	 * Draws the contents of the back buffer to the front buffer (the screen)
	 */
	public void draw()  {
		//If the buffer contains what we drew to it, show it.
		if(!buffer.contentsLost())  {
			buffer.show();
		}
		//If graphics content is still there (get new graphics every cycle, get rid of it.
		if (graphics != null)  {
			graphics.dispose();
		}
	}

	/**
	 * Called whenever a key is pressed
	 * 
	 * @param key the code of the key that was pressed
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent e) {
		if (peel.isAlive() == true)  {
			
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_LEFT)  {
				peel.setXMovement(-1);
			}
			if (key == KeyEvent.VK_RIGHT)  {
				peel.setXMovement(1);
			}
			if (key == KeyEvent.VK_UP)  {
				peel.setYMovement(-1);
			}
			if (key == KeyEvent.VK_DOWN)  {
				peel.setYMovement(1);
			}
			if(key == KeyEvent.VK_SPACE){
				this.COUNT = 5000;
			}
		}
	}

	/**
	 * Called whenever a key is released
	 * 
	 * @param key the code of the key that was pressed
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
		if (peel.isAlive() == true)  {
			
			int key = e.getKeyCode();
			
			if (key == KeyEvent.VK_LEFT)  {
				peel.setXMovement(0);
			}
			if (key == KeyEvent.VK_RIGHT)  {
				peel.setYMovement(0);
			}
			if (key == KeyEvent.VK_UP)  {
				peel.setYMovement(0);
			}
			if (key == KeyEvent.VK_DOWN)  {
				peel.setYMovement(0);
			}
		}		
	}

	/**
	 * Called repeatedly while a key is typed (pressed and released)
	 * 
	 * @param key the key that was typed
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Called whenever a button on the mouse is pressed and released
	 * 
	 * @param event the event that caused this method call
	 */
	public void mouseClicked(MouseEvent event) {
		// TODO Auto-generated method stub
	}

	/**
	 * Called when the mouse enters the canvas
	 * 
	 * @param event the event that caused this method call
	 *
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Called when the mouse exits the canvas
	 * 
   * @param event the event that caused this method call
   * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Called when a mouse button is pressed
	 * 
   * @param event the event that caused this method call
	 *
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
	}

	/**
	 * Called when a mouse button is released
	 * 
   * @param event the event that caused this method call
	 *
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
		
	}
}
