package trial;

import java.util.ArrayList;
import java.util.List;

public class EnumTest
{
	
	static ForecastStatus forecastStatus;
	
	static StatusEnum statusEnum;
	
	public enum ForecastStatus
	{
		UNKNOWN, VALID, NOTVALID, SUBSTANDARD, EXTRANEOUS, EXCEPTION
	}
	
	public enum StatusEnum
	{
		UNKNOWN("UNKNOWN"),

		VALID("VALID"),

		NOT_VALID("NOT_VALID"),

		SUBSTANDARD("SUBSTANDARD"),

		EXTRANEOUS("EXTRANEOUS"),

		EXCEPTION("EXCEPTION");

		private String value;

		StatusEnum(String value)
		{
			this.value = value;
		}

		@Override
		public String toString()
		{
			return value;
		}

		public static StatusEnum fromValue(String text)
		{
			for (StatusEnum b : StatusEnum.values())
			{
				if (text.equals(b.value))
				{
					return b;
				}
			}
			return null;
		}
	}
	
	
	public static void setEnum()
	{
		forecastStatus = ForecastStatus.VALID;
		
		statusEnum = StatusEnum.fromValue(forecastStatus.toString());
		
		System.out.println(statusEnum);
	}
	
	public static void main(String[] args)
	{
		setEnum();
		
		List<String> vals = new ArrayList<String>();
		
		for (String val : vals)
		{
			System.out.println(val);
		}
		
		vals = null;
		
		for (String val : vals)
		{
			System.out.println();
		}
		
		
				

	}

}
