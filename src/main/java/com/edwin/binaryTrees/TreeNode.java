package com.edwin.binaryTrees;


/*
 * Node in the tree
 */
public class TreeNode
{
	int value;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int value)
	{
		this.value = value;
		left = right = null;
	}
}
