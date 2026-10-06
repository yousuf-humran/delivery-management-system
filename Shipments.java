import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Shipments extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel srchlbl,headlbl;
	private JTextField srchfld;
	private JButton srchbtn,allbtn,bckbtn;
	private JTextArea listarea;
	private Courier c1;

	public Shipments()
	{
		super("All Shipments");
		this.setSize(900,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		c1=new Courier();

		panel=new JPanel();
		panel.setLayout(null);

		srchlbl=new JLabel("Search");
		srchlbl.setBounds(20,20,60,30);
		panel.add(srchlbl);

		srchfld=new JTextField();
		srchfld.setBounds(90,20,200,30);
		panel.add(srchfld);

		srchbtn=new JButton("Search");
		srchbtn.setBounds(310,20,100,30);
		srchbtn.addActionListener(this);
		panel.add(srchbtn);

		allbtn=new JButton("Show All");
		allbtn.setBounds(430,20,100,30);
		allbtn.addActionListener(this);
		panel.add(allbtn);

		bckbtn=new JButton("Back");
		bckbtn.setBounds(760,20,100,30);
		bckbtn.addActionListener(this);
		panel.add(bckbtn);

		headlbl=new JLabel("ID | Sender | Receiver | Status | Cost");
		headlbl.setBounds(20,70,500,30);
		panel.add(headlbl);

		listarea=new JTextArea();
		listarea.setEditable(false);
		listarea.setFont(new Font("Monospaced",Font.PLAIN,13));

		listarea.setBounds(20,100,840,340);
		panel.add(listarea);

		this.add(panel);

		listarea.setText(c1.search(""));
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==srchbtn)
		{
			String result=c1.search(srchfld.getText());

			if(result.isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Not found");
			}
			listarea.setText(result);
		}

		else if(ae.getSource()==allbtn)
		{
			srchfld.setText("");
			listarea.setText(c1.search(""));
		}

		else if(ae.getSource()==bckbtn)
		{
			this.setVisible(false);
			Home h1=new Home();
			h1.setVisible(true);
		}
	}
}
