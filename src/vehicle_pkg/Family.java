package vehicle_pkg;

import enums_pkg.*;

public class Family extends PrivateCar {
	private boolean m_Hatchback;

	public Family(String m_plate, int m_EngineCC, int m_Doors, int m_Seats, int m_Laggage, String m_Model, Rank m_Rank,
			Gear m_Gear, boolean m_Hybrid, boolean m_Hatchback,int m_Price) {
		super(m_plate, m_EngineCC, m_Doors, m_Seats, m_Laggage, m_Model, m_Rank, m_Gear, m_Hybrid,m_Price);
		this.m_Hatchback = m_Hatchback;
	}

	public Family() {
		super();
	}

	public final boolean isM_Hatchback() {
		return m_Hatchback;
	}

	public final void setM_Hatchback(boolean m_Hatchback) {
		this.m_Hatchback = m_Hatchback;
	};
	
	@Override
	public String toString()
	{
	return String.format("Model: %s\nEngine: %d\nDoors: %d\nSeats: %d\nLuggage: %d\nRank: %s\nGear: %s\nHybrid: %c\nHatchback: %c\nPrice per day: %d", 
			this.getM_Model(),this.getM_EngineCC(),this.getM_Doors(),this.getM_Seats(),this.getM_Laggage(),this.getM_Rank().name(),this.getM_Gear().name(),(this.isM_Hybrid()) ? 'Y' : 'N',(this.m_Hatchback) ? 'Y' : 'N',this.getM_Price());
	}
}
