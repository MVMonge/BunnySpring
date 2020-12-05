import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchiveClass{
	private int level;
	private int totalpoints;
	
	public ArchiveClass()throws IOException 
	{
		level=1;
		totalpoints=0;
		
		File f = new File("src/Resource/savedgame.txt");
		
		if(!f.exists())
		{
			FileWriter fw = new FileWriter(f);
			BufferedWriter bb = new BufferedWriter(fw);
			bb.write(level);
			bb.write(totalpoints);
			bb.close();
			fw.close();
		}
		else
		{
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String[] j;
	
			String line=br.readLine();
			j=line.split(",");
			level= Integer.parseInt(j[0]);
			totalpoints= Integer.parseInt(j[1]);
			br.close();
			fr.close();
		}
	}
	
	public int getLevel() {return level;}
	public void setLevel(int level) {this.level = level;}

	public int getTotalpoints() {return totalpoints;}
	public void setTotalpoints(int totalpoints) {this.totalpoints = totalpoints;}


	public void  SaveGame(int BunnyLevel, int BunnyPoints ) throws IOException
	{
		File f = new File("src/Resource/savedgame.txt");
		
		File tempFile = new File("myTempFile.txt");
		if(!tempFile.exists())
		{
			FileWriter fw = new FileWriter(f);
	/*		BufferedWriter bb = new BufferedWriter(fw);
			bb.write(level);
			bb.write(totalpoints);
			bb.close();*/
			fw.close();
		}

		BufferedReader reader = new BufferedReader(new FileReader(f));
		BufferedWriter bwtemp = new BufferedWriter(new FileWriter(tempFile));

		//if my arch already has something on it
		String linespresent=reader.readLine();
		if(linespresent!= null) 
		{
		    bwtemp.write(level);
		    bwtemp.write(',');
		    bwtemp.write(totalpoints);
		}
		bwtemp.close(); 
		reader.close(); 
		tempFile.renameTo(f);
		f.delete();
	}
}

