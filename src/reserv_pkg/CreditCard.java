package reserv_pkg;

import enums_pkg.Credit;

public class CreditCard {
	private String m_ExpireDate;
	private String m_Digits;
	private Credit m_CreditType;
	public CreditCard(String m_ExpireDate,String m_Digits,Credit m_CreditType)
	{
		this.m_ExpireDate = m_ExpireDate;
		this.m_Digits = m_Digits;
		this.m_CreditType = m_CreditType;
	}

	public final String getM_ExpireDate() {
		return m_ExpireDate;
	}

	public final void setM_ExpireDate(String m_ExpireDate) {
		this.m_ExpireDate = m_ExpireDate;
	}

	public final String getM_Digits() {
		return m_Digits;
	}

	public final void setM_Digits(String m_Digits) {
		this.m_Digits = m_Digits;
	}

	public final Credit getM_CreditType() {
		return m_CreditType;
	}

	public final void setM_CreditType(Credit m_CreditType) {
		this.m_CreditType = m_CreditType;
	}
	
	

}
