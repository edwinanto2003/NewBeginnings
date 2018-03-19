package trial;

import java.util.ArrayList;
import java.util.List;

public class EqualsCheck
{

	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		list.add("231");
		list.add("31");
		list.add("21");
		list.add("1");
		list.add("23");

		StringBuilder sb = new StringBuilder();
		for (String s : list)
		{
			sb.append(s);
			sb.append(",");
		}
		
		System.out.println(sb.length());
		System.out.println(sb.charAt(sb.length() -1));
		sb.delete(sb.length() -1, sb.length());
		System.out.println(sb.toString());
	}

}
