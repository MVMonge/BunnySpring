import java.awt.BorderLayout;
	import java.awt.FlowLayout;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
public class HiSheet extends JFrame{

	private static final long serialVersionUID = 1L;
		private JFrame ventana;
		private JLabel auxlabel1;
		private JLabel auxlabel2;
		private JButton newgamebutton;
		private JButton savedgamebutton;
		private Font font= new Font("Comic Sans MS", Font.BOLD, 16);
		private int colvalues;
		private int filvalues;
		private FlowLayout fl = new FlowLayout(FlowLayout.CENTER,80,30);
		public HiSheet(Bunny b)
		{
			ventana= new JFrame("Bunny Spring");
			colvalues=6;
			filvalues=4;
			
			ventana.setSize(64*colvalues, 64*filvalues+22);
			ventana.setResizable(false);
			ventana.setLocation(700, 200);
			
			ventana.setLayout(new BorderLayout());
	        ventana.setContentPane(new JLabel(new ImageIcon("src/Resource/newlevel384x256.png")));
	        ventana.setLayout(fl);
	        
	        auxlabel1= new JLabel(" \t\t\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t\n");
	        auxlabel2= new JLabel("\t\t\t\t\t\t\t\t\t  \t\t\t\t\t\t\t\t\t");
	        
			newgamebutton= new JButton("JUGAR NUEVO JUEGO");
			newgamebutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ventana.dispose();
					b.setLevel(1);
					b.setTotalPoints(0);
					Window w = new Window(b);
					try {
						super.finalize();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			savedgamebutton= new JButton("JUGAR JUEGO GUARDADO");
			savedgamebutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ventana.dispose();
					ArchiveClass a;
					try {
						a = new ArchiveClass();
						b.setLevel(a.getLevel());
						b.setTotalPoints(a.getTotalpoints());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					Window w = new Window(b);
					try {
						super.finalize();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			newgamebutton.setFont(font);
			savedgamebutton.setFont(font);
		
			ventana.add(auxlabel2);
			ventana.add(auxlabel1);
		
			ventana.add(newgamebutton);
			ventana.add(savedgamebutton);
			
			ventana.setVisible(true);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}