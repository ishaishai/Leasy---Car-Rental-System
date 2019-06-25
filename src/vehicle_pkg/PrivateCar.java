package vehicle_pkg;

import enums_pkg.Gear;
import enums_pkg.Rank;

public abstract class PrivateCar extends Vehicle {
	private boolean m_Hybrid;

	public PrivateCar(String m_plate, int m_EngineCC, int m_Doors, int m_Seats, int m_Laggage, String m_Model,
			Rank m_Rank, Gear m_Gear, boolean m_Hybrid,int m_Price) {
		super(m_plate, m_EngineCC, m_Doors, m_Seats, m_Laggage, m_Model, m_Rank, m_Gear,m_Price);
		this.m_Hybrid = m_Hybrid;
	}

	public PrivateCar() {
		super();
	}

	public final boolean isM_Hybrid() {
		return m_Hybrid;
	}

	public final void setM_Hybrid(boolean m_Hybrid) {
		this.m_Hybrid = m_Hybrid;
	}
	
}
