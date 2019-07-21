package design_patterns_pkg;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import enums_pkg.Gear;
import enums_pkg.OS;
import enums_pkg.Rank;
import person_pkg.Customer;
import person_pkg.Employee;
import reserv_pkg.CreditCard;
import reserv_pkg.Insurance;
import reserv_pkg.Invoice;
import reserv_pkg.Reservation;
import vehicle_pkg.AutonomousCar;
import vehicle_pkg.Caravan;
import vehicle_pkg.Family;
import vehicle_pkg.Jeep;
import vehicle_pkg.Luxury;
import vehicle_pkg.Vehicle;
import vehicle_pkg.WorkCar;

public class ModelDesign 
{
	public ModelDesign()
	{
		
	}

	protected HashMap<String,Vehicle>  getRelevantVehicles(String rank)
	{
		try {
			/*Converts the date object we had to a string in the shape of yyyy-mm-dd.
			to see the old date object remove the // from the command below */
			
			String fromDate = DataManager.getInstance().getM_Reserv().getM_Start();
			String toDate = DataManager.getInstance().getM_Reserv().getM_End();
			
			Statement statement = DataManager.getInstance().getM_SqlLink().getM_Connection().createStatement();
			
			statement.setQueryTimeout(30);
			
			DataManager.getInstance().getM_Vehicles().clear();
			
			switch(rank)
			{
			case "A":
			{
				BuildFamilyArray(statement.executeQuery("select * from Vehicle join Private using (Plate) join Family using (Plate) where Rank = 'A' And Plate not in (Select LicensePlate from Invoice as t2 where (t2.FromDate<= '"+ fromDate +"' and t2.ToDate >= '"+ toDate +"') or ('"+ fromDate +"' between t2.FromDate and t2.ToDate) or ('"+ toDate +"' between FromDate and ToDate) or (t2.FromDate>='"+ fromDate +"' and '"+ toDate +"' >= t2.ToDate))"));
				break;
			}
			case "B":
			{
				BuildCaravanArray(statement.executeQuery("select * from Vehicle join Suv using (Plate) join Caravan using (Plate)where Rank ='B' And Plate not in (Select LicensePlate from Invoice as t2 where (t2.FromDate<= '"+ fromDate +"' and t2.ToDate >= '"+ toDate +"') or ('"+ fromDate +"' between t2.FromDate and t2.ToDate) or ('"+ toDate +"' between FromDate and ToDate) or (t2.FromDate>='"+ fromDate +"' and '"+ toDate +"' >= t2.ToDate))"));
				BuildJeepArray(statement.executeQuery("select * from Vehicle join Suv using (Plate) join Jeep using (Plate)where Rank ='B' And Plate not in (Select LicensePlate from Invoice as t2 where (t2.FromDate<= '"+ fromDate +"' and t2.ToDate >= '"+ toDate +"') or ('"+ fromDate +"' between t2.FromDate and t2.ToDate) or ('"+ toDate +"' between FromDate and ToDate) or (t2.FromDate>='"+ fromDate +"' and '"+ toDate +"' >= t2.ToDate))"));
				BuildWorkArray(statement.executeQuery("select * from Vehicle join Suv using (Plate) join WorkCar using (Plate)where Rank ='B' And Plate not in (Select LicensePlate from Invoice as t2 where (t2.FromDate<= '"+ fromDate +"' and t2.ToDate >= '"+ toDate +"') or ('"+ fromDate +"' between t2.FromDate and t2.ToDate) or ('"+ toDate +"' between FromDate and ToDate) or (t2.FromDate>='"+ fromDate +"' and '"+ toDate +"' >= t2.ToDate))"));
				break;
			}
			case "C":
			{
				BuildJeepArray(statement.executeQuery("select * from Vehicle join Suv using (Plate) join Jeep using (Plate) where Rank = 'C' And Plate not in (Select LicensePlate from Invoice as t2 where (t2.FromDate<= '"+ fromDate +"' and t2.ToDate >= '"+ toDate +"') or ('"+ fromDate +"' between t2.FromDate and t2.ToDate) or ('"+ toDate +"' between FromDate and ToDate) or (t2.FromDate>='"+ fromDate +"' and '"+ toDate +"' >= t2.ToDate))"));
				BuildWorkArray(statement.executeQuery("select * from Vehicle join Suv using (Plate) join WorkCar using (Plate) where Rank = 'C' And Plate not in (Select LicensePlate from Invoice as t2 where (t2.FromDate<= '"+ fromDate +"' and t2.ToDate >= '"+ toDate +"') or ('"+ fromDate +"' between t2.FromDate and t2.ToDate) or ('"+ toDate +"' between FromDate and ToDate) or (t2.FromDate>='"+ fromDate +"' and '"+ toDate +"' >= t2.ToDate)) "));
			
				break;
			}
			case "D":
			{
				BuildLuxuryArray(statement.executeQuery("select * from Vehicle join Private using (Plate) join Luxury using (Plate) where Rank = 'D' And Plate not in (Select LicensePlate from Invoice as t2 where (t2.FromDate<= '"+ fromDate +"' and t2.ToDate >= '"+ toDate +"') or ('"+ fromDate +"' between t2.FromDate and t2.ToDate) or ('"+ toDate +"' between FromDate and ToDate) or (t2.FromDate>='"+ fromDate +"' and '"+ toDate +"' >= t2.ToDate))"));
				BuildAutonomousArray(statement.executeQuery("select * from Vehicle join Private using (Plate) join Autonomous using (Plate) where Rank = 'D' And Plate not in (Select LicensePlate from Invoice as t2 where (t2.FromDate<= '"+ fromDate +"' and t2.ToDate >= '"+ toDate +"') or ('"+ fromDate +"' between t2.FromDate and t2.ToDate) or ('"+ toDate +"' between FromDate and ToDate) or (t2.FromDate>='"+ fromDate +"' and '"+ toDate +"' >= t2.ToDate))"));
				break;
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return DataManager.getInstance().getM_Vehicles();
	}
	
	private void BuildCaravanArray(ResultSet resultset) {
		Vehicle vehicle;
		try {
			while (resultset.next())
			{
				vehicle = VehicleFactory.CreateVehicle("caravan");
				
				((Caravan)vehicle).setM_plate(resultset.getString("Plate"));
				((Caravan)vehicle).setM_EngineCC(Integer.parseInt(resultset.getString("EngineCC")));
				((Caravan)vehicle).setM_Doors(Integer.parseInt(resultset.getString("Doors")));
				((Caravan)vehicle).setM_Seats(Integer.parseInt(resultset.getString("Seats")));
				((Caravan)vehicle).setM_Laggage(Integer.parseInt(resultset.getString("Luggage")));
				((Caravan)vehicle).setM_Model(resultset.getString("Model"));
				((Caravan)vehicle).setM_Rank(Rank.valueOf(resultset.getString("Rank")));
				((Caravan)vehicle).setM_Gear(Gear.getGear(resultset.getInt("Gear")));
				((Caravan)vehicle).setM_Height(resultset.getInt("Height"));
				((Caravan)vehicle).setM_Tow(resultset.getBoolean("Tow"));
				((Caravan)vehicle).setM_Beds(resultset.getInt("Beds"));
				((Caravan)vehicle).setM_Shower(resultset.getBoolean("Shower"));
				((Caravan)vehicle).setM_Toilet(resultset.getBoolean("Toilet"));
				((Caravan)vehicle).setM_Kitchen(resultset.getBoolean("Kitchen"));
				((Caravan)vehicle).setM_Price(Integer.parseInt(resultset.getString("Price")));
				DataManager.getInstance().getM_Vehicles().put(vehicle.getM_Model(),vehicle);
			}
		} catch (SQLException e) {
            e.printStackTrace();
    	}
		
	}

	private void BuildAutonomousArray(ResultSet resultset) {
		Vehicle vehicle;
		try {
			while (resultset.next())
			{
				vehicle = VehicleFactory.CreateVehicle("autonomous");
				((AutonomousCar)vehicle).setM_plate(resultset.getString("Plate"));
				((AutonomousCar)vehicle).setM_EngineCC(Integer.parseInt(resultset.getString("EngineCC")));
				((AutonomousCar)vehicle).setM_Doors(Integer.parseInt(resultset.getString("Doors")));
				((AutonomousCar)vehicle).setM_Seats(Integer.parseInt(resultset.getString("Seats")));
				((AutonomousCar)vehicle).setM_Laggage(Integer.parseInt(resultset.getString("Luggage")));
				((AutonomousCar)vehicle).setM_Model(resultset.getString("Model"));
				((AutonomousCar)vehicle).setM_Rank(Rank.valueOf(resultset.getString("Rank")));
				((AutonomousCar)vehicle).setM_Gear(Gear.getGear(resultset.getInt("Gear")));
				((AutonomousCar)vehicle).setM_Hybrid(resultset.getBoolean("Hybrid"));
				((AutonomousCar)vehicle).setM_OS(OS.getOS(resultset.getString("OS")));
				((AutonomousCar)vehicle).setM_Price(Integer.parseInt(resultset.getString("Price")));
				DataManager.getInstance().getM_Vehicles().put(vehicle.getM_Model(),vehicle);
				
				
				
			}
		} catch (SQLException e) {
            e.printStackTrace();
    }
		
	}
	
	private void BuildFamilyArray(ResultSet resultset) 
	{
		Vehicle vehicle;
	    try {
	        while (resultset.next()) 
	        {       
	        	vehicle = VehicleFactory.CreateVehicle("family");
	        	
	        	((Family)vehicle).setM_plate(resultset.getString("Plate"));
				((Family)vehicle).setM_EngineCC(Integer.parseInt(resultset.getString("EngineCC")));
				((Family)vehicle).setM_Doors(Integer.parseInt(resultset.getString("Doors")));
				((Family)vehicle).setM_Seats(Integer.parseInt(resultset.getString("Seats")));
				((Family)vehicle).setM_Laggage(Integer.parseInt(resultset.getString("Luggage")));
				((Family)vehicle).setM_Model(resultset.getString("Model"));
				((Family)vehicle).setM_Rank(Rank.valueOf(resultset.getString("Rank")));
				((Family)vehicle).setM_Gear(Gear.getGear(resultset.getInt("Gear")));
				((Family)vehicle).setM_Hybrid(resultset.getBoolean("Hybrid"));
				((Family)vehicle).setM_Hatchback(resultset.getBoolean("Hatchback"));
				((Family)vehicle).setM_Price(Integer.parseInt(resultset.getString("Price")));
	        	DataManager.getInstance().getM_Vehicles().put(vehicle.getM_Model(),vehicle);
	        }
	    } catch (SQLException e) {
	            e.printStackTrace();
	    }
	        
	}
	
	private void BuildWorkArray(ResultSet resultset) 
	{
		Vehicle vehicle;
		try {
			while(resultset.next()) {
				vehicle = VehicleFactory.CreateVehicle("work");
				((WorkCar)vehicle).setM_plate(resultset.getString("Plate"));
				((WorkCar)vehicle).setM_EngineCC(Integer.parseInt(resultset.getString("EngineCC")));
				((WorkCar)vehicle).setM_Doors(Integer.parseInt(resultset.getString("Doors")));
				((WorkCar)vehicle).setM_Seats(Integer.parseInt(resultset.getString("Seats")));
				((WorkCar)vehicle).setM_Laggage(Integer.parseInt(resultset.getString("Luggage")));
				((WorkCar)vehicle).setM_Model(resultset.getString("Model"));
				((WorkCar)vehicle).setM_Rank(Rank.valueOf(resultset.getString("Rank")));
				((WorkCar)vehicle).setM_Gear(Gear.getGear(resultset.getInt("Gear")));
				((WorkCar)vehicle).setM_Height(resultset.getInt("Height"));
				((WorkCar)vehicle).setM_Tow(resultset.getBoolean("Tow"));
				((WorkCar)vehicle).setM_Dual(resultset.getBoolean("Dual"));
				((WorkCar)vehicle).setM_Price(Integer.parseInt(resultset.getString("Price")));
				DataManager.getInstance().getM_Vehicles().put(vehicle.getM_Model(),vehicle);
				
				
			}//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	   
	private void BuildJeepArray(ResultSet resultset)
	{	
		Vehicle vehicle;
		try {
			while(resultset.next()) {
				vehicle = VehicleFactory.CreateVehicle("jeep");
				((Jeep)vehicle).setM_plate(resultset.getString("Plate"));
				((Jeep)vehicle).setM_EngineCC(Integer.parseInt(resultset.getString("EngineCC")));
				((Jeep)vehicle).setM_Doors(Integer.parseInt(resultset.getString("Doors")));
				((Jeep)vehicle).setM_Seats(Integer.parseInt(resultset.getString("Seats")));
				((Jeep)vehicle).setM_Laggage(Integer.parseInt(resultset.getString("Luggage")));
				((Jeep)vehicle).setM_Model(resultset.getString("Model"));
				((Jeep)vehicle).setM_Rank(Rank.valueOf(resultset.getString("Rank")));
				((Jeep)vehicle).setM_Gear(Gear.getGear(resultset.getInt("Gear")));
				((Jeep)vehicle).setM_Height(resultset.getInt("Height"));
				((Jeep)vehicle).setM_Tow(resultset.getBoolean("Tow"));
				((Jeep)vehicle).setM_Dirt(resultset.getBoolean("Dirt"));
				((Jeep)vehicle).setM_Price(Integer.parseInt(resultset.getString("Price")));
				DataManager.getInstance().getM_Vehicles().put(vehicle.getM_Model(),vehicle);
			}//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void BuildLuxuryArray(ResultSet resultset)
	{
		Vehicle vehicle;
		try {
			while(resultset.next()) {
				vehicle = VehicleFactory.CreateVehicle("luxury");
				((Luxury)vehicle).setM_plate(resultset.getString("Plate"));
				((Luxury)vehicle).setM_EngineCC(Integer.parseInt(resultset.getString("EngineCC")));
				((Luxury)vehicle).setM_Doors(Integer.parseInt(resultset.getString("Doors")));
				((Luxury)vehicle).setM_Seats(Integer.parseInt(resultset.getString("Seats")));
				((Luxury)vehicle).setM_Laggage(Integer.parseInt(resultset.getString("Luggage")));
				((Luxury)vehicle).setM_Model(resultset.getString("Model"));
				((Luxury)vehicle).setM_Rank(Rank.valueOf(resultset.getString("Rank")));
				((Luxury)vehicle).setM_Gear(Gear.getGear(resultset.getInt("Gear")));
				((Luxury)vehicle).setM_Hybrid(resultset.getBoolean("Hybrid"));
				((Luxury)vehicle).setM_Panoramic(resultset.getBoolean("Panoramic"));
				((Luxury)vehicle).setM_Price(Integer.parseInt(resultset.getString("Price")));
	        	DataManager.getInstance().getM_Vehicles().put(vehicle.getM_Model(),vehicle);
			}//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected final Rank RankFilter()
	{
		return Rank.getRank(DataManager.getInstance().getM_Reserv().getM_CustomerAge(),
				DataManager.getInstance().getM_Reserv().getM_DriveXP());
	}
	
	protected final Vehicle FindSelectedCarDetails(String m_Model)
	{
		DataManager.getInstance().setM_SelectedVehicle(DataManager.getInstance().getM_Vehicles().get(m_Model));
		return DataManager.getInstance().getM_SelectedVehicle();
	}

	public boolean SetLoggedEmployee(Employee employee) {
		Statement statement = null;
		ResultSet resultset = null;
		
		
		if(employee == null)
		{
			DataManager.getInstance().setM_Employee(null);
			return false;
		}
		statement = createStatement();
		try {
			resultset = statement.executeQuery("select * from Employee where Username = '"+employee.getM_Username()+"'" + " and Password='"+employee.getM_Password()+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {	
				System.out.println(resultset.getString("Username"));
				DataManager.getInstance().setM_Employee(new Employee(resultset.getString("Username"),resultset.getString("Password")));
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				
			}
		}
		return false;
	}
	
	protected String getLoggedEmployee() {
		if(!(DataManager.getInstance().getM_Employee() == null))
			return DataManager.getInstance().getM_Employee().getM_Username();
		return null;
		
	}
	
	protected List<Insurance> PullInsurances()
	{
		
		Statement statement = null;
		ResultSet resultset = null;
		
		statement = createStatement();
		
		DataManager.getInstance().setM_SelectedInsurance(null);
		
		try {
			resultset = statement.executeQuery("select * from Insurance");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally
		{
			try {	
				while(resultset.next()) {
					DataManager.getInstance().getM_Insurances().add(new Insurance(resultset.getInt("DailyPrice"),resultset.getString("Title"),resultset.getString("Description")));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				
			}
		}
		return DataManager.getInstance().getM_Insurances();
	}
	
	public Statement createStatement()
	{
		Statement statement = null;
		try {
			statement = DataManager.getInstance().getM_SqlLink().getM_Connection().createStatement();
			//statement = DataManager.getInstance().getM_SqlLink().getM_Connection().prepareStatement(null,  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.TYPE_SCROLL_SENSITIVE);
			/*DataManager.getInstance().getM_SqlLink().getM_Connection().prepareStatement("select typeid from users where username=? and password=?",
			        ResultSet.TYPE_SCROLL_SENSITIVE, 
			    ResultSet.CONCUR_UPDATABLE);*/
			statement.setQueryTimeout(30);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return statement;
	}

	protected void SetSelectedInsurance(char selected) {
		switch(selected)
		{
		case 'A':
		{
			DataManager.getInstance().setM_SelectedInsurance(DataManager.getInstance().getM_Insurances().get(0));
			break;
		}
		case 'B':
		{
			DataManager.getInstance().setM_SelectedInsurance(DataManager.getInstance().getM_Insurances().get(1));
			break;
		}
		case 'C':
		{
			DataManager.getInstance().setM_SelectedInsurance(DataManager.getInstance().getM_Insurances().get(2));
			break;
		}
		}
	}

	protected void SetFirstDetails(Reservation reservation) {
		DataManager.getInstance().setM_Reserv(reservation);
		DataManager.getInstance().setM_SelectedVehicle(null);
	}

	public String SetFullDetails(Customer customer) {
		customer.setM_Age(DataManager.getInstance().getM_Reserv().getM_CustomerAge());
		customer.setM_DriveXP(DataManager.getInstance().getM_Reserv().getM_DriveXP());
		customer.setM_Rank(Rank.getRank(DataManager.getInstance().getM_Reserv().getM_CustomerAge(), DataManager.getInstance().getM_Reserv().getM_DriveXP()));
		DataManager.getInstance().setM_Customer(customer);	
		return SaveCustomer();
		
	}

	protected DefaultTableModel GetInvoices() {
			return getRelevantDefaultTableModel("select * from Invoice");
	}

	protected DefaultTableModel GetCompanyStock() {
		return getRelevantDefaultTableModel("select * from Vehicle");
	}
	
	protected DefaultTableModel GetCompanyCustomers() {
		return getRelevantDefaultTableModel("select * from Customer");
	}
	

	public DefaultTableModel GetCustomerHistory() {
		return getRelevantDefaultTableModel("SELECT Model,Plate,FromDate,ToDate,TOtalPrice,CreditNum FROM Invoice inner join Vehicle on Invoice.LicensePlate = Vehicle.Plate where Invoice.CustomerID = '"+DataManager.getInstance().getM_Customer().getM_ID()+"'");
	}

	private DefaultTableModel getRelevantDefaultTableModel(String query)
	{
		Statement statement = createStatement();
		ResultSet resultset = null;
		Vector<String> columnNames = new Vector<String>();
		
		try {
			resultset = statement.executeQuery(query);
			ResultSetMetaData metaData = resultset.getMetaData();
			for(int i=1;i<=metaData.getColumnCount();i++)
			{
				columnNames.add(metaData.getColumnName(i));
			}
			
			
			
			Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			int count;
			if(metaData.getColumnName(1).equalsIgnoreCase("count") && (count=resultset.getInt("count"))==0)
			{
				return null;
			}
			
			while (resultset.next()) {
			    Vector<Object> vector = new Vector<Object>();
			    for (int columnIndex = 1; columnIndex <= metaData.getColumnCount(); columnIndex++) {
			        vector.add(resultset.getObject(columnIndex));
			    }
			data.add(vector);
			}
			
			return new DefaultTableModel(data, columnNames) {
				public boolean isCellEditable(int row, int column)
			    {
			      return false; //This causes all cells to be not editable
			    }
			};
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	protected String SetReservDiscount(String discount) {
		int dis = Integer.parseUnsignedInt(discount);
		int totalprice = DataManager.getInstance().getM_Invoice().getM_TotalPrice();
		
		totalprice = totalprice - ((totalprice*dis)/100);
		DataManager.getInstance().getM_Invoice().setM_TotalPrice(totalprice);
		return String.format("%d", totalprice);
		
	}
	
	protected void setFinalPrice()
	{
		DataManager.getInstance().getM_Invoice().setM_TotalPrice(DataManager.getInstance().getM_SelectedVehicle().getM_Price()*(DataManager.getInstance().getM_Reserv().getM_End().compareTo(DataManager.getInstance().getM_Reserv().getM_Start())) + 
				DataManager.getInstance().getM_SelectedInsurance().getM_DailyPrice()*(DataManager.getInstance().getM_Reserv().getM_End().compareTo(DataManager.getInstance().getM_Reserv().getM_Start())));
	}
	
	protected Vehicle getSelectedVehicle() {
		return DataManager.getInstance().getM_SelectedVehicle();
	}

	protected Insurance getSelectedInsurance() {
		return DataManager.getInstance().getM_SelectedInsurance();
	}

	protected Reservation getReserv() {
		return DataManager.getInstance().getM_Reserv();
	}

	protected Customer getCustomer() {
		return DataManager.getInstance().getM_Customer();
	}

	protected int getFinalPrice() {
		return DataManager.getInstance().getM_Invoice().getM_TotalPrice();
	}

	protected void SetFinalInvoice(CreditCard m_CreditCard) {
		DataManager.getInstance().getM_Invoice().setM_InvoiceNum(getNextInvoiceNum());
		DataManager.getInstance().getM_Invoice().setM_Reserv(DataManager.getInstance().getM_Reserv());
		DataManager.getInstance().getM_Invoice().setM_Ioffer(DataManager.getInstance().getM_SelectedInsurance());
		DataManager.getInstance().getM_Invoice().setM_Vehicle(DataManager.getInstance().getM_SelectedVehicle());
		DataManager.getInstance().getM_Invoice().setM_Customer(DataManager.getInstance().getM_Customer());
		DataManager.getInstance().getM_Invoice().setM_CreditCard(m_CreditCard);

	}

	private final String SaveCustomer()
	{
		Statement statement = createStatement();
		try {
			
			String query = ("INSERT OR IGNORE into Customer VALUES('" + DataManager.getInstance().getM_Customer().getM_ID() + "','" + DataManager.getInstance().getM_Customer().getM_Name() + "'," + DataManager.getInstance().getM_Customer().getM_Age() + "," 
												+ DataManager.getInstance().getM_Customer().getM_DriveXP() + "," + "'"+(Rank.getRank(DataManager.getInstance().getM_Customer().getM_Age(), DataManager.getInstance().getM_Customer().getM_DriveXP())).toString()+"'" + ",'"
												+ DataManager.getInstance().getM_Customer().getM_Phone()+ "')");

			System.out.println(query);
			if(statement.executeUpdate(query)==0)
			{
				return new String("Returned customer");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			return e1.getMessage();
		}
		return new String("New customer");
	}

	protected final String SaveInvoice() {
		
		Statement statement = createStatement();
		ResultSet resultset = null;
		
		
		Invoice invoice = DataManager.getInstance().getM_Invoice();
	
		String fromDate = DataManager.getInstance().getM_Reserv().getM_Start();
		String toDate = DataManager.getInstance().getM_Reserv().getM_End();
		
		
		try {
			String query = ("INSERT INTO Invoice VALUES("+invoice.getM_InvoiceNum() + ",'" + invoice.getM_Customer().getM_ID() + "','" + invoice.getM_Ioffer().getM_Title() + "','"
					+ invoice.getM_Vehicle().getM_plate() + "','" + fromDate + "','" + toDate+"'," + invoice.getM_TotalPrice() + ",'" + invoice.getM_CreditCard().getM_CreditType().name() + "','" + invoice.getM_CreditCard().getM_Digits() + "','"
					+ invoice.getM_CreditCard().getM_ExpireDate() + "')");
			System.out.println(query);
			try {
				statement.executeUpdate(query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NullPointerException e) {
			return e.getMessage();
			
		}
		return "Successfully created";
		
		
	}

	private int getNextInvoiceNum() {
		Statement statement = createStatement();
		ResultSet resultset = null;
		
		try {
			resultset = statement.executeQuery("select max(Invoice.InvoiceNum) from Invoice");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			return resultset.getInt("max(Invoice.InvoiceNum)")+1;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return 0;
		}
	}

	protected void DeleteCustomer(String selectedCustomerID) {
		Statement statement = createStatement();
		String query = "DELETE FROM Customer where Customer.ID = '"+selectedCustomerID+"'";
		
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected Invoice GetFinalInvoice() {
		return (DataManager.getInstance().getM_Invoice() == null) ? null : DataManager.getInstance().getM_Invoice();
	}

	public Customer findCustomer(String customer) {
		if(customer == null)
			return null;
		
		Statement statement = createStatement();
		ResultSet resultset = null;
		String query = "SELECT * FROM Customer where Customer.ID = '"+customer+"' OR Customer.Phone='"+customer+"'";
		
		try {
			resultset = statement.executeQuery(query);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		Customer c = null;
		try {
			while (resultset.next()) {
			c = new Customer(
					resultset.getString("ID"),
					resultset.getString("Name"),
					resultset.getInt("Age"),
					resultset.getInt("DriveXP"),
					Rank.valueOf(resultset.getString("Rank")),
					resultset.getString("Phone")
					);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 DataManager.getInstance().setM_Customer(c);
		
		
		return c;
		
	}

	


}
