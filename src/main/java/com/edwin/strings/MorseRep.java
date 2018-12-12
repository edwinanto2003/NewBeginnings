package com.edwin.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-morse-code-words/description/
 * 
 * @author edwinanto
 *
 */
public class MorseRep {

	public int uniqueMorseRepresentations(String[] words) 
	{
		Map<Character, String> morseMap = new HashMap<Character, String>();
		int start = 'a';
		String[] morseRep = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

		for (int i = start; i < start + 26; i++)
			morseMap.put((char)i, morseRep[i - 'a']);

		Set<String> uniqueSet = new HashSet<String>();

		for (String word : words)
		{
			StringBuilder morse = new StringBuilder();
			for (int i = 0; i < word.length(); i++)
			{
				morse.append(morseMap.get(word.charAt(i)));
			}
			uniqueSet.add(morse.toString());
		}

		return uniqueSet.size();
	}
	
	public int uniqueMorseRepresentationsBETTER(String[] words) 
	{	
		String[] morseRep = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

		Set<String> uniqueSet = new HashSet<String>();

		for (String word : words)
		{
			StringBuilder morse = new StringBuilder();
			for (int i = 0; i < word.length(); i++)
			{
				morse.append(morseRep['a' - word.charAt(i)]);
			}
			uniqueSet.add(morse.toString());
		}

		return uniqueSet.size();
	}

	public static void main (String[] args)
	{
		MorseRep mr = new MorseRep();
		System.out.println(mr.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
	}

}


