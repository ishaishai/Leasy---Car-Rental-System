package person_pkg;
import enums_pkg.*;

public class Customer {
	private String m_ID;
	private String m_Name;
	private int m_Age;
	
	private int m_DriveXP;
	private Rank m_Rank;
	private String m_Phone;
	
	
	public Customer(String m_ID, String m_Name, int m_Age, int m_DriveXP, Rank m_Rank, String m_Phone) {
		this.m_ID = m_ID;
		this.m_Name = m_Name;
		this.m_Age = m_Age;
		this.m_DriveXP = m_DriveXP;
		this.m_Rank = m_Rank;
		this.m_Phone = m_Phone;
	}
	
	public Customer(String m_ID,String m_Name,String m_Phone)
	{
		this.m_ID = m_ID;
		this.m_Name = m_Name;
		this.m_Age = 0;
		this.m_DriveXP = 0;
		this.m_Rank = null;
		this.m_Phone = m_Phone;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public final String getM_ID() {
		return m_ID;
	}
	public final void setM_ID(String m_ID) {
		this.m_ID = m_ID;
	}
	public final String getM_Name() {
		return m_Name;
	}
	public final void setM_Name(String m_Name) {
		this.m_Name = m_Name;
	}
	public final int getM_Age() {
		return m_Age;
	}
	public final void setM_Age(int m_Age) {
		this.m_Age = m_Age;
	}
	public final int getM_DriveXP() {
		return m_DriveXP;
	}
	public final void setM_DriveXP(int m_DriveXP) {
		this.m_DriveXP = m_DriveXP;
	}
	public final Rank getM_Rank() {
		return m_Rank;
	}
	public final void setM_Rank(Rank m_Rank) {
		this.m_Rank = m_Rank;
	}
	public final String getM_Phone() {
		return m_Phone;
	}
	public final void setM_Phone(String m_Phone) {
		this.m_Phone = m_Phone;
	}
	
	public final String toString()
	{
		return String.format("ID: %s\nName: %s\nAge: %d\nDriving experience: %d\nRank: %s\nPhone num: %s\n", 
				this.m_ID,this.m_Name,this.m_Age,this.m_DriveXP,Rank.toString(this.m_Rank),this.m_Phone);
		
	}
	
	
}
