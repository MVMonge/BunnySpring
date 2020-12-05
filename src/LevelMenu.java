
public class LevelMenu {

	private int[][] matrix;
	private int colvalues;
	private int filvalues;
	private int carrotamount;
	private int foxamount;
	private int maxmoves;
	public LevelMenu(int level)
	{
		colvalues=17;
		filvalues = 13;
		carrotamount=4;
		foxamount=0;
		maxmoves=0;
		matrix = new int[filvalues][colvalues];
		switch(level)
		{
			case 1: 
				Level1();
				break;
			case 2: 
				Level2();
				break;
			case 3: 
				Level3();
				break;
			case 4: 
				Level4();
				break;
			case 5: 
				Level5();
				break;
			case 6: 
				Level6();
				break;
			case 7 :
				Level7();
				break;
			case 8 :
				Level8();
				break;
			case 9 :
				Level9();
				break;
			case 10 :
				Level10();
				break;
			default: break;
		}
	}
	
	public int getFoxAmount()
	{
		return foxamount;
	}
	public int getCarrotAmount()
	{
		return carrotamount;
	}
	public int[][] getMatrix()
	{
		return matrix;
	}	
		public int getMaxmoves() {
		return maxmoves;
	}
	public void setMaxmoves(int maxmoves) {
		this.maxmoves = maxmoves;
	}
	
	private void Imprimir()
	{
		for(int i=0; i<filvalues;i++)
		{
			for(int t=0; t<colvalues;t++)
			{
				System.out.print(matrix[i][t]+",");
				if(t==colvalues-1)
				{
					System.out.println("\n");
				}
				
			}
		}
		System.out.println("----------------------------------------------------------");
	}
	
	public int getBunnyColPos()
	{
		for(int i=0; i<filvalues;i++)
		{
			for(int t=0; t<colvalues;t++)
			{
				if(matrix[i][t]==3)
				{	
					return t;
				}
			}
		}
		return 1;
	}
	public int getBunnyFilPos()
	{
		for(int i=0; i<filvalues;i++)
		{
			for(int t=0; t<colvalues;t++)
			{
				if(matrix[i][t]==3)
				{	
					return i;
				}
			}
		}
		return 1;
	}
	
	private void Border()
	{
		for(int i=0; i<filvalues;i++)
		{
			for(int t=0; t<colvalues;t++)
			{
				if(i==0 || i==(filvalues-1))
				{	matrix[i][t]=1;}
				else if (t==0 || t==(colvalues-1))
				{
					matrix[i][t]=1;
				}
				else
				{
					matrix[i][t]=0;
				}
			}
		}
	}
	
	private void Level1()
	{
		maxmoves=8;
		Border();
		matrix[1][6]=3;
		//Imprimir para ver
		Imprimir();
	}

	private void Level2()
	{
		maxmoves=8;
		Border();
		matrix[5][8]=3;
		//------------------
		matrix[3][3]=1;
		matrix[4][3]=1;
		matrix[5][3]=1;
		//------------------
		matrix[3][13]=1;
		matrix[4][13]=1;
		matrix[5][13]=1;
		//------------------
		matrix[7][6]=1;
		matrix[8][6]=1;
		matrix[9][6]=1;
		//------------------
		matrix[7][10]=1;
		matrix[8][10]=1;
		matrix[9][10]=1;
		//Imprimir para ver
		Imprimir();
	}
	
	private void Level3()
	{
		maxmoves=7;
		Border();
		matrix[6][8]=3;
		//--------------
		matrix[6][4]=1;
		matrix[6][5]=1;
		matrix[6][6]=1;
		//---------------
		matrix[6][10]=1;
		matrix[6][11]=1;
		matrix[6][12]=1;
		//---------------
		matrix[2][12]=1;
		matrix[2][13]=1;
		matrix[3][13]=1;
		//---------------
		matrix[9][3]=1;
		matrix[10][3]=1;
		matrix[10][4]=1;
		
		Imprimir();
	}
	
	private void Level4()
	{
		maxmoves=7;
		foxamount=3;
		Border();
		matrix[3][8]=3;
		//--------------
		matrix[2][8]=1;
		//--------------
		matrix[3][4]=1;
		matrix[3][12]=1;
		//--------------
		matrix[4][8]=1;
		matrix[5][8]=1;
		//-------------
		matrix[6][2]=1;
		matrix[6][4]=4;
		matrix[6][7]=1;
		matrix[6][8]=4;
		matrix[6][9]=1;
		matrix[6][12]=4;
		matrix[6][14]=1;
		//-------------
		matrix[7][8]=1;
		matrix[8][8]=1;
		//-------------
		matrix[9][4]=1;
		matrix[9][12]=1;
		//-------------
		matrix[10][8]=1;
		//matrix[8][6]=3;
		Imprimir();
	}

	private void Level5()
	{
		maxmoves=6;
		foxamount=4;
		carrotamount=6;
		Border();
		matrix[6][8]=3;
		//--------------
		//-----------------
		matrix[2][3]=4;
		matrix[2][13]=4;
		matrix[10][3]=4;
		matrix[10][13]=4;
		//-----------------
		matrix[4][5]=1;
		matrix[4][7]=1;
		matrix[4][8]=1;
		matrix[4][9]=1;
		matrix[4][11]=1;
		//-----------------
		matrix[5][5]=1;
		matrix[6][5]=1;
		matrix[7][5]=1;
		matrix[5][11]=1;
		matrix[6][11]=1;
		matrix[7][11]=1;
		//-----------------
		matrix[8][5]=1;
		matrix[8][7]=1;
		matrix[8][8]=1;
		matrix[8][9]=1;
		matrix[8][11]=1;
		//Imprimir para ver
		Imprimir();
	}
	
	private void Level6()
	{
		maxmoves=6;
		foxamount=4;
		Border();
		matrix[6][8]=3;
		//----------
		matrix[2][2]=1;
		matrix[2][3]=1;
		matrix[2][4]=1;
		matrix[2][5]=1;
		
		matrix[2][7]=1;
		matrix[2][8]=1;
		matrix[2][9]=1;
		
		matrix[2][11]=1;
		matrix[2][12]=1;
		matrix[2][13]=1;
		matrix[2][14]=1;
		//----------
		matrix[5][5]=1;
		matrix[5][6]=1;
		matrix[5][7]=1;
		
		matrix[5][9]=1;
		matrix[5][10]=1;
		matrix[5][11]=1;
		//----------
		matrix[6][1]=1;
		matrix[6][2]=1;
		matrix[6][3]=1;
		
		matrix[6][13]=1;
		matrix[6][14]=1;
		matrix[6][15]=1;
		//----------
		matrix[7][5]=1;
		matrix[7][6]=1;
		matrix[7][7]=1;
		
		matrix[7][9]=1;
		matrix[7][10]=1;
		matrix[7][11]=1;
		//----------
		matrix[10][2]=1;
		matrix[10][3]=1;
		matrix[10][4]=1;
		matrix[10][5]=1;
		
		matrix[10][7]=1;
		matrix[10][8]=1;
		matrix[10][9]=1;
		
		matrix[10][11]=1;
		matrix[10][12]=1;
		matrix[10][13]=1;
		matrix[10][14]=1;
		//----------
		matrix[3][8]=4;
		matrix[6][6]=4;
		matrix[6][10]=4;
		matrix[9][8]=4;
		
		//Imprimir para ver
		Imprimir();
	}
	
	private void Level7()
	{
		carrotamount=4;
		maxmoves=5;
		Border();
		matrix[6][8]=3;
		//-----------------
		matrix[1][1]=1;
		matrix[1][4]=1;
		matrix[1][12]=1;
		matrix[1][15]=1;
		//-----------------
		matrix[2][2]=1;
		matrix[2][5]=1;
		matrix[2][11]=1;
		matrix[2][14]=1;
		//-----------------
		matrix[3][3]=1;
		matrix[3][6]=1;
		matrix[3][10]=1;
		matrix[3][13]=1;
		//-----------------
		matrix[4][4]=1;
		matrix[4][7]=1;
		matrix[4][9]=1;
		matrix[4][12]=1;
		//-----------------
		matrix[5][5]=1;
		matrix[5][11]=1;
		//-----------------
		matrix[7][5]=1;
		matrix[7][11]=1;
		//-----------------
		matrix[8][4]=1;
		matrix[8][7]=1;
		matrix[8][9]=1;
		matrix[8][12]=1;
		//-----------------
		matrix[9][3]=1;
		matrix[9][6]=1;
		matrix[9][10]=1;
		matrix[9][13]=1;
		//-----------------
		matrix[10][2]=1;
		matrix[10][5]=1;
		matrix[10][11]=1;
		matrix[10][14]=1;
		//-----------------
		matrix[11][1]=1;
		matrix[11][4]=1;
		matrix[11][12]=1;
		matrix[11][15]=1;
		//-----------------
		matrix[2][8]=4;
		matrix[6][3]=4;
		matrix[6][13]=4;
		matrix[10][8]=4;
		
		
		foxamount=4;
		//Imprimir para ver
		Imprimir();
	}

	private void Level8()
	{
		Border();
		matrix[3][8]=3;
		//--------------
		foxamount=4;
		carrotamount=6;
		maxmoves=4;
		matrix[1][8]=4;
		matrix[6][4]=4;
		matrix[6][12]=4;
		matrix[11][8]=4;
		//-----------------
		matrix[2][1]=1;
		matrix[2][3]=1;
		matrix[2][5]=1;
		matrix[2][7]=1;
		matrix[2][9]=1;
		matrix[2][11]=1;
		matrix[2][13]=1;
		matrix[2][15]=1;
		//-----------------
		matrix[6][1]=1;
		matrix[6][3]=1;
		matrix[6][5]=1;
		matrix[6][7]=1;
		matrix[6][9]=1;
		matrix[6][11]=1;
		matrix[6][13]=1;
		matrix[6][15]=1;
		//-----------------
		matrix[10][1]=1;
		matrix[10][3]=1;
		matrix[10][5]=1;
		matrix[10][7]=1;
		matrix[10][9]=1;
		matrix[10][11]=1;
		matrix[10][13]=1;
		matrix[10][15]=1;
		//-----------------
		matrix[4][2]=1;
		matrix[4][4]=1;
		matrix[4][6]=1;
		matrix[4][8]=1;
		matrix[4][10]=1;
		matrix[4][12]=1;
		matrix[4][14]=1;
		//-----------------
		matrix[8][2]=1;
		matrix[8][4]=1;
		matrix[8][6]=1;
		matrix[8][8]=1;
		matrix[8][10]=1;
		matrix[8][12]=1;
		matrix[8][14]=1;
		//-----------------
		
	}

	private void Level9()
	{
		Border();
		matrix[6][8]=3;
		//--------------;
		foxamount=4;
		carrotamount=6;
		maxmoves=4;
		matrix[1][8]=4;
		matrix[6][1]=4;
		matrix[6][15]=4;
		matrix[11][8]=4;
		//------------.
		matrix[2][1]=1;
		matrix[2][3]=1;
		matrix[2][5]=1;
		matrix[2][7]=1;
		matrix[2][9]=1;
		matrix[2][11]=1;
		matrix[2][13]=1;
		matrix[2][15]=1;
		//----------------
		matrix[10][1]=1;
		matrix[10][3]=1;
		matrix[10][5]=1;
		matrix[10][7]=1;
		matrix[10][9]=1;
		matrix[10][11]=1;
		matrix[10][13]=1;
		matrix[10][15]=1;
		//-----------------
		matrix[3][2]=1;
		matrix[3][6]=1;
		matrix[3][10]=1;
		matrix[3][14]=1;
		
		matrix[9][2]=1;
		matrix[9][6]=1;
		matrix[9][10]=1;
		matrix[9][14]=1;
		//-----------------
		matrix[5][1]=1;
		matrix[5][3]=1;
		matrix[5][6]=1;
		matrix[5][7]=1;
		matrix[5][9]=1;
		matrix[5][11]=1;
		matrix[5][14]=1;
		matrix[5][15]=1;
		//----------------
		matrix[7][2]=1;
		matrix[7][3]=1;
		matrix[7][5]=1;
		matrix[7][7]=1;
		matrix[7][10]=1;
		matrix[7][11]=1;
		matrix[7][13]=1;
		matrix[7][15]=1;
		//----------------
		matrix[6][4]=1;
		matrix[6][9]=1;
		matrix[6][12]=1;
		//----------------
		
		foxamount=4;
		carrotamount=6;
		maxmoves=3;
		
	}

	private void Level10()
	{
		Border();
		matrix[1][6]=3;
		//--------------	
		
		matrix[2][14]=4;
		matrix[5][1]=4;
		matrix[10][12]=4;
		//---------------
		matrix[1][4]=1;
		matrix[1][12]=1;
		matrix[1][13]=1;
		//-------------
		matrix[2][3]=1;
		matrix[2][7]=1;
		matrix[2][8]=1;
		matrix[2][9]=1;
		matrix[2][10]=1;
		matrix[2][13]=1;
		//-------------
		matrix[3][3]=1;
		matrix[3][6]=1;
		//-------------
		matrix[4][5]=1;
		matrix[4][11]=1;
		matrix[4][14]=1;
		//-------------
		matrix[5][5]=1;
		matrix[5][11]=1;
		matrix[5][14]=1;
		//-------------
		matrix[6][3]=1;
		matrix[6][6]=1;
		matrix[6][7]=1;
		matrix[6][12]=1;
		//-------------
		matrix[7][3]=1;
		matrix[7][8]=1;
		matrix[7][13]=1;
		//-------------
		matrix[8][2]=1;
		matrix[8][3]=1;
		matrix[8][4]=1;
		matrix[8][5]=1;
		matrix[8][6]=1;
		
		matrix[8][9]=1;
		
		matrix[8][14]=1;
		//---------------
		matrix[9][4]=1;
		matrix[9][7]=1;
		matrix[9][10]=1;
		matrix[9][14]=1;
		//---------------
		matrix[10][5]=1;
		matrix[11][5]=1;
		//---------------
		foxamount=3;
		carrotamount=6;
		maxmoves=3;
		
	}
	


	
 }
