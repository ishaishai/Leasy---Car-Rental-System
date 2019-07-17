package vehicle_pkg;

import enums_pkg.Gear;
import enums_pkg.Rank;

public class WorkCar extends Suv {
	private boolean m_Dual;

	public WorkCar(String m_Plate, int m_EngineCC, int m_Doors, int m_Seats, int m_Laggage, String m_Model, Rank m_Rank,
			Gear m_Gear, int m_Height, boolean m_Tow, boolean m_Dual,int m_Price) {
		super(m_Plate, m_EngineCC, m_Doors, m_Seats, m_Laggage, m_Model, m_Rank, m_Gear, m_Height, m_Tow,m_Price);
		this.m_Dual = m_Dual;
	}

	public WorkCar() {
		super();
	}

	public final boolean isM_Dual() {
		return m_Dual;
	}

	public final void setM_Dual(boolean m_Dual) {
		this.m_Dual = m_Dual;
	}
	
	@Override
	public String toString()
	{
		return String.format("Model: %s\nEngine: %d\nDoors: %d\nSeats: %d\nLuggage: %d\nRank: %s\nGear: %s\nHeight: %d cm\nTow: %c\nDual: %c\nPrice per day: %d", 
				this.getM_Model(),this.getM_EngineCC(),this.getM_Doors(),this.getM_Seats(),this.getM_Laggage(),this.getM_Rank().name(),this.getM_Gear().name(),this.getM_Height(),(this.isM_Tow()) ? 'Y' : 'N',(this.m_Dual) ? 'Y' : 'N',this.getM_Price());
	}
}
