package com.edwin.binaryTrees;

import java.util.ArrayList;
import java.util.List;

/**
 * Properties of binary are discussed.
 * 
 * 
 * 1) The maximum number of nodes at level ‘l’ of a binary tree is 2l-1. Here level is number of nodes on path from root
 * to the node (including root and node). Level of root is 1. This can be proved by induction. For root, l = 1, number
 * of nodes = 21-1 = 1 Assume that maximum number of nodes on level l is 2l-1 Since in Binary tree every node has at
 * most 2 children, next level would have twice nodes, i.e. 2 * 2l-1
 * 
 * 
 * 2) Maximum number of nodes in a binary tree of height ‘h’ is 2h – 1. Here height of a tree is maximum number of nodes
 * on root to leaf path. Height of a tree with single node is considered as 1. This result can be derived from point 2
 * above. A tree has maximum nodes if all levels have maximum nodes. So maximum number of nodes in a binary tree of
 * height h is 1 + 2 + 4 + .. + 2h-1. This is a simple geometric series with h terms and sum of this series is 2h – 1.
 * In some books, height of a leaf is considered as 0. In this convention, the above formula becomes 2h+1 – 1
 * 
 * 
 * 3) In a Binary Tree with N nodes, minimum possible height or minimum number of levels is ⌈ Log2(N+1) ⌉ This can be
 * directly derived from point 2 above. If we consider the convention where height of a leaf node is considered as 0,
 * then above formula for minimum possible height becomes ⌈ Log2(N+1) ⌉ – 1
 * 
 * 
 * 4) A Binary Tree with L leaves has at least ⌈ Log2L ⌉ + 1 levels A Binary tree has maximum number of leaves (and
 * minimum number of levels) when all levels are fully filled. Let all leaves be at level l, then below is true for
 * number of leaves L.
 * 
 * 		L <= 2l-1 [From Point 1] 
 * 		l = ⌈ Log2L ⌉ + 1 				where l is the minimum number of levels.
 * 
 * 5) In Binary tree, number of leaf nodes is always one more than nodes with two children.
 * 
 * 		L = T + 1 Where L = Number of leaf nodes 
 * 						T = Number of internal nodes with two children
 * 
 * 
 * 
 * 
 * 
 * Following are common types of Binary Trees.

 *	Full Binary Tree A Binary Tree is full if every node has 0 or 2 children. Following are examples of full binary tree. 
 *	We can also say a full binary tree is a binary tree in which all nodes except leaves have two children.

	               18
	           /       \  
	         15         30  
	        /  \        /  \
	      40    50    100   40

	             18
	           /    \   
	         15     20    
	        /  \       
	      40    50   
	    /   \
	   30   50

	               18
	            /     \  
	          40       30  
	                   /  \
	                 100   40
 *	In a Full Binary, number of leaf nodes is number of internal nodes plus 1
	       L = I + 1
 *	Where L = Number of leaf nodes, I = Number of internal nodes
 *	See Handshaking Lemma and Tree for proof.



 *	Complete Binary Tree: A Binary Tree is complete Binary Tree if all levels are completely filled except possibly the last level 
 *	and the last level has all keys as left as possible

 *	Following are examples of Complete Binary Trees

	               18
	           /       \  
	         15         30  
	        /  \        /  \
	      40    50    100   40


	               18
	           /       \  
	         15         30  
	        /  \        /  \
	      40    50    100   40
	     /  \   /
	    8   7  9 
 *	Practical example of Complete Binary Tree is Binary Heap.



 *	Perfect Binary Tree A Binary tree is Perfect Binary Tree in which all internal nodes have two children and all leaves are at same level.
 *	Following are examples of Perfect Binaryr Trees.

	               18
	           /       \  
	         15         30  
	        /  \        /  \
	      40    50    100   40


	               18
	           /       \  
	         15         30  
 *	A Perfect Binary Tree of height h (where height is number of nodes on path from root to leaf) has 2h – 1 node.

 *	Example of Perfect binary tree is ancestors in family. Keep a person at root, parents as children, parents of parents as their children.



 *	Balanced Binary Tree
 *	A binary tree is balanced if height of the tree is O(Log n) where n is number of nodes. 
 *	For Example, AVL tree maintain O(Log n) height by making sure that the difference between heights 
 *	of left and right subtrees is 1. Red-Black trees maintain O(Log n) height by making sure that the number 
 *	of Black nodes on every root to leaf paths are same and there are no adjacent red nodes. 
 *	Balanced Binary Search trees are performance wise good as they provide O(log n) time for search, insert and delete.



 *	A degenerate (or pathological) tree A Tree where every internal node has one child. Such trees are performance-wise same as linked list.

	      10
	      /
	    20
	     \
	     30
	      \
	      40     
 * 
 * 
 * @author Edwin Anto
 */
public class BinaryTree
{
	TreeNode root;
	public BinaryTree()
	{}
	public BinaryTree(int val)
	{
		if (root == null)
		{
			root = new TreeNode(val);
			return;
		}
	}

	public TreeNode getRoot()
	{
		return root;
	}

	public void insertLeft(TreeNode node, int val)
	{
		if (node == null)
			node = new TreeNode(val);
		else
			node.left = new TreeNode(val);
	}

	public void insertRight(TreeNode node, int val)
	{
		if (node == null)
			node = new TreeNode(val);
		else
			node.right = new TreeNode(val);
	}
	
	public int pathSum(TreeNode node)
	{		
		return pathSum(node, 0);		
	}


	private int pathSum(TreeNode node, int sum)
	{
		if (node == null)
			return 0;
		
		if (node.left == null & node.right == null)
		{
			sum+= node.value;
			return sum;
		}
		
		sum+= node.value;
		int lMax= pathSum(node.left, sum);
		int rMAx = pathSum(node.right, sum);
		return Math.max(lMax, rMAx);
	}
	void dfs(TreeNode root, List<String> paths, StringBuilder path)
	{
		if(root == null)
			return;

		int len = path.length();
		if(root.left == null && root.right == null)
		{
			path.append(root.value);
			paths.add(path.toString());
			path.delete(len, path.length());
			return;
		}

		path.append(root.value + "->");
		dfs(root.left, paths, path);

		dfs( root.right, paths, path);

		path.delete(len, path.length());

	}

	public List<String> binaryTreePaths(TreeNode root) 
	{
		List<String> paths = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		dfs(root, paths, sb);

		return paths;
	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) 
    {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        
        TreeNode root = new TreeNode(t1.value + t2.value);
        
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        
        return root;
    }


}
