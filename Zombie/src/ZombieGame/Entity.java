package ZombieGame;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

	//Need to know where the entity is.
	protected double x;
	protected double y;
	//Entity Image
	protected Sprite sprite;
	//Speed of the entity (Rate of change)
	protected double Dy;
	protected double Dx;
	//Two rectangles for this entity and other entities.
	private Rectangle thisEntity = new Rectangle();
	private Rectangle otherEntity = new Rectangle();
	
	
	/**
	 * Dan's Javadoc comment of awesomeness
	 * @param ref
	 * @param x
	 * @param y
	 */
	public Entity(String ref, int x, int y)  {
		this.sprite = ImageLoader.get().getSprite(ref);
		this.x = x;
		this.y = y;
	}
	
	public void move(long delta)  {
		x += (delta * Dx)/1000;
		if(x < 0){ x = 0; }
		if(x + sprite.getWidth() > 800){ x = 800-sprite.getWidth(); }
		y += (delta * Dy)/1000; 
		if(y < 0){ y = 0; }
		if(y + sprite.getHeight() > 600){ y = 600-sprite.getHeight(); }
	}
	
	public void setHorizontalMovement(double dx)  {
		this.Dx = dx;
	}
	
	public void setVerticalMovement(double dy)  {
		this.Dy = dy;
	}
	
	public void setImage(String ref)  {
		this.sprite = ImageLoader.get().getSprite(ref);
	}
	public double getHorizontalMovement()  {
		return Dx;
	}
	
	public double getVerticalMovement()  {
		return Dy;
	}
	public void Draw(Graphics graphic)  {
		this.sprite.Draw(graphic,(int) x,(int) y);
	}
	
	public boolean collidesWith(Entity e)  {
		this.thisEntity.setBounds((int) x, (int) y, sprite.getWidth(), sprite.getHeight());
		this.otherEntity.setBounds((int) e.x, (int) e.y, e.sprite.getWidth(), e.sprite.getHeight());	
		return thisEntity.intersects(otherEntity);
	}
}
