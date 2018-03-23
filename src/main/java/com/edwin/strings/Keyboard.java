package com.edwin.strings;

import java.util.HashMap;
import java.util.Map;

public class Keyboard
{
    public String[] findWords(String[] words) 
    {
        if (words == null || words.length == 0)
            return words;
        
        StringBuilder wb = new StringBuilder();
       
        String kb = "QWERTYUIOP ASDFGHJKL ZXCVBNM";
        
        Map<Character, Integer> wm = new HashMap<Character, Integer>();
        
        int index = 1;
        for (int i = 0; i < kb.length(); i++)
        {
            if(kb.charAt(i) == ' ')
                index++;
            wm.put(kb.charAt(i), index);
        }
        
        for (String word : words)
        {
            Character c = word.charAt(0);
            c = Character.toUpperCase(c);
            int idx = wm.get(c);
            boolean sameRow = true;
            for(int i = 1; i < word.length(); i++)
            {
                c = word.charAt(i);
                c = Character.toUpperCase(c);
                if(wm.get(c) != idx)
                   {
                       sameRow = false;
                       break;
                   }
            }
            if (sameRow)
            {
                wb.append(word);
                wb.append(' '); 
            }
        }
        if(wb.length() > 0)
            wb.deleteCharAt(wb.length() - 1);
        
        return wb.toString().split(" ");
    }
    
	public static void main(String[] args)
	{
		Keyboard kb = new Keyboard();
		String[] words = {"asdfghjklASDFGHJKLasdfghjklASDFGHJKLzxcvbnmZXCVBNMaew","asdfghjklASDFGHJKLqwertyuiopQWERTYUIOP","zxcvbnmZXCVBNMaewzxcvbnmZXCVBNMaewzxcvbnmZXCVBNMaewzxcvbnmZXCVBNMaew"};
		String[] result = kb.findWords(words);
		System.out.println(result);

	}

}
