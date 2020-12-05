public class Bunny{

	
	//private int Lives;
	private int LevelPoints;
	private int TotalPoints;
	private int Level; 
	private int MovesAmount;
	private int xpos;
	private int ypos;
	
	public Bunny() {
		LevelPoints=0;
	//	Lives=0;
		TotalPoints=0;
		Level=1;
		MovesAmount=0;
		xpos = 1;
		ypos = 1;
	}
	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}
	
	public int getLevelPoints()
	{
		return LevelPoints;
	}
	public int getMovesAmount(){return MovesAmount;}
	public void setMovesAmount(int cant){ MovesAmount=cant;}
	public void BunnyAddLevelPoints(int cant)
	{
		LevelPoints= LevelPoints + cant;
	}
	public void BunnyAddTotalPoints(int cant)
	{
		TotalPoints=TotalPoints+cant;
	}

	/*public int getLives() {
		return Lives;
	}

	public void setLives(int lives) {
		Lives = lives;
	}
*/
	public int getTotalPoints() {
		return TotalPoints;
	}

	public void setTotalPoints(int points) {
		TotalPoints = points;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
		LevelPoints=0;
	}

	public void AddMove()
	{
		MovesAmount=MovesAmount+1;
			
	}

	
}
