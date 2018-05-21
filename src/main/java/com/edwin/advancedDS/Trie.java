package com.edwin.advancedDS;

import java.util.ArrayList;
import java.util.List;

public class Trie
{
	TrieNode root;

	public Trie()
	{
		root = new TrieNode();
	}

	public TrieNode getRoot()
	{
		return root;
	}

	public List<String> printDFS()
	{
		StringBuilder sb = new StringBuilder();
		List<String> paths = new ArrayList<String>();
		printDFS(root, sb, paths);
		return paths;
	}

	private void printDFS(TrieNode node, StringBuilder path, List<String> paths)
	{
		if (node == null)
			return;

		int len = path.length();

		if (node.complete)
		{
			path.append(node.c);
			paths.add(path.toString());
			path.delete(len, path.length());
		}
		path.append(node.c);
		for (TrieNode child : node.children)
		{
			printDFS(child, path, paths);
		}

		path.delete(len, path.length());

	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one
	 * letter.
	 */
	public boolean searchWC(String word)
	{
		return searchWC(root, word, 0);
	}

	private boolean searchWC(TrieNode node, String word, int index)
	{
		if (node.complete && index == word.length())
			return true;

		if (index >= word.length())
			return false;

		char c = word.charAt(index);

		if (c == '.')
		{
			for (TrieNode child : node.children)
			{
				if (child != null)
				{
					if (searchWC(child, word, index + 1))
					{
						return true;
					}				
				}
			}
		}
		else
		{
			int charIndex = c - 'a';
			if (node.children[charIndex] == null)
				return false;
			else
				return searchWC(node.children[charIndex], word, index + 1);
		}
		return false;
	}

	/**
	 * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one
	 * letter.
	 */
	public boolean search(String word)
	{
		TrieNode temp = root;

		for (int i = 0; i < word.length(); i++)
		{
			int index = (int) word.charAt(i) - 'a';
			if (temp.children[index] == null)
				return false;

			temp = temp.children[index];
		}

		if (temp.complete)
			return true;

		return false;
	}

	public void add(String word)
	{
		TrieNode temp = root;

		for (int i = 0; i < word.length(); i++)
		{
			int index = (int) word.charAt(i) - 'a';

			if (temp.children[index] == null)
			{
				TrieNode t = new TrieNode(word.charAt(i));
				temp.children[index] = t;
			}
			temp = temp.children[index];
		}

		temp.complete = true;
	}

}
