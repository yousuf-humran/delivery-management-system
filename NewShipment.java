import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewShipment extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel snamlbl,sphnlbl,sadrlbl,rnamlbl,rphnlbl,radrlbl,wgtlbl;
	private JTextField snamfld,sphnfld,sadrfld,rnamfld,rphnfld,radrfld,wgtfld;
	private JCheckBox outbox;
	private JButton dispbtn,clrbtn,bckbtn;
	private Courier c1;

	public NewShipment()
	{
		super("New Shipment");
		this.setSize(800,450);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		c1=new Courier();

		panel=new JPanel();
		panel.setLayout(null);

		snamlbl=new JLabel("Sender Name");
		snamlbl.setBounds(20,30,100,30);
		panel.add(snamlbl);

		snamfld=new JTextField();
		snamfld.setBounds(130,30,230,30);
		panel.add(snamfld);

		sphnlbl=new JLabel("Sender Phone");
		sphnlbl.setBounds(20,90,100,30);
		panel.add(sphnlbl);

		sphnfld=new JTextField();
		sphnfld.setBounds(130,90,230,30);
		panel.add(sphnfld);

		sadrlbl=new JLabel("Sender Address");
		sadrlbl.setBounds(20,150,100,30);
		panel.add(sadrlbl);

		sadrfld=new JTextField();
		sadrfld.setBounds(130,150,230,30);
		panel.add(sadrfld);

		rnamlbl=new JLabel("Receiver Name");
		rnamlbl.setBounds(420,30,100,30);
		panel.add(rnamlbl);

		rnamfld=new JTextField();
		rnamfld.setBounds(530,30,230,30);
		panel.add(rnamfld);

		rphnlbl=new JLabel("Receiver Phone");
		rphnlbl.setBounds(420,90,100,30);
		panel.add(rphnlbl);

		rphnfld=new JTextField();
		rphnfld.setBounds(530,90,230,30);
		panel.add(rphnfld);

		radrlbl=new JLabel("Receiver Address");
		radrlbl.setBounds(420,150,110,30);
		panel.add(radrlbl);

		radrfld=new JTextField();
		radrfld.setBounds(530,150,230,30);
		panel.add(radrfld);

		wgtlbl=new JLabel("Weight (KG)");
		wgtlbl.setBounds(20,220,100,30);
		panel.add(wgtlbl);

		wgtfld=new JTextField();
		wgtfld.setBounds(130,220,100,30);
		panel.add(wgtfld);

		outbox=new JCheckBox("Outside City");
		outbox.setBounds(420,220,150,30);
		panel.add(outbox);

		dispbtn=new JButton("Dispatch");
		dispbtn.setBounds(150,310,120,45);
		dispbtn.addActionListener(this);
		panel.add(dispbtn);

		clrbtn=new JButton("Clear");
		clrbtn.setBounds(340,310,120,45);
		clrbtn.addActionListener(this);
		panel.add(clrbtn);

		bckbtn=new JButton("Back");
		bckbtn.setBounds(530,310,120,45);
		bckbtn.addActionListener(this);
		panel.add(bckbtn);

		this.add(panel);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==dispbtn)
		{
			String sn=snamfld.getText();
			String sp=sphnfld.getText();
			String sa=sadrfld.getText();
			String rn=rnamfld.getText();
			String rp=rphnfld.getText();
			String ra=radrfld.getText();
			String w=wgtfld.getText();

			if(sn.isEmpty()||sp.isEmpty()||sa.isEmpty()||rn.isEmpty()||rp.isEmpty()||ra.isEmpty()||w.isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Fill up ALL");
			}
			else
			{
				try
				{
					double weight=Double.parseDouble(w);

					if(weight<=0)
					{
						JOptionPane.showMessageDialog(this,"Weight must be more than 0");
					}
					else
					{
						boolean out=outbox.isSelected();
						double cost=c1.getCost(weight,out);
						String id=c1.makeId();

						Parcel p1=new Parcel(id,"Pending",sn,sp,sa,rn,rp,ra,weight,out,cost);
						c1.addParcel(p1);

						JOptionPane.showMessageDialog(this,"Tracking ID: "+id+"\nCost: "+cost+" BDT");
						this.clearAll();
					}
				}
				catch(NumberFormatException nfe)
				{
					JOptionPane.showMessageDialog(this,"Weight must be a number");
				}
			}
		}

		else if(ae.getSource()==clrbtn)
		{
			this.clearAll();
		}

		else if(ae.getSource()==bckbtn)
		{
			this.setVisible(false);
			Home h1=new Home();
			h1.setVisible(true);
		}
	}

	public void clearAll()
	{
		snamfld.setText("");
		sphnfld.setText("");
		sadrfld.setText("");
		rnamfld.setText("");
		rphnfld.setText("");
		radrfld.setText("");
		wgtfld.setText("");
		outbox.setSelected(false);
	}
}
