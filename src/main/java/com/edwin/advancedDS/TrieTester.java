package com.edwin.advancedDS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TrieTester
{

	public static void main(String[] args)
	{
		Trie t = new Trie();

		 String s = "This site uses cookies to personnalize content and ads, to enable sharing on social media, and to analyze traffic. Data on site use is also shared with our social network, ads and traffic analysis partners, who can combine this data with other data you supplied them or that they collect when you use their services.";

//		String path = "/Users/hm/Documents/sample.txt";
//		StringBuilder sb = null;
//		try
//		{
//			FileReader fr = new FileReader(new File(path));
//
//			BufferedReader br = new BufferedReader(fr);
//			String line;
//
//			sb = new StringBuilder();
//			while ((line = br.readLine()) != null)
//			{
//				sb.append(line);
//			}
//
//			br.close();
//			fr.close();
//		}
//		catch (IOException e)
//		{
//			System.out.println(e.getMessage());
//		}

		String[] words = s.toLowerCase().replaceAll("^[,.0-9\\s]+", "").split("[,.\\s]+");
	//	String[] words = sb.toString().toLowerCase().replaceAll("[^a-zA-Z]", "").split("[,.\\s]+");

		for (String str : words)
		{
			t.add(str);
		}

		//
		// t.add("cat");
		// t.add("cot");
		// t.add("cats");
		// t.add("bat");
		// t.add("bats");
		// t.add("edwin");
		//

		List<String> allwords = t.printDFS();
		System.out.println(allwords);

		System.out.println(t.searchWC(".d."));
	}

}
