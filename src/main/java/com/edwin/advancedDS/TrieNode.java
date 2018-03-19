package com.edwin.advancedDS;

public class TrieNode
{
	char c;
	
	TrieNode[] children = new TrieNode[26];
	
	boolean complete;
	
	public TrieNode()
	{}
	

	public TrieNode(char c)
	{
		this.c = c;
	}
}
