package vehicle_pkg;
import enums_pkg.*;

public class AutonomousCar extends PrivateCar {
	private OS m_OS;

	public AutonomousCar(String m_plate, int m_EngineCC, int m_Doors, int m_Seats, int m_Laggage, String m_Model,
			Rank m_Rank, Gear m_Gear, boolean m_Hybrid, OS m_OS,int m_Price) {
		super(m_plate, m_EngineCC, m_Doors, m_Seats, m_Laggage, m_Model, m_Rank, m_Gear, m_Hybrid,m_Price);
		this.m_OS = m_OS;
	}

	public AutonomousCar() {
		super();
	}

	public final OS getM_OS() {
		return m_OS;
	}

	public final void setM_OS(OS m_OS) {
		this.m_OS = m_OS;
	}
	
	@Override
	public String toString()
	{
	return String.format("Model: %s\nEngine: %d\nDoors: %d\nSeats: %d\nLuggage: %d\nRank: %s\nGear: %s\nHybrid: %c\nOS: %s\nPrice per day: %d", 
			this.getM_Model(),this.getM_EngineCC(),this.getM_Doors(),this.getM_Seats(),this.getM_Laggage(),this.getM_Rank().name(),this.getM_Gear().name(),(this.isM_Hybrid()) ? 'Y' : 'N',this.getM_OS(),this.getM_Price());
	}
}
