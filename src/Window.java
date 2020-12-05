import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Variables
	private ImageIcon image0 = new ImageIcon("src/Resource/grass6464.png");
	private ImageIcon image1 = new ImageIcon("src/Resource/bush6464.png");
	private ImageIcon image2 = new ImageIcon("src/Resource/carrot6464.png");
	private ImageIcon image3 = new ImageIcon("src/Resource/bunnyfront6464.png");
	private ImageIcon image4 = new ImageIcon("src/Resource/fox6464.png");
	
	private Bunny bunny;
	ArrayList<Carrot> carrots;
	ArrayList<Fox> foxes;
	LevelMenu CurrentLevel;
	
	private int filvalues;
	private int colvalues;
	private JLabel labelmatrix[][];
	private int[][] matrix;
	private JFrame ventana = new JFrame("Bunny Spring");
	private FlowLayout fl = new FlowLayout(FlowLayout.LEADING,0,0);	
	
	//Constructor
	public Window(Bunny b)
	{
		bunny=b;
		
		CurrentLevel= new LevelMenu(bunny.getLevel());
		matrix=CurrentLevel.getMatrix();
		
		bunny.setYpos(CurrentLevel.getBunnyColPos());
		bunny.setXpos(CurrentLevel.getBunnyFilPos());
		
		carrots = new ArrayList<Carrot>();
		foxes = new ArrayList<Fox>();
		colvalues=17;
		filvalues=13;
		
		ventana.setLayout(fl);
		ventana.setSize(64*colvalues, 64*filvalues+22);//22 por el window header
		ventana.setResizable(false);
		ventana.setLocation(500, 200);
		labelmatrix= new JLabel[filvalues][colvalues];
		
		InitDisplay();	
		
		CarrotGenerator(CurrentLevel.getCarrotAmount());
		FoxGenerator(CurrentLevel.getFoxAmount());
		AddKeyListeners();
		
		ventana.setVisible(true);
	
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//KeyListeners
	private void AddKeyListeners()
	{
		
		ventana.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
				char letra = e.getKeyChar();
				int c = CurrentLevel.getMaxmoves();
				if(letra == 'd')
				{
					pressD(bunny.getXpos(), bunny.getYpos());
					CarrotUpdate();
					FoxUpdate();
					bunny.AddMove();
					if(c>0)
					{
						if(bunny.getMovesAmount()==c)
						{
							ExtraFox();
							bunny.setMovesAmount(0);
						}
					}
					
				}
				else if(letra == 's')
				{
					pressS(bunny.getXpos(), bunny.getYpos());
					CarrotUpdate();
					FoxUpdate();
					bunny.AddMove();
					if(c>0)
					{
						if(bunny.getMovesAmount()==c)
						{
							ExtraFox();
							bunny.setMovesAmount(0);
						}
					}
				}
				else if(letra == 'a')
				{
					pressA(bunny.getXpos(), bunny.getYpos());
					CarrotUpdate();
					FoxUpdate();
					bunny.AddMove();
					if(c>0)
					{
						if(bunny.getMovesAmount()==c)
						{
							ExtraFox();
							bunny.setMovesAmount(0);
						}
					}
				}
				else if(letra == 'w')
				{
					pressW(bunny.getXpos(), bunny.getYpos());
					CarrotUpdate();
					FoxUpdate();
					bunny.AddMove();
					if(c>0)
					{
						if(bunny.getMovesAmount()==c)
						{
							ExtraFox();
							bunny.setMovesAmount(0);
						}
					}
				}
				else if(e.getKeyCode()==KeyEvent.VK_SPACE)
				{
					PauseSheet ps = new PauseSheet(bunny,ventana);
				}
			}
		});
		
		
	}
	//Display Init
	private void InitDisplay()
	{
		int value;
		for(int i=0; i<filvalues ; i++)
		{
			for(int p=0;p<colvalues;p++)
			{
				JLabel label = new JLabel();
				label.setSize(64, 64);
				value = matrix[i][p];//(i,p);
				switch(value)
				{
					case 0:
						label.setIcon(image0);
						break;
					case 1:
						label.setIcon(image1);
						break;
					case 2:
						label.setIcon(image2);
						break;
					case 3:
						label.setIcon(image3);
						break;
					case 4:
						label.setIcon(image4);
						break;
				}
				labelmatrix[i][p]=label;
				ventana.getContentPane().add(labelmatrix[i][p]);
			}
		}
	}

	//Movement Control Bunny
	private void pressS(int x, int y)//Abajo
	{
		if(matrix[x+1][y]==0)//grass
		{
			labelmatrix[x+1][y].setIcon(image3);
			matrix[x+1][y]=3;
			labelmatrix[x][y].setIcon(image0);
			matrix[x][y]= 0;
			bunny.setXpos(x+1);
		}
		else if(matrix[x+1][y]==2)//carrot
		{
			bunny.BunnyAddLevelPoints(1);
			CarrotKiller(x+1,y);
			
			System.out.println(bunny.getLevelPoints());
			
			labelmatrix[x+1][y].setIcon(image3);
			matrix[x+1][y]=3;
			labelmatrix[x][y].setIcon(image0);
			matrix[x][y]= 0;
			bunny.setXpos(x+1);
			
		}
		else if(matrix[x+1][y]==1)//bush
		{
		}
		else if(matrix[x+1][y]==4)//fox
		{
			labelmatrix[x][y].setIcon(image0);
			LevelLost();
		}
	}
	private void pressD(int x, int y)//Derecha
	{
		if(matrix[x][y+1]==0)//grass
		{
			labelmatrix[x][y+1].setIcon(image3);
			labelmatrix[x][y].setIcon(image0);
			matrix[x][y+1]=3;
			matrix[x][y]=0;
			bunny.setYpos(y+1);
		}
		else if(matrix[x][y+1]==2)//carrot
		{
			bunny.BunnyAddLevelPoints(1);
			CarrotKiller(x, y+1);
			
			System.out.println(bunny.getLevelPoints());
			
			labelmatrix[x][y+1].setIcon(image3);
			labelmatrix[x][y].setIcon(image0);
			matrix[x][y+1]=3;
			matrix[x][y]=0;
			bunny.setYpos(y+1);
			
		}
		else if(matrix[x][y+1]==1)
		{
			
		}
		else if(matrix[x][y+1]==4)//fox
		{
			labelmatrix[x][y].setIcon(image0);
			LevelLost();
		}
	}
	private void pressW(int x, int y)//Arriba
	{
		if(matrix[x-1][y]==0)//grass
		{
			labelmatrix[x-1][y].setIcon(image3);
			labelmatrix[x][y].setIcon(image0);
			matrix[x-1][y]=3;
			matrix[x][y]=0;
			bunny.setXpos(x-1);
		}
		else if(matrix[x-1][y]==2)//carrot
		{
			bunny.BunnyAddLevelPoints(1);
			CarrotKiller(x-1, y);
			
			System.out.println(bunny.getLevelPoints());
			
			labelmatrix[x-1][y].setIcon(image3);
			labelmatrix[x][y].setIcon(image0);
			matrix[x-1][y]=3;
			matrix[x][y]=0;
			bunny.setXpos(x-1);
		}
		else if(matrix[x-1][y]==1)//bush
		{
			
		}
		else if(matrix[x-1][y]==4)//fox
		{
			labelmatrix[x][y].setIcon(image0);
			LevelLost();
		}
	}
	private void pressA(int x, int y)//Izquierda
	{
		if(matrix[x][y-1]==0)//grass
		{
			labelmatrix[x][y-1].setIcon(image3);
			labelmatrix[x][y].setIcon(image0);
			matrix[x][y-1]=3;
			matrix[x][y]=0;
			bunny.setYpos(y-1);
		}
		else if(matrix[x][y-1]==2)//carrot
		{
			bunny.BunnyAddLevelPoints(1);
			CarrotKiller(x, y-1);
			
			System.out.println(bunny.getLevelPoints());
			
			labelmatrix[x][y-1].setIcon(image3);
			labelmatrix[x][y].setIcon(image0);
			matrix[x][y-1]=3;
			matrix[x][y]=0;
			bunny.setYpos(y-1);
		}
		else if(matrix[x][y-1]==1)
		{
			
		}
		else if(matrix[x][y-1]==4)//fox
		{
			labelmatrix[x][y].setIcon(image0);
			LevelLost();
		}
	}
	
	//Carrot Generator
	private void CarrotGenerator(int cant)
	{
		int fila=0;
		int col=0;
		//crea las zanahorias en un lugar
		for(int i=0; i<cant; i++)
		{
			fila=(int)(Math.random()*11+1);
			col=(int)(Math.random()*15+1);
			
			if((fila==bunny.getXpos() && col==bunny.getYpos())||(matrix[fila][col]==4)||(matrix[fila][col]==1))//si hay un bunny, un fox o un bush
			{
				i--;
			}
			else
			{
				matrix[fila][col]=2;
				labelmatrix[fila][col].setIcon(image2);
				carrots.add(new Carrot(fila,col));
			}
			
		}
	}

	//Carrot Killer
	private void CarrotKiller(int x, int y)
	{
		if(bunny.getLevelPoints()==4)
		{
			carrots.clear();
			ventana.dispose();
			/*try {
				super.finalize();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			bunny.BunnyAddTotalPoints(bunny.getLevelPoints());
			if(bunny.getLevel()<10)
			{
				bunny.setLevel(bunny.getLevel()+1);
				NewLevelWindow NewLevelAnouncer = new NewLevelWindow(bunny);
				try
				{super.finalize();} 
				catch (Throwable e) 
				{e.printStackTrace();}
			}
			else if(bunny.getLevel()==10)
			{
				bunny.setLevel(1);
				bunny.setTotalPoints(0);
				NewYouWonWindow NewYouWonAnouncer = new NewYouWonWindow(bunny);
				try
				{super.finalize();} 
				catch (Throwable e) 
				{e.printStackTrace();}
			}
			
		}
		else
		{
			for(int i=0; i<carrots.size();i++)
			{
				if(carrots.get(i).getXpos()==x && carrots.get(i).getYpos()==y)
				{
					carrots.remove(i);
				}
				
			}
		}
	}
	
	//Carrot Mover
	private void CarrotUpdate()
	{
		if(bunny.getLevelPoints()<4)
		{
			for(int i=0; i<carrots.size(); i++)
			{
				int x= carrots.get(i).getXpos();
				int y = carrots.get(i).getYpos();
				int random;
				random = (int) (Math.random() * 3 + 1);
				switch(random) {
					case 1://Arriba
						if(matrix[x-1][y]==0)//grass
						{
							labelmatrix[x-1][y].setIcon(image2);
							labelmatrix[x][y].setIcon(image0);
							matrix[x-1][y]=2;
							matrix[x][y]=0;
							carrots.get(i).setXpos(x-1);
						}
						else if(matrix[x-1][y]==3)//bunny 
						{
							bunny.BunnyAddLevelPoints(1);
							carrots.remove(i);
							CarrotKiller(x,y);
							
							System.out.println(bunny.getLevelPoints());
							
							
							matrix[x][y]=0;
							labelmatrix[x][y].setIcon(image0);
							
							
						}
						else if(matrix[x-1][y]==1)//bush
						{}
						else if(matrix[x-1][y]==2)//carrot
						{}
						else if(matrix[x-1][y]==4)//fox
						{}
						break;
						
					case 2://Izquierda
						if(matrix[x][y-1]==0)//grass
						{
							labelmatrix[x][y-1].setIcon(image2);
							labelmatrix[x][y].setIcon(image0);
							matrix[x][y-1]=2;
							matrix[x][y]=0;
							carrots.get(i).setYpos(y-1);
						}
						else if(matrix[x][y-1]==3)//bunny 
						{
							bunny.BunnyAddLevelPoints(1);
							carrots.remove(i);
							CarrotKiller(x,y);
							
							System.out.println(bunny.getLevelPoints());
							
							labelmatrix[x][y].setIcon(image0);
							matrix[x][y]=0;
							
						}
						else if(matrix[x][y-1]==1)//bush
						{}
						else if(matrix[x][y-1]==2)//carrot
						{}
						else if(matrix[x][y-1]==4)//fox
						{}
						break;
						
					case 3://Derecha
						if(matrix[x][y+1]==0)//grass
						{
							labelmatrix[x][y+1].setIcon(image2);
							labelmatrix[x][y].setIcon(image0);
							matrix[x][y+1]=2;
							matrix[x][y]=0;
							carrots.get(i).setYpos(y+1);
						}
						else if(matrix[x][y+1]==3)//bunny 
						{
							bunny.BunnyAddLevelPoints(1);
							carrots.remove(i);
							CarrotKiller(x,y);
							
							System.out.println(bunny.getLevelPoints());
							
							labelmatrix[x][y].setIcon(image0);
							matrix[x][y]=0;
							
						}
						else if(matrix[x][y+1]==1)//bush
						{}
						else if(matrix[x][y+1]==2)//carrot
						{}
						else if(matrix[x][y+1]==4)//fox
						{}
						break;
						
					case 4:
						if(matrix[x+1][y]==0)//grass
						{
							labelmatrix[x+1][y].setIcon(image2);
							labelmatrix[x][y].setIcon(image0);
							matrix[x+1][y]=2;
							matrix[x][y]=0;
							carrots.get(i).setXpos(x+1);
						}
						else if(matrix[x+1][y]==3)//bunny 
						{
							bunny.BunnyAddLevelPoints(1);
							carrots.remove(i);
							CarrotKiller(x,y);
							
							System.out.println(bunny.getLevelPoints());
							
							labelmatrix[x][y].setIcon(image0);
							matrix[x][y]=0;
							
						}
						else if(matrix[x+1][y]==1)//bush
						{}
						else if(matrix[x+1][y]==2)//carrot
						{}
						else if(matrix[x+1][y]==4)//fox
						{}
						break;
					default:
						break;
				}
			}
		}
	}

	//Fox Generator
	private void FoxGenerator(int cant)
	{
		for(int i=0; i<filvalues; i++)
		{
			for(int k=0; k<colvalues;k++ )
			{
				if(matrix[i][k]==4)
				{
					labelmatrix[i][k].setIcon(image4);
					foxes.add(new Fox(i,k));		
				}
			}
		}
	}
	
	//Fox Mover
	private void FoxUpdate()
	{
		if(bunny.getLevelPoints()<4)
		{
			for(int i=0; i<foxes.size(); i++)
			{
				int x= foxes.get(i).getXpos();
				int y = foxes.get(i).getYpos();
				int random;
				random = (int) (Math.random() * 3 + 1);
				switch(random) {
					case 1://Arriba
						if(matrix[x-1][y]==0)//grass
						{
							labelmatrix[x-1][y].setIcon(image4);
							labelmatrix[x][y].setIcon(image0);
							matrix[x-1][y]=4;
							matrix[x][y]=0;
							foxes.get(i).setXpos(x-1);
						}
						else if(matrix[x-1][y]==3)//bunny 
						{
							labelmatrix[x-1][y].setIcon(image4);
							labelmatrix[x][y].setIcon(image0);
							ventana.dispose();
						// HAY QUE PONER LOS PUNTOS DEL NIVEL A CERO
							LevelLost();
							
						}
						else if(matrix[x-1][y]==1)//bush
						{}
						else if(matrix[x-1][y]==2)//carrot
						{}
						else if(matrix[x-1][y]==4)//fox
						{}
						break;
						
					case 2://Izquierda
						if(matrix[x][y-1]==0)//grass
						{
							labelmatrix[x][y-1].setIcon(image4);
							labelmatrix[x][y].setIcon(image0);
							matrix[x][y-1]=4;
							matrix[x][y]=0;
							foxes.get(i).setYpos(y-1);
						}
						else if(matrix[x][y-1]==3)//bunny 
						{
							labelmatrix[x-1][y].setIcon(image4);
							labelmatrix[x][y].setIcon(image0);
							ventana.dispose();
							LevelLost();
							
						}
						else if(matrix[x][y-1]==1)//bush
						{}
						else if(matrix[x][y-1]==2)//carrot
						{}
						else if(matrix[x][y-1]==4)//fox
						{}
						break;
						
					case 3://Derecha
						if(matrix[x][y+1]==0)//grass
						{
							labelmatrix[x][y+1].setIcon(image4);
							labelmatrix[x][y].setIcon(image0);
							matrix[x][y+1]=4;
							matrix[x][y]=0;
							foxes.get(i).setYpos(y+1);
						}
						else if(matrix[x][y+1]==3)//bunny 
						{
							labelmatrix[x-1][y].setIcon(image4);
							labelmatrix[x][y].setIcon(image0);
							ventana.dispose();
							LevelLost();
							
						}
						else if(matrix[x][y+1]==1)//bush
						{}
						else if(matrix[x][y+1]==2)//carrot
						{}
						else if(matrix[x][y+1]==4)//fox
						{}
						break;
						
					case 4:
						if(matrix[x+1][y]==0)//grass
						{
							labelmatrix[x+1][y].setIcon(image4);
							labelmatrix[x][y].setIcon(image0);
							matrix[x+1][y]=4;
							matrix[x][y]=0;
							foxes.get(i).setXpos(x+1);
						}
						else if(matrix[x+1][y]==3)//bunny 
						{
							labelmatrix[x-1][y].setIcon(image4);
							labelmatrix[x][y].setIcon(image0);
							ventana.dispose();
							LevelLost();
						}
						else if(matrix[x+1][y]==1)//bush
						{}
						else if(matrix[x+1][y]==2)//carrot
						{}
						else if(matrix[x+1][y]==4)//fox
						{}
						break;
					default:
						break;
				}
			}
		}
	}
	
	//Extra Fox Maker
	private void ExtraFox()
	{
		int fila=0; 
		int col=0;
		boolean isokay=true;
		while(isokay==true)
		{
		fila=(int)(Math.random()*11+1);
		col=(int)(Math.random()*15+1);
		if(matrix[fila][col]==0)//si no hay un bunny, un fox, una zanahoria o un bush
		{
				foxes.add(new Fox(fila,col));
				matrix[fila][col]=4;
				isokay=false;
		}
		}
				
		
	}

	//Level Lost Function
	private void LevelLost()
	{
		ventana.dispose();
		bunny.setLevel(bunny.getLevel());
		NewYouLostWindow lost = new NewYouLostWindow(bunny);
		try
		{super.finalize();} 
		catch (Throwable e) 
		{e.printStackTrace();}
	}
}
