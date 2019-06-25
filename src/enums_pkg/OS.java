package enums_pkg;

public enum OS  {
	WINDOWS,UNIX,MACOS;
	
	OS()
	{
	}
	
	public static OS getOS(String os)
	{
		if(os.contentEquals("Windows"))
		{
			return WINDOWS;
		} else if (os.contentEquals("Linux")) {
			return UNIX;
		} else {
			return MACOS;
		}
	}
	
}
