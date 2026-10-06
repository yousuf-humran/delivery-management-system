import java.lang.*;
import java.util.*;
import java.io.*;

public class Courier
{
	private File myfile;
	private FileWriter fwriter;
	private Scanner sc;

	public double getBase(boolean outside)
	{
		if(outside==true)
		{
			return 120;
		}
		else
		{
			return 60;
		}
	}

	public double getSurcharge(double weight)
	{
		if(weight>2)
		{
			return (weight-2)*35;
		}
		else
		{
			return 0;
		}
	}

	public double getCost(double weight,boolean outside)
	{
		return getBase(outside)+getSurcharge(weight);
	}

	public String makeId()
	{
		int count=0;

		try
		{
			myfile=new File("./parcels.txt");
			myfile.createNewFile();
			sc=new Scanner(myfile);

			while(sc.hasNextLine())
			{
				sc.nextLine();
				count++;
			}
			sc.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}

		int number=1001+count;
		return ""+number;
	}

	private String makeLine(Parcel p)
	{
		String line=p.getTrackingId()+"\t"+p.getStatus()+"\t"+p.getSname()+"\t"+p.getSphone()+"\t"+p.getSaddr()+"\t"+p.getRname()+"\t"+p.getRphone()+"\t"+p.getRaddr()+"\t"+p.getWeight()+"\t"+p.getOutside()+"\t"+p.getCost();
		return line;
	}

	private Parcel makeParcel(String value[])
	{
		Parcel p=new Parcel(value[0],value[1],value[2],value[3],value[4],value[5],value[6],value[7],Double.parseDouble(value[8]),Boolean.parseBoolean(value[9]),Double.parseDouble(value[10]));
		return p;
	}

	public void addParcel(Parcel p)
	{
		try
		{
			myfile=new File("./parcels.txt");
			myfile.createNewFile();
			fwriter=new FileWriter(myfile,true);

			fwriter.write(makeLine(p)+"\n");

			fwriter.flush();
			fwriter.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}

	public Parcel getParcel(String id)
	{
		Parcel found=null;

		try
		{
			myfile=new File("./parcels.txt");
			myfile.createNewFile();
			sc=new Scanner(myfile);

			while(sc.hasNextLine())
			{
				String line=sc.nextLine();
				String value[]=line.split("\t");
				if(value.length==11)
				{
					if(value[0].equals(id))
					{
						found=makeParcel(value);
					}
				}
			}
			sc.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}

		return found;
	}

	public String search(String text)
	{
		String result="";
		text=text.toLowerCase();

		try
		{
			myfile=new File("./parcels.txt");
			myfile.createNewFile();
			sc=new Scanner(myfile);

			while(sc.hasNextLine())
			{
				String line=sc.nextLine();
				String value[]=line.split("\t");
				if(value.length==11)
				{
					if(value[0].contains(text)||value[2].toLowerCase().contains(text)||value[5].toLowerCase().contains(text))
					{
						result=result+value[0]+" | "+value[2]+" | "+value[5]+" | "+value[1]+" | "+value[10]+" BDT\n";
					}
				}
			}
			sc.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}

		return result;
	}

	public void updateStatus(String id,String status)
	{
		String all="";

		try
		{
			myfile=new File("./parcels.txt");
			myfile.createNewFile();
			sc=new Scanner(myfile);

			while(sc.hasNextLine())
			{
				String line=sc.nextLine();
				String value[]=line.split("\t");
				if(value.length==11)
				{
					if(value[0].equals(id))
					{
						Parcel p=makeParcel(value);
						p.setStatus(status);
						line=makeLine(p);
					}
					all=all+line+"\n";
				}
			}
			sc.close();

			fwriter=new FileWriter(myfile);
			fwriter.write(all);
			fwriter.flush();
			fwriter.close();
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
	}
}
