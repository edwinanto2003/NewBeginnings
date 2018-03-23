package com.edwin.linkedLists;

public class LinkedListImpl
{
	ListNode root;

	public LinkedListImpl()
	{
		root = null;
	}

	public ListNode getHead()
	{
		return root;
	}

	public void add(int val)
	{
		if (root == null)
		{
			root = new ListNode(val);
			return;
		}

		ListNode temp = root;

		while (temp.next != null)
			temp = temp.next;

		temp.next = new ListNode(val);
	}

	public boolean remove(int val)
	{
		if (root == null)
			throw new RuntimeException("Cannot remove");

		if (root.val == val)
		{
			root = root.next;
			return true;
		}
		
		ListNode temp = root;
		ListNode prev = temp;
		while (temp != null && temp.val != val)
		{
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return false;
		prev.next = temp.next;
		temp = null;

		return true;
	}

	public boolean checkIfPalindrome()
	{
		ListNode runner = root;
		ListNode head = root;
		return checkIfPalindrome(head, runner);
	}

	private boolean checkIfPalindrome(ListNode head, ListNode runner)
	{
		if (runner == null)
			return true;
		
		checkIfPalindrome(head, runner.next);
		
		if(head.val != runner.val)
			return false;
		
		return true;
		
	}

	public static void print(ListNode node)
	{
		ListNode temp = node;
		while (temp != null)
		{
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}
