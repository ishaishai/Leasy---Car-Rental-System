package vehicle_pkg;

import enums_pkg.Gear;
import enums_pkg.Rank;

public abstract class Suv extends Vehicle
{
	private double m_Height;
	private boolean m_Tow; 
	
	public Suv(String m_Plate,int m_EngineCC, int m_Doors, int m_Seats, int m_Laggage, String m_Model, Rank m_Rank, Gear m_Gear, double m_Height, boolean m_Tow,int m_Price) 
	{
		super(m_Plate,m_EngineCC,m_Doors,m_Seats,m_Laggage,m_Model,m_Rank,m_Gear,m_Price);
		this.m_Height = m_Height;
		this.m_Tow = m_Tow;
	}

	public Suv() {
		super();
	}

	public final double getM_Height() {
		return m_Height;
	}
	public final void setM_Height(double m_Height) {
		this.m_Height = m_Height;
	}
	public final boolean isM_Tow() {
		return m_Tow;
	}
	public final void setM_Tow(boolean m_Tow) {
		this.m_Tow = m_Tow;
	}

		
}
