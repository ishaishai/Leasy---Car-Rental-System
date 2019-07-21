package enums_pkg;

public enum Rank {
	A,B,C,D;
	Rank()
	{
		
	}
	
	public static Rank getRank(int Age,int DriveXP)
	{
		if(Age>=24)
		{
			if(DriveXP>=6)
			{
				return D;
			}
			return C;
		}
		else if(Age<24 && DriveXP>=2)
		{
			return B;
		}
		return A;
	}
	
	public static String toString(Rank rank)
	{
		return (rank==A) ? "A" : (rank==B) ? "B" : (rank==C) ? "C" : "D";
	}
	
	
}
