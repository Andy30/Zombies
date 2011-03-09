package ZombieGame;

public class ZombieEntity extends Entity {
	
	private boolean exists = false;

	public ZombieEntity(String ref, int x, int y)  {
		super(ref, x, y);
		exists = true;
	}

	public boolean Exists()  {
		return exists;
	}
	
	public int getX()  {
		return (int) x;
	}
	
	public int getY()  {
		return (int) y;
	}
}
