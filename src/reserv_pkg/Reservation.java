package reserv_pkg;

import java.util.Date;

public class Reservation {
	private Date m_Start;
	private Date m_End;
	private int m_CustomerAge;
	private int m_DriveXP;
	
	public Reservation(Date m_Start, Date m_End, int m_CustomerAge, int m_DriveXP) {
		this.m_Start = m_Start;
		this.m_End = m_End;
		this.m_CustomerAge = m_CustomerAge;
		this.m_DriveXP = m_DriveXP;
	}
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	public final Date getM_Start() {
		return m_Start;
	}
	public final void setM_Start(Date m_Start) {
		this.m_Start = m_Start;
	}
	public final Date getM_End() {
		return m_End;
	}
	public final void setM_End(Date m_End) {
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
		return "Reservation [m_Start=" + m_Start + ", m_End=" + m_End + ", m_CustomerAge=" + m_CustomerAge
				+ ", m_DriveXP=" + m_DriveXP + "]";
	}
	
	
	
}
