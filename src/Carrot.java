public class Carrot extends GameObject {
	public Carrot(int xpos, int ypos) {
		super(xpos, ypos);
	}
	public int RandomDirec()
	{
		int random = (int) (Math.random() * 3 + 1);// random de 1,2,3,4.
		return random;
	}
}
