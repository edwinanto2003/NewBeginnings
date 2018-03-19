package com.edwin.binaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree
{
	TreeNode root;

	// create tree with root. 
	public BinarySearchTree(int val)
	{		
		root = new TreeNode(val);
	}

	public BinarySearchTree()
	{
	}
	
	public void bfs(TreeNode node)
	{
		if (node == null)
			return;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(node);
		
		while (!q.isEmpty())
		{
			TreeNode u = q.remove();
			
			if (u.left != null)
				q.add(u.left);
			if (u.right!= null)
				q.add(u.right);
				
			System.out.print(u.value + " ");
		}		
	}
	
	public List<Integer> minMaxAtEachLevel(TreeNode root)
	{
		List<Integer> result = new ArrayList<Integer>();
		
		if (root == null)
			return result;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(root);
		
		int level = 1;
		while(!q.isEmpty())
		{
			int nodeCount = q.size();
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			while (nodeCount > 0)
			{
				TreeNode u = q.remove();
				
				if(level % 2 != 0)   // return min at this level
					min = u.value < min ? u.value : min;
				else
					max = u.value > max ? u.value : max; 	// return max at even level
					
				if (u.left!=null) q.add(u.left);
				if (u.right!=null) q.add(u.right);
				
				nodeCount--;
			}
			if(level % 2 != 0)
				result.add(min);
			else
				result.add(max);
			
			level++;
		}	
		
		return result;		
	}
	
	public void printBFSseparateLine(TreeNode node)
	{
		if (node == null)
			return;
				
		Queue<TreeNode> q = new LinkedList<TreeNode>();		
		q.add(node);
		
		int levelNodes = 0;
		
		while(!q.isEmpty())
		{
			levelNodes = q.size();
			
			while (levelNodes > 0)
			{
				TreeNode u = q.remove();
				if (u.left != null)
					q.add(u.left);
				if (u.right!= null)
					q.add(u.right);
					
				System.out.print(u.value + " ");		
				levelNodes--;
			}
			
			System.out.println();
		}
		
	}
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<List<Integer>>();
        levelOrderBottom(root, 0, levels);
        return levels;
    }
   
    private void levelOrderBottom(TreeNode node, int level, List<List<Integer>> levels) {
        if (node == null)
            return;        
       
        if (level >= levels.size()) {
            levels.add(new ArrayList<Integer>());
        }
       
        List<Integer> currLevel = levels.get(level);
        currLevel.add(node.value);
        levelOrderBottom(node.left, level + 1, levels);
        levelOrderBottom(node.right, level + 1, levels);
    }
	
	
	public void printInorder(TreeNode node)
	{
		if (node == null)
			return;
		
		printInorder(node.left);
		System.out.print(node.value+ " ");
		printInorder(node.right);
		
	}

	public void insertIter(int val)
	{
		if (root == null)
		{
			root = new TreeNode(val);
			return;
		}
		
		TreeNode temp = root;
		TreeNode parent = null;
		while (temp != null)
		{
			parent = temp;
			if (val < temp.value)
				temp = temp.left;
			else
				temp = temp.right;
		}
		
		if (val < parent.value)
			parent.left = new TreeNode(val);
		else
			parent.right = new TreeNode(val);
	}


	public void insertRecur(int val)
	{
		root = insertRecur(root, val);
	}
	
	public TreeNode insertRecur(TreeNode node, int val)
	{
		if (node == null)
			return new TreeNode(val);
		
		if (val < node.value)
			node.left = insertRecur(node.left, val);
		else
			node.right = insertRecur(node.right, val);
		
		return node;
	}

}
