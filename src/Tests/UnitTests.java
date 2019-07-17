package Tests;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import design_patterns_pkg.DataManager;
import design_patterns_pkg.ModelDesign;
import design_patterns_pkg.VehicleFactory;
import enums_pkg.Credit;
import enums_pkg.Rank;
import person_pkg.Customer;
import person_pkg.Employee;
import regex_pkg.RegexChecker;
import reserv_pkg.Reservation;
import vehicle_pkg.AutonomousCar;
import vehicle_pkg.Vehicle;

public class UnitTests {
	private DataManager dm;
	private ModelDesign model;
	
	@BeforeEach
	public void setUp()
	{
		dm = DataManager.getInstance();
		model = new ModelDesign();
		Random r = new Random();
		Calendar c = Calendar.getInstance();
		Date dStart = new Date();
		Date dEnd = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(new Date());
		c.add(Calendar.YEAR,1);
		c.add(Calendar.DATE, r.nextInt(30)%30);
		c.add(Calendar.MONTH,r.nextInt(13)%12);
		dStart = c.getTime();
		
		c.add(Calendar.DATE, 1);
		dEnd = c.getTime();
		dm.setM_Reserv(new Reservation(sdf.format(dStart),sdf.format(dEnd), r.nextInt(10)+25, r.nextInt(6)+1));
	}
	@Test
	public void TestCustomerInsert()
	{
		String msg = model.SetFullDetails(new Customer("999999999","test",dm.getM_Reserv().getM_CustomerAge(),dm.getM_Reserv().getM_DriveXP(),Rank.getRank(dm.getM_Reserv().getM_CustomerAge(),dm.getM_Reserv().getM_DriveXP()),"999999999"));
		assertEquals("New customer",msg);
	}
	
	@Test
	public void TestCustomerInsertExist()
	{
		String msg = model.SetFullDetails(new Customer("111111111","TEST",dm.getM_Reserv().getM_CustomerAge(),dm.getM_Reserv().getM_DriveXP(),Rank.getRank(dm.getM_Reserv().getM_CustomerAge(),dm.getM_Reserv().getM_DriveXP()),"999999999"));
		assertEquals("Returned customer",msg);
	}
	
	@Test
	public void TestValidPhoneRegex()
	{
		String phone = "052-5202123";
		assertEquals(true,RegexChecker.checkPhoneNumber(phone));
	}
	
	@Test
	public void TestInvalidPhoneRegex()
	{
		String phone = "059-9911199";
		assertEquals(false,RegexChecker.checkPhoneNumber(phone));
	}
	
	
	@Test
	public void TestCreditRegex()
	{
		String creditnum = "4580-2313-3255-9999";
		assertEquals(Credit.VISA,RegexChecker.checkCreditType(creditnum));
	}
	
	@Test 
	public void TestInvalidCredit()
	{
		String creditnum = "1111-2222-3333-4444";
		assertEquals(null,RegexChecker.checkCreditType(creditnum));
	}
	
	@Test
	public void TestLettersRegex()
	{
		String letters = "abcdefg";
		assertEquals(true,RegexChecker.checkOnlyLetters(letters));
	}
	
	@Test
	public void TestInvalidLettersRegex()
	{
		String letters = "abcde-^$fg";
		assertEquals(false,RegexChecker.checkOnlyLetters(letters));
	}
	@Test
	public void TestNumbersRegex()
	{
		String numbers = "12345";
		assertEquals(true,RegexChecker.checkOnlyNumbers(numbers));
	}
	
	
	@Test
	public void TestInvalidNumbersRegex()
	{
		String numbers = "12-23345";
		assertEquals(false,RegexChecker.checkOnlyNumbers(numbers));
	}
	@Test
	public void TestFactoryMethod()
	{
		assertEquals(AutonomousCar.class,VehicleFactory.CreateVehicle("autonomous").getClass());
	}
	
	@Test
	public void TestInvalidFactoryMethod()
	{
		assertEquals(null,VehicleFactory.CreateVehicle("none"));
	}
	
	@Test
	public void TestUserLogin()
	{
		Employee emp = new Employee("ishaiy","12345");
		
		assertEquals(true,model.SetLoggedEmployee(emp));
	}
	
	
	//make test for removing customers
	
	@AfterEach
	public void tearDown()
	{
		dm.setM_Reserv(null);
		Statement statement = model.createStatement();
		String deleteTestCustomer = "DELETE FROM Customer where Customer.ID = '999999999'";
		DataManager.getInstance().setM_Employee(null);
		try {
			statement.executeUpdate(deleteTestCustomer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
