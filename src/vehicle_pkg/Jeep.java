package vehicle_pkg;
import enums_pkg.*;

public class Jeep extends Suv{
	boolean m_Dirt;

	public Jeep(String m_Plate, int m_EngineCC, int m_Doors, int m_Seats, int m_Luggage, String m_Model, Rank m_Rank,
			Gear m_Gear, double m_Height, boolean m_Tow, boolean m_Dirt,int m_Price) {
		super(m_Plate, m_EngineCC, m_Doors, m_Seats, m_Luggage, m_Model, m_Rank, m_Gear, m_Height, m_Tow,m_Price);
		this.m_Dirt = m_Dirt;
	}

	public Jeep() {
		super();
	}

	public final boolean isM_Dirt() {
		return m_Dirt;
	}

	public final void setM_Dirt(boolean m_Dirt) {
		this.m_Dirt = m_Dirt;
	}
	
	@Override
	public String toString()
	{
	return String.format("Model: %s\nEngine: %d\nDoors: %d\nSeats: %d\nLuggage: %d\nRank: %s\nGear: %s\nHeight: %f\nTow: %c\nDirt: %c\nPrice per day: %d", 
			this.getM_Model(),this.getM_EngineCC(),this.getM_Doors(),this.getM_Seats(),this.getM_Laggage(),this.getM_Rank().name(),this.getM_Gear().name(),this.getM_Height(),(this.isM_Tow()) ? 'Y' : 'N',(this.m_Dirt) ? 'Y' : 'N',this.getM_Price());
	}
} 	
