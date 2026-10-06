import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel titlelbl,imglbl;
	private JButton newbtn,listbtn,trackbtn,exitbtn;
	private Color mycolor;
	private Font myfont;
	private ImageIcon img;

	public Home()
	{
		super("Express Delivery");
		this.setSize(800,450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		mycolor=new Color(70,188,244);
		myfont=new Font("Cambria",Font.PLAIN,28);

		panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(mycolor);

		titlelbl = new JLabel("Express Delivery");
		titlelbl.setBounds(280, 30, 350, 50);
		titlelbl.setFont(myfont.deriveFont(Font.BOLD));
		panel.add(titlelbl);


		img=new ImageIcon("./logo.png");

		imglbl=new JLabel(img);
		imglbl.setBounds(40,110,380,225);
		panel.add(imglbl);

		newbtn=new JButton("New Shipment");
		newbtn.setBounds(500,110,220,40);
		newbtn.addActionListener(this);
		panel.add(newbtn);

		listbtn=new JButton("All Shipments");
		listbtn.setBounds(500,170,220,40);
		listbtn.addActionListener(this);
		panel.add(listbtn);

		trackbtn=new JButton("Track / Update");
		trackbtn.setBounds(500,230,220,40);
		trackbtn.addActionListener(this);
		panel.add(trackbtn);

		exitbtn=new JButton("Exit");
		exitbtn.setBounds(500,290,220,40);
		exitbtn.addActionListener(this);
		panel.add(exitbtn);

		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==newbtn)
		{
			this.setVisible(false);
			NewShipment n1=new NewShipment();
			n1.setVisible(true);
		}
		else if(ae.getSource()==listbtn)
		{
			this.setVisible(false);
			Shipments s1=new Shipments();
			s1.setVisible(true);
		}
		else if(ae.getSource()==trackbtn)
		{
			this.setVisible(false);
			Track t1=new Track();
			t1.setVisible(true);
		}
		else if(ae.getSource()==exitbtn)
		{
			System.exit(0);
		}
	}
}
