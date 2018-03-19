package ctCi;

import java.util.*;

public class Ransom {
	Map<String, Integer> magazineMap;
	String[] magazineWords; 
	String[] noteWords;

	public Ransom(String magazine, String note) {
		magazineWords = magazine.split("\\W+");
		noteWords = note.split("\\W+");

		magazineMap = new HashMap<String, Integer>();
	}

	public boolean solve() 
	{

		for (String word : magazineWords)
		{
			if (magazineMap.containsKey(word))
				magazineMap.put(word, magazineMap.get(word) + 1);
			else
				magazineMap.put(word, 1);            
		}

		for (String word : noteWords)
		{
			if(magazineMap.containsKey(word))
			{
				int numberOfWords = magazineMap.get(word);
				if (numberOfWords == 1)
				{
					magazineMap.remove(word);
				}
				else
				{				
					magazineMap.put(word, numberOfWords - 1);   
				}
			}
			else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();

		// Eat whitespace to beginning of next line
		scanner.nextLine();

		Ransom s = new Ransom(scanner.nextLine(), scanner.nextLine());
		scanner.close();

		boolean answer = s.solve();
		if(answer)
			System.out.println("Yes");
		else System.out.println("No");

	}
}
