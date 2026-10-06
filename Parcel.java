import java.lang.*;

public class Parcel
{
	private String trackingId;
	private String status;
	private String sname;
	private String sphone;
	private String saddr;
	private String rname;
	private String rphone;
	private String raddr;
	private double weight;
	private boolean outside;
	private double cost;

	public Parcel()
	{

	}

	public Parcel(String trackingId,String status,String sname,String sphone,String saddr,String rname,String rphone,String raddr,double weight,boolean outside,double cost)
	{
		this.trackingId=trackingId;
		this.status=status;
		this.sname=sname;
		this.sphone=sphone;
		this.saddr=saddr;
		this.rname=rname;
		this.rphone=rphone;
		this.raddr=raddr;
		this.weight=weight;
		this.outside=outside;
		this.cost=cost;
	}

	public void setTrackingId(String trackingId)
	{
		this.trackingId=trackingId;
	}

	public void setStatus(String status)
	{
		this.status=status;
	}

	public void setSname(String sname)
	{
		this.sname=sname;
	}

	public void setSphone(String sphone)
	{
		this.sphone=sphone;
	}

	public void setSaddr(String saddr)
	{
		this.saddr=saddr;
	}

	public void setRname(String rname)
	{
		this.rname=rname;
	}

	public void setRphone(String rphone)
	{
		this.rphone=rphone;
	}

	public void setRaddr(String raddr)
	{
		this.raddr=raddr;
	}

	public void setWeight(double weight)
	{
		this.weight=weight;
	}

	public void setOutside(boolean outside)
	{
		this.outside=outside;
	}

	public void setCost(double cost)
	{
		this.cost=cost;
	}

	public String getTrackingId()
	{
		return trackingId;
	}

	public String getStatus()
	{
		return status;
	}

	public String getSname()
	{
		return sname;
	}

	public String getSphone()
	{
		return sphone;
	}

	public String getSaddr()
	{
		return saddr;
	}

	public String getRname()
	{
		return rname;
	}

	public String getRphone()
	{
		return rphone;
	}

	public String getRaddr()
	{
		return raddr;
	}

	public double getWeight()
	{
		return weight;
	}

	public boolean getOutside()
	{
		return outside;
	}

	public double getCost()
	{
		return cost;
	}
}
