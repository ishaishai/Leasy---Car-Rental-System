package vehicle_pkg;
import enums_pkg.*;

public abstract class Vehicle 
{
	private String m_Plate;
	private int m_EngineCC;
	private int m_Doors;
	private int m_Seats;
	private int m_Laggage;
	private int m_Price;
	private String m_Model;
	
	private Rank m_Rank;
	private Gear m_Gear;
	
	
	public Vehicle(String m_plate,int m_EngineCC, int m_Doors, int m_Seats, int m_Laggage, String m_Model,
			Rank m_Rank, Gear m_Gear,int m_Price) {
		this.m_Plate = m_plate;
		this.m_EngineCC = m_EngineCC;
		this.m_Doors = m_Doors;
		this.m_Seats = m_Seats;
		this.m_Laggage = m_Laggage;
		this.m_Model = m_Model;
		this.m_Rank = m_Rank;
		this.m_Gear = m_Gear;
		this.m_Price = m_Price;
	}

	public Vehicle() {
		
	}

	public final String getM_plate() {
		return m_Plate;
	}
	public final void setM_plate(String m_plate) {
		this.m_Plate = m_plate;
	}
	public final int getM_EngineCC() {
		return m_EngineCC;
	}
	public final void setM_EngineCC(int m_EngineCC) {
		this.m_EngineCC = m_EngineCC;
	}
	public final int getM_Doors() {
		return m_Doors;
	}
	public final void setM_Doors(int m_Doors) {
		this.m_Doors = m_Doors;
	}
	public final int getM_Seats() {
		return m_Seats;
	}
	public final void setM_Seats(int m_Seats) {
		this.m_Seats = m_Seats;
	}
	public final int getM_Baggage() {
		return m_Laggage;
	}
	public final void setM_Baggage(int m_Laggage) {
		this.m_Laggage = m_Laggage;
	}
	public final String getM_Model() {
		return m_Model;
	}
	public final void setM_Model(String m_Model) {
		this.m_Model = m_Model;
	}
	public final Gear getM_Gear() {
		return m_Gear;
	}
	public final void setM_Gear(Gear m_Gear) {
		this.m_Gear = m_Gear;
	}
	public Rank getM_Rank() {
		return m_Rank;
	}
	public void setM_Rank(Rank m_Rank) {
		this.m_Rank = m_Rank;
	}

	public final String getM_Plate() {
		return m_Plate;
	}

	public final void setM_Plate(String m_Plate) {
		this.m_Plate = m_Plate;
	}

	public final int getM_Laggage() {
		return m_Laggage;
	}

	public final void setM_Laggage(int m_Laggage) {
		this.m_Laggage = m_Laggage;
	}

	public final int getM_Price() {
		return m_Price;
	}

	public final void setM_Price(int m_Price) {
		this.m_Price = m_Price;
	}
	
	public String toString()
	{
		return new String("");
	}
	

}
