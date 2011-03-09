package ZombieGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GameCanvas extends Canvas implements Runnable, KeyListener, MouseListener {

	//Width of the Canvas.
	final int FWidth = 800;
	//Height of the Canvas.
	final int FHeight = 600;
	//Used for timing.
	final public long period = 10;
	//Means rendering code can be run along side game loop. 
	//Paint things to the BufferStrategy so that they can then be flushed onto the frame.
	public BufferStrategy buffer;
	//Graphics will call paint to draw the screen.
	public Graphics graphics;
	//Main thread used for runnable interfaces.
	private Thread t;
	
	private boolean finished = false;
	
	int COUNT = 0;
	
	public ZombieEntity roger;
	public ArrayList<Zombie> zombies;
	
	//Constructor - Builds 
	public GameCanvas()  {
		//allows use of custom painting.
		this.setIgnoreRepaint(true);
		//Start in corner and be FWidth by FHeight diameter.
		this.setBounds(0, 0, FWidth, FHeight);
		//obvious
		this.setBackground(Color.white);
		//Calls our canvas for a repaint to show the new white canvas.
		this.setVisible(true);
		
		roger = new ZombieEntity("roger_peel.jpg", 300, 200);
		
		zombies = new ArrayList<Zombie>();
		for(int x = 0; x < 5; x++){
			this.addRandomZombie();
		}
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
			zombies.add(new Zombie("windows_logo_small.jpg", ran.nextInt(this.FWidth), hSide[ran.nextInt(2)]));
		}else{
			zombies.add(new Zombie("windows_logo_small.jpg", vSide[ran.nextInt(2)], ran.nextInt(FHeight)));
		}
	}
	
	//Runs the game. (No Menu)
	public void addNotify()  {
		//Anything within the frame (currently white) is made visible.
		super.addNotify();
		//How many buffers we want for the render performance. (2 is ok)
		this.createBufferStrategy(2);
		//Tell our buffer to use what we just said.
		this.buffer = this.getBufferStrategy();
		this.addKeyListener(this);
		//Sends a request to make our frame the focused window.
		requestFocus();
		//Starts the thread (Game Begins).
		startGame();
	}
	
	//Where the main game is run
	public void run()  {
		
		while(!finished){
			//Game begins at current system time.
			//long beginTime = System.currentTimeMillis();
			
			Update();
			Render();
			Draw();
			
			//Time taken to update render and draw.
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
		System.exit(1);
	}
	
	//All entities that require logic - do it.
	public void Update()  {
		roger.move(200);
		
		Iterator<Zombie> iter = zombies.iterator();
		
		while(iter.hasNext()){
			Zombie z = iter.next();
			z.moveTowards(roger.getX(), roger.getY());
			if(z.collidesWith(roger)){
				roger.setImage("explosion_clip_art_13149.jpg");
				this.finished = true;
			}else{
				roger.setImage("roger_peel.jpg");
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
		
		//Paint pretty pictures.
		roger.Draw(graphics);
		
		Iterator<Zombie> iter = zombies.iterator();
		
		while(iter.hasNext()){
			iter.next().Draw(graphics);
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
		if (roger.Exists())  {
			if (key.getKeyCode() == KeyEvent.VK_LEFT)  {
				roger.setHorizontalMovement(-1);
			}
			if (key.getKeyCode() == KeyEvent.VK_RIGHT)  {
				roger.setHorizontalMovement(1);
			}
			if (key.getKeyCode() == KeyEvent.VK_UP)  {
				roger.setVerticalMovement(-1);
			}
			if (key.getKeyCode() == KeyEvent.VK_DOWN)  {
				roger.setVerticalMovement(1);
			}
			if(key.getKeyCode() == KeyEvent.VK_SPACE){
				this.COUNT = 5000;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {
		if (roger.Exists())  {
			if (key.getKeyCode() == KeyEvent.VK_LEFT)  {
				roger.setHorizontalMovement(0);
			}
			if (key.getKeyCode() == KeyEvent.VK_RIGHT)  {
				roger.setHorizontalMovement(0);
			}
			if (key.getKeyCode() == KeyEvent.VK_UP)  {
				roger.setVerticalMovement(0);
			}
			if (key.getKeyCode() == KeyEvent.VK_DOWN)  {
				roger.setVerticalMovement(0);
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
