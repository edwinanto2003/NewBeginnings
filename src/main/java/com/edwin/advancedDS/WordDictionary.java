package com.edwin.advancedDS;

class WordDictionary {

	public class TrieNode
	{
		char c;
		boolean complete;

		TrieNode[] children = new TrieNode[26];        
	}

	TrieNode root = null;

	/** Initialize your data structure here. */
	public WordDictionary() 
	{
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) 
	{
		TrieNode temp = root;        

		for (int i = 0 ; i < word.length(); i++)
		{
			int index = (int) word.charAt(i) - 'a';

			if (temp.children[index] == null)
			{
				TrieNode t = new TrieNode();
				t.c = word.charAt(i);
				temp.children[index] = t;
			}
			temp = temp.children[index];
		}

		temp.complete = true;		
	}

	public boolean search(String word) 
	{
		return search(root, word, 0);
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(TrieNode node, String word, int index) 
	{
		if (node.complete && index == word.length())
			return true;

		if(index >= word.length())
			return false;

		char c = word.charAt(index);

		if (c =='.')
		{
			for (TrieNode child : node.children)
			{
				if (node !=null && search(child, word, index+1))
				{
					return true;
				}
			}
		}else
		{
			int idx = word.charAt(index) - 'a';

			if (node.children[idx] == null)
				return false;

			return search(node.children[idx], word, index +1);
		}

		return false;
	}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

public static void main(String[] args)
{

	 WordDictionary obj = new WordDictionary();
	 obj.addWord("add");
	 boolean param_2 = obj.search("add");
	 System.out.println(param_2);
}
}