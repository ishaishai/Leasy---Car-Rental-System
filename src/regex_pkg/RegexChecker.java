package regex_pkg;

import enums_pkg.Credit;

public class RegexChecker {
	
	public static Credit checkCreditType(String credit)
	{
		String card = credit.replaceAll("[ -]+", "");
		
		if(card.matches("^4[0-9]{12}(?:[0-9]{3})?$"))
		{
			return Credit.VISA;
		}
		else if(card.matches("^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$"))
		{
			return Credit.MASTERCARD;
		}
		else if(card.matches("^3[47][0-9]{13}$"))
		{
			return Credit.AMEX;
		}
		return null;
	}
	
	public static boolean checkPhoneNumber(String phone)
	{
		if(!(phone.matches("^0([2-4|8]|[7][6|7])-[0-9]{7}$")) && !(phone.matches("^05[0|4|2|8]-[2-8][0-9]{6}$")))
		{
			return false;
		}
		return true;
	}
	
	public static boolean checkOnlyLetters(String string)
	{
		if(!(string.matches("^[a-zA-Z]+$")))
		{
			return false;
		}
		return true;
	}
	
	public static boolean checkOnlyNumbers(String string)
	{
		if(!(string.matches("^[0-9]+$")))
		{
			return false;
		}
		return true;
	}
	
	
	
}
