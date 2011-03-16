package updatingZombieCode;

public class Zombie extends Entity {

	private boolean exists = false;

	public Zombie(String ref, int x, int y)  {
		super(ref, x, y);
		exists = true;
	}

	public boolean Exists()  {
		return exists;
	}
	
	public void moveTowards(double checkX, double checkY)  {
		this.x += (checkX - this.x)/10000;
		this.y += (checkY - this.y)/10000;
	//	double distance = Math.sqrt((Math.pow((this.x - checkX), 2)) + (Math.pow((this.y - checkY), 2)));
		
	}
}
