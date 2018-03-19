package lc;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels
{

	private String reverseVowels(String s)
	{
		char[] sCharArr = s.toCharArray();
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int i = 0, j = sCharArr.length - 1;
        
        while(i < j)
        {
        	if (!vowels.contains(sCharArr[i]))
        		i++;
        	if (!vowels.contains(sCharArr[j]))
        		j--;
        	
            if (vowels.contains(sCharArr[i])  && vowels.contains(sCharArr[j]))
            {
                sCharArr[i]^=sCharArr[j];
                sCharArr[j]^=sCharArr[i];
                sCharArr[i]^=sCharArr[j];
                i++;
                j--;
            }
        }
        return new String(sCharArr);
	}
	
	public static void main(String[] args)
	{
		ReverseVowels r = new ReverseVowels();
		
		System.out.println(r.reverseVowels("a."));

	}

}
