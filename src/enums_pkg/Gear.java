package enums_pkg;

public enum Gear {
	MANUAL,AUTO;
	Gear()
	{
		
	}
	
	public static Gear getGear(int gear)
	{
		if(gear==1)
		{
			return AUTO;
		}
		
		return MANUAL;
	}
}
