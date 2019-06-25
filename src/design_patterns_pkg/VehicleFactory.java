package design_patterns_pkg;

import vehicle_pkg.AutonomousCar;
import vehicle_pkg.Caravan;
import vehicle_pkg.Family;
import vehicle_pkg.Jeep;
import vehicle_pkg.Luxury;
import vehicle_pkg.Vehicle;
import vehicle_pkg.WorkCar;

public class VehicleFactory {
	
	public VehicleFactory()
	{
		
	}
	
	public static Vehicle CreateVehicle(String type)
	{
		if(type.equalsIgnoreCase("autonomous"))
		{
			return new AutonomousCar();
		}
		else if(type.equalsIgnoreCase("caravan")) {
			return new Caravan();
		}
		else if(type.equalsIgnoreCase("family")) {
			return new Family();
		}
		else if(type.equalsIgnoreCase("jeep")) {
			return new Jeep();
		}
		else if(type.equalsIgnoreCase("work")) {
			return new WorkCar();
		}
		else if(type.equalsIgnoreCase("luxury")) {
			return new Luxury();
		}
		return null;
	}
}
