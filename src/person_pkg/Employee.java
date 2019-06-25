package person_pkg;

public class Employee {
	private String m_Username;
	private String m_Password;
	private String m_PCode; //promotion code
	
	public Employee(String m_Username, String m_Password, String m_PCode) {
		super();
		this.m_Username = m_Username;
		this.m_Password = m_Password;
		this.m_PCode = m_PCode;
	}
	
	public Employee(String m_Username, String m_Password)
	{
		this(m_Username, m_Password,null);
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public final String getM_Username() {
		return m_Username;
	}

	public final void setM_Username(String m_Username) {
		this.m_Username = m_Username;
	}

	public final String getM_Password() {
		return m_Password;
	}

	public final void setM_Password(String m_Password) {
		this.m_Password = m_Password;
	}

	public final String getM_PCode() {
		return m_PCode;
	}

	public final void setM_PCode(String m_PCode) {
		this.m_PCode = m_PCode;
	}
	
	
	
}
