package design_patterns_pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlLink{
	private Connection m_Connection;
	
	public final Connection getM_Connection() {
		return m_Connection;
	}

	public SqlLink()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
		}
		catch(ClassNotFoundException exception)
		{
			System.out.println(exception.getMessage());
		}
		
	    m_Connection = null;
	    try
	    {
	       // create a database connection
	       m_Connection = DriverManager.getConnection("jdbc:sqlite:DB/CarRentalDatabase.db");
	    }
	    catch(SQLException e){  System.err.println(e.getMessage()); }     
	}
	public void CloseLink()
	{
		 try {
             if(m_Connection != null)
                m_Connection.close();
             }
       catch(SQLException e) {          
          System.err.println(e); 
        }
	}
	
	
}