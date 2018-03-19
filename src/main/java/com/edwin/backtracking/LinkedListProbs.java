package com.edwin.backtracking;

import java.util.ArrayList;
import java.util.List;

import com.edwin.binaryTrees.TreeNode;

import trial.LinkedListImpl;
import trial.Node;

public class LinkedListProbs
{
	
	 TreeNode createBST(List<Integer> sortedList, int s, int e)
	    {
	        if (s > e)
	        {
	            return null;
	        }
	        
	        int mid = s + (e - s)/2;
	        
	        TreeNode root = new TreeNode(sortedList.get(mid));
	        root.left = createBST(sortedList, s, mid - 1);
	        root.right = createBST(sortedList, mid + 1, e);
	        
	        return root;
	    }
	    
	    TreeNode createBST(List<Integer> sortedList)
	    {
	        return createBST(sortedList, 0 , sortedList.size() - 1);
	    }
	    
	    public TreeNode sortedListToBST(Node head) 
	    {
	        if (head == null)
	            return null;
	        
	        List<Integer> sortedList = new ArrayList<Integer>();
	        
	        while(head!=null)
	        {
	            sortedList.add(head.val);
	            head = head.next;
	        }
	        
	        TreeNode root = createBST(sortedList);
	        return root;
	    }

	public static void main(String[] args)
	{
		LinkedListImpl ll = new LinkedListImpl();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(7);
		ll.add(8);
		
		Node head = ll.getHead();
		
		LinkedListProbs llp = new LinkedListProbs();
		
		TreeNode root = llp.sortedListToBST(head);
		
		System.out.println(head.getVal());
		ll.print();
		

	}

}
