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

	/**
	 * 
	 */
	private static final long serialVersionUID = -8863915821741897184L;
	final int FWidth = 800;
	final int FHeight = 600;
	final private int period = 10;
	private BufferStrategy buffer;
	private Graphics graphics;
	private Thread t;
	private boolean finished = false;
	private int COUNT = 0;
	private Peel peel;
	private ArrayList<Windows> window = new ArrayList<Windows>();
	
	//Constructor - Builds 
	public GameCanvas()  {
	  this.setIgnoreRepaint(true);
    this.setBounds(0, 0, FWidth, FHeight);
    this.setBackground(Color.white);
    this.setVisible(true);  
    this.peel = new Peel(10, 20, 25, 80);
    for(int x = 0; x < 5; x++){
      this.addRandomZombie();
    }
	}
	

	public void initialize()  {
		
	}
	
	//Method to be called to begin our game, creates/starts a new thread. (If there is no current game in sessions)
	public void startGame()  {
		if (t == null)  {
			t = new Thread(this);
			t.start();
		}
	}
	
	private void addRandomZombie(){
		Random ran = new Random();
		int[] hSide = {1, this.FHeight};
		int[] vSide = {1, this.FWidth};
		if(ran.nextInt(2) > 0){
			window.add(new Windows(peel, peel.getXPosition(), peel.getYPosition(), 
					hSide[ran.nextInt(2)], ran.nextInt(FWidth)));
		} else {
			window.add(new Windows(peel, peel.getXPosition(), peel.getYPosition(), 
					vSide[ran.nextInt(2)], ran.nextInt(FHeight)));
		}
	}
	
	//Runs the game. (No Menu)
	public void addNotify()  {
		super.addNotify();
		this.createBufferStrategy(2);
		this.buffer = this.getBufferStrategy();
		this.addKeyListener(this);
		requestFocus();
		startGame();
	}
	
	//Where the main game is run
	public void run()  {	
		while(!finished){
			
			Update();
			Render();
			Draw();
			
			long timeTaken = System.currentTimeMillis();
			//Time we're going to give the machine to do it's garbage ext..
			long sleepTime = period - timeTaken;
			
			try{
				t.sleep(sleepTime);
			}
			catch(Exception e){}
			if(COUNT == 5000){
				COUNT = 0;
				this.addRandomZombie();
			}
			COUNT++;
		}
	}
	
	//All entities that require logic - do it.
	public void Update()  {
		peel.move(200);
		for(int y = 0; y < window.size(); y++)  {
			window.get(y).moveTowards(peel.getXPosition(), peel.getYPosition());
			if(window.get(y).collidesWith() == true){
				this.finished = true;
			}
		}
	}
	
	//Draws to the back buffer. Unless draw is called it stays in back buffer and you can't see it.
	public void Render()  {
		//draw to back buffer.
		graphics = buffer.getDrawGraphics();
		//set the back buffer to our background colour (white)
		graphics.setColor(Color.white);
		//Turns everything on the screen white, allows us to paint new stuff.
		graphics.fillRect( 0, 0, FWidth, FHeight);
		
		peel.draw(graphics, peel.getImageFrame(0,0), peel.getXPosition(), 
				peel.getYPosition());
		for(int y = 0; y < window.size(); y++)  {
			window.get(y).draw(graphics, window.get(y).getImageFrame(0, 0), window.get(y).getXPosition(),
					window.get(y).getYPosition());
		}
	}
	
	//Draws stuff to screen.
	public void Draw()  {
		//If the buffer contains what we drew to it, show it.
		if(!buffer.contentsLost())  {
			buffer.show();
		}
		//If graphics content is still there (get new graphics every cycle, get rid of it.
		if (graphics != null)  {
			graphics.dispose();
		}
	}

	@Override
	public void keyPressed(KeyEvent key) {
		if (peel.isAlive() == true)  {
			if (key.getKeyCode() == KeyEvent.VK_LEFT)  {
				peel.setxMovement(-1);
			}
			if (key.getKeyCode() == KeyEvent.VK_RIGHT)  {
				peel.setxMovement(1);
			}
			if (key.getKeyCode() == KeyEvent.VK_UP)  {
				peel.setyMovement(-1);
			}
			if (key.getKeyCode() == KeyEvent.VK_DOWN)  {
				peel.setyMovement(1);
			}
			if(key.getKeyCode() == KeyEvent.VK_SPACE){
				this.COUNT = 5000;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		if (peel.isAlive() == true)  {
			if (key.getKeyCode() == KeyEvent.VK_LEFT)  {
				peel.setxMovement(0);
			}
			if (key.getKeyCode() == KeyEvent.VK_RIGHT)  {
				peel.setxMovement(0);
			}
			if (key.getKeyCode() == KeyEvent.VK_UP)  {
				peel.setyMovement(0);
			}
			if (key.getKeyCode() == KeyEvent.VK_DOWN)  {
				peel.setyMovement(0);
			}
		}		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
