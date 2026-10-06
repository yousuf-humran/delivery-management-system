import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.*;

public class Track extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel idlbl,stlbl;
	private JTextField idfld;
	private JButton findbtn,updbtn,bckbtn;
	private JComboBox stbox;
	private JTextArea invarea,lblarea;
	private Courier c1;
	private Parcel current;

	public Track()
	{
		super("Track / Update");
		this.setSize(900,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		c1=new Courier();
		current=null;

		String status[]={"Pending","Picked Up","In Transit","Hub Sorting","Out for Delivery","Delivered","Returned"};

		panel=new JPanel();
		panel.setLayout(null);

		idlbl=new JLabel("Tracking ID");
		idlbl.setBounds(20,20,100,30);
		panel.add(idlbl);

		idfld=new JTextField();
		idfld.setBounds(120,20,170,30);
		panel.add(idfld);

		findbtn=new JButton("Find");
		findbtn.setBounds(310,20,100,30);
		findbtn.addActionListener(this);
		panel.add(findbtn);

		bckbtn=new JButton("Back");
		bckbtn.setBounds(760,20,100,30);
		bckbtn.addActionListener(this);
		panel.add(bckbtn);

		invarea=new JTextArea();
		invarea.setEditable(false);
		invarea.setFont(new Font("Monospaced",Font.PLAIN,13));

		invarea.setBounds(20,80,420,380);
		panel.add(invarea);

		lblarea=new JTextArea();
		lblarea.setEditable(false);
		lblarea.setFont(new Font("Monospaced",Font.BOLD,14));

		lblarea.setBounds(460,80,400,380);
		panel.add(lblarea);

		stlbl=new JLabel("Status");
		stlbl.setBounds(20,490,60,30);
		panel.add(stlbl);

		stbox=new JComboBox(status);
		stbox.setBounds(90,490,200,30);
		panel.add(stbox);

		updbtn=new JButton("Update Status");
		updbtn.setBounds(310,490,150,30);
		updbtn.addActionListener(this);
		panel.add(updbtn);

		this.add(panel);
	}

	public void showParcel()
	{
		Parcel p=current;

		invarea.setText("EXPRESS DELIVERY LTD.\n"
		+"------------------------------\n"
		+"Tracking ID : "+p.getTrackingId()+"\n"
		+"Status      : "+p.getStatus()+"\n"
		+"------------------------------\n"
		+"FROM : "+p.getSname()+"\n"
		+"       "+p.getSaddr()+"\n"
		+"       "+p.getSphone()+"\n"
		+"TO   : "+p.getRname()+"\n"
		+"       "+p.getRaddr()+"\n"
		+"       "+p.getRphone()+"\n"
		+"------------------------------\n"
		+"Weight    : "+p.getWeight()+" KG\n"
		+"Base Rate : "+c1.getBase(p.getOutside())+" BDT\n"
		+"Surcharge : "+c1.getSurcharge(p.getWeight())+" BDT\n"
		+"TOTAL     : "+p.getCost()+" BDT\n");

		lblarea.setText("\n  SHIPPING LABEL\n"
		+"  ====================\n\n"
		+"  ID: "+p.getTrackingId()+"\n\n"
		+"  TO: "+p.getRname()+"\n"
		+"      "+p.getRaddr()+"\n"
		+"      "+p.getRphone()+"\n\n"
		+"  FROM: "+p.getSname()+"\n\n"
		+"  Weight: "+p.getWeight()+" KG\n");

		stbox.setSelectedItem(p.getStatus());
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==findbtn)
		{
			String id=idfld.getText();

			if(id.isEmpty())
			{
				JOptionPane.showMessageDialog(this,"Fill up ALL");
			}
			else
			{
				current=c1.getParcel(id);

				if(current==null)
				{
					JOptionPane.showMessageDialog(this,"Not found");
					invarea.setText("");
					lblarea.setText("");
				}
				else
				{
					this.showParcel();
				}
			}
		}

		else if(ae.getSource()==updbtn)
		{
			if(current==null)
			{
				JOptionPane.showMessageDialog(this,"Find a shipment first");
			}
			else
			{
				String newstatus=(String)stbox.getSelectedItem();
				c1.updateStatus(current.getTrackingId(),newstatus);
				current.setStatus(newstatus);
				this.showParcel();
				JOptionPane.showMessageDialog(this,"Status changed to "+newstatus);
			}
		}

		else if(ae.getSource()==bckbtn)
		{
			this.setVisible(false);
			Home h1=new Home();
			h1.setVisible(true);
		}
	}
}
