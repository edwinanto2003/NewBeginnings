package trial;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Contains
{
	static String basePath = "/Users/hm/Desktop/temp/compare/";

	public void comp() throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File(basePath + "actualRule.txt"));

		StringBuilder sb = new StringBuilder();
		while (sc.hasNextLine())
		{
			sb.append(sc.nextLine());
		}

		String actualDTAPrule = sb.toString();

		sc = new Scanner(new File(basePath + "expectedRule.txt"));

		sb = new StringBuilder();

		while (sc.hasNextLine())
		{
			sb.append(sc.nextLine());
			sb.append("/n");
		}

		String expectedDTAPrule = sb.toString();

		System.out.println(actualDTAPrule);

		System.out.println(expectedDTAPrule);
		
		System.out.println(actualDTAPrule.contains(expectedDTAPrule));
	}

	public static void main(String[] args) 
	{
		Contains c = new Contains();
		try
		{
			c.comp();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
