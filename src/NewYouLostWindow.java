import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewYouLostWindow {

	private JFrame ventana;
	private JLabel auxlabel;
	private JLabel auxlabel1;
	private JLabel auxlabel2;
	private JLabel message;
	private JLabel message_1;
	private JLabel message_2;
	private JButton playbutton;
	private Font font;
	private int colvalues;
	private int filvalues;
	private FlowLayout fl = new FlowLayout(FlowLayout.CENTER,80,10);
	public NewYouLostWindow(Bunny b)
	{
		ventana= new JFrame("You lost");
		colvalues=6;
		filvalues=4;
		
		ventana.setSize(64*colvalues, 64*filvalues+22);//22 por el window header
		ventana.setResizable(false);
		ventana.setLocation(700, 200);
		
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		font= new Font("Comic Sans MS", Font.BOLD, 16);
		
		ventana.setLayout(new BorderLayout());
        ventana.setContentPane(new JLabel(new ImageIcon("src/Resource/newlevel384x256.png")));
        ventana.setLayout(fl);
        
        auxlabel= new JLabel("    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
        auxlabel1= new JLabel("    \t\t\t\t\t\t\t\t\t\n");
        auxlabel2= new JLabel("    \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n");
        message= new JLabel(" \t\t\t¡Lo sentimos!¡Perdiste!\t\t\t \n");
		message_1= new JLabel("\t\t\tPuntos:" + (b.getTotalPoints())+"\t\t\t  \n\n");
		message_2= new JLabel("\t\t\t Juega de nuevo el nivel "+ b.getLevel()+"\t\t\t \n");
		playbutton= new JButton("JUGAR NIVEL");
		playbutton.addActionListener(new ActionListener() {
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
				Window w = new Window(b);
			}
		});
		message.setFont(font);
		message_1.setFont(font);
		message_2.setFont(font);
		playbutton.setFont(font);

		ventana.add(auxlabel);
		ventana.add(auxlabel2);
		ventana.add(auxlabel1);
		ventana.add(message);
		ventana.add(message_1);
		ventana.add(message_2);
		ventana.add(playbutton);
		
	}
}
