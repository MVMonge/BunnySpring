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
	
public class PauseSheet extends JFrame{
		private static final long serialVersionUID = 1L;
		private JFrame ventana;
		private JLabel auxlabel1;
		private JLabel auxlabel2;
		private JButton resumebutton;
		private JButton savebutton;
		private Font font= new Font("Comic Sans MS", Font.BOLD, 16);
		private int colvalues;
		private int filvalues;
		private FlowLayout fl = new FlowLayout(FlowLayout.CENTER,80,30);
		public PauseSheet(Bunny b, JFrame v)
		{
			ventana= new JFrame("Pausa");
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
	        
			resumebutton= new JButton("Continuar Jugando");
			resumebutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ventana.dispose();
					try {
						super.finalize();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			savebutton= new JButton("Guardar juego");
			savebutton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ventana.dispose();
					ArchiveClass a;
					try {
						a = new ArchiveClass();
						a.SaveGame(b.getLevel(), b.getTotalPoints());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					v.dispose();
					HiSheet hi = new HiSheet(b);
					
					try {
						super.finalize();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			resumebutton.setFont(font);
			savebutton.setFont(font);
		
			ventana.add(auxlabel2);
			ventana.add(auxlabel1);
		
			ventana.add(resumebutton);
			ventana.add(savebutton);
			
			ventana.setVisible(true);
			ventana.setFocusable(true);
			ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
}