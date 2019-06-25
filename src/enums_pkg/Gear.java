package enums_pkg;

public enum Gear {
	MANUAL,AUTO;
	Gear()
	{
		
	}
	
	public static Gear getGear(String gear)
	{
		if(gear.contentEquals("AUTO"))
		{
			return AUTO;
		}
		
		return MANUAL;
	}
}
