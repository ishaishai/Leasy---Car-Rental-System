package reserv_pkg;

import java.util.Date;

public class Reservation {
	private String m_Start;
	private String m_End;
	private int m_CustomerAge;
	private int m_DriveXP;
	
	public Reservation(String m_Start, String m_End, int m_CustomerAge, int m_DriveXP) {
		this.m_Start = m_Start;
		this.m_End = m_End;
		this.m_CustomerAge = m_CustomerAge;
		this.m_DriveXP = m_DriveXP;
	}
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	public final String getM_Start() {
		return m_Start;
	}
	public final void setM_Start(String m_Start) {
		this.m_Start = m_Start;
	}
	public final String getM_End() {
		return m_End;
	}
	public final void setM_End(String m_End) {
		this.m_End = m_End;
	}
	public final int getM_CustomerAge() {
		return m_CustomerAge;
	}
	public final void setM_CustomerAge(int m_CustomerAge) {
		this.m_CustomerAge = m_CustomerAge;
	}
	public final int getM_DriveXP() {
		return m_DriveXP;
	}
	public final void setM_DriveXP(int m_DriveXP) {
		this.m_DriveXP = m_DriveXP;
	}
	@Override
	public String toString() {
		return "Pick up: " + m_Start + "\nReturn at: " + m_End;
	}
	
	
	
}
