package vehicle_pkg;
import enums_pkg.*;

public class Caravan extends Suv {
	private int m_Beds;
	private boolean m_Shower;
	private boolean m_Toilet;
	private boolean m_Kitchen;
	
	public Caravan(String m_Plate, int m_EngineCC, int m_Doors, int m_Seats, int m_Laggage, String m_Model, Rank m_Rank,
			Gear m_Gear, int m_Height, boolean m_Tow, int m_Beds, boolean m_Shower, boolean m_Toilet,
			boolean m_Kitchen,int m_Price) {
		super(m_Plate, m_EngineCC, m_Doors, m_Seats, m_Laggage, m_Model, m_Rank, m_Gear, m_Height, m_Tow,m_Price);
		this.m_Beds = m_Beds;
		this.m_Shower = m_Shower;
		this.m_Toilet = m_Toilet;
		this.m_Kitchen = m_Kitchen;
	}

	public Caravan() {
		super();
	}
	public final int getM_Beds() {
		return m_Beds;
	}

	public final void setM_Beds(int m_Beds) {
		this.m_Beds = m_Beds;
	}

	public final boolean isM_Shower() {
		return m_Shower;
	}

	public final void setM_Shower(boolean m_Shower) {
		this.m_Shower = m_Shower;
	}

	public final boolean isM_Toilet() {
		return m_Toilet;
	}

	public final void setM_Toilet(boolean m_Toilet) {
		this.m_Toilet = m_Toilet;
	}

	public final boolean isM_Kitchen() {
		return m_Kitchen;
	}

	public final void setM_Kitchen(boolean m_Kitchen) {
		this.m_Kitchen = m_Kitchen;
	}
	
	@Override
	public String toString()
	{
		return String.format("Model: %s\nEngine: %d\nDoors: %d\nSeats: %d\nLuggage: %d\nRank: %s\nGear: %s\nHeight: %d cm\nTow: %c\nBeds: %d\nShower: %c\nToilet: %c\nKitchen: %c\nPrice per day: %d", 
				this.getM_Model(),this.getM_EngineCC(),this.getM_Doors(),this.getM_Seats(),this.getM_Laggage(),this.getM_Rank().name(),this.getM_Gear().name(),this.getM_Height(),(this.isM_Tow()) ? 'Y':'N',this.getM_Beds(),(this.m_Shower) ? 'Y': 'N',(this.m_Toilet) ? 'Y':'N',(this.m_Kitchen) ? 'Y':'N',this.getM_Price());
	}
}
