package reserv_pkg;


public class Insurance
{
	private int m_DailyPrice;
	private String m_Title;
	private String m_Desc;
	
	public Insurance(int m_DailyPrice, String m_Title, String m_Desc) {
		this.m_DailyPrice = m_DailyPrice;
		this.m_Title = m_Title;
		this.m_Desc = m_Desc;
	}
	public Insurance() {
		// TODO Auto-generated constructor stub
	}
	public final int getM_DailyPrice() {
		return m_DailyPrice;
	}
	public final void setM_DailyPrice(int m_DailyPrice) {
		this.m_DailyPrice = m_DailyPrice;
	}
	public final String getM_Title() {
		return m_Title;
	}
	public final void setM_Title(String m_Title) {
		this.m_Title = m_Title;
	}
	public final String getM_Desc() {
		return m_Desc;
	}
	public final void setM_Desc(String m_Desc) {
		this.m_Desc = m_Desc;
	}
	
	
	@Override
	public String toString()
	{
		return new String("Insurance type: "+this.m_Title+"\n\nDetails: "+this.m_Desc+"\n\nDaily price: "+this.m_DailyPrice);
	}
	
	
}