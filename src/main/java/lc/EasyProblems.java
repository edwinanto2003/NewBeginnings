package lc;

import trial.LinkedListImpl;
import trial.Node;

public class EasyProblems
{
    public int lengthOfLastWord(String s) 
    {
    if (s == null || s.length() ==0)
        return 0;
        
     String[] words = s.split("[^a-zA-Z0-9']+");
     
     if (words.length ==0)
    	 return 0;
     
     return words[words.length -1].length();
    }

	private LinkedListImpl createLL()
	{
		LinkedListImpl ll = new LinkedListImpl();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(1);
		ll.print();	

		return ll;
	}
	
	private void remove(LinkedListImpl ll, int val)
	{
		ll.remove(val);
		ll.print();
	}

	private void testLL()
	{
		LinkedListImpl ll = createLL();

		System.out.println("Is it a palindrome? " + ll.checkIfPalindrome());
		remove(ll, 2);
		System.out.println("Is it a palindrome? " + ll.checkIfPalindrome());
	}
	public static void main(String[] args)
	{
		EasyProblems ep = new EasyProblems();
		
		//1. lengthOfLastWord
	//	System.out.println(ep.lengthOfLastWord(" "));
		
		//2. create linkedlist
		ep.testLL();
	}

}
