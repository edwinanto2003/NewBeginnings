package com.edwin.linkedLists;

public class MergeLists
{

	public ListNode mergeRec(ListNode l1, ListNode l2)
	{
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.val < l2.val)
		{
			l1.next = mergeRec(l1.next, l2);
			return l1;
		}
		else
		{
			l2.next = mergeRec(l1, l2.next);
			return l2;
		}

	}
	
	public ListNode mergeInPlace(ListNode l1, ListNode l2)
	{
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = new ListNode(0);
		head.next = l1;
		ListNode prev = head;
		while (l1 != null && l2 != null)
		{
			if (l1.val < l2.val)
			{
				prev.next = l1;
				l1 = l1.next;
			}
			else
			{
				prev.next = l2;
				l2 = l2.next;
			}
		}

		if (l1 == null)
			prev.next = l2;
		if (l2 == null)
			prev.next = l1;

		return head.next;
		
		
	}

	public ListNode merge(ListNode l1, ListNode l2)
	{
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode result = new ListNode(0);
		ListNode current = result;

		while (l1 != null && l2 != null)
		{
			if (l1.val < l2.val)
			{
				current.next = l1;
				l1 = l1.next;
			}
			else
			{
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}

		if (l1 == null)
			current.next = l2;
		if (l2 == null)
			current.next = l1;

		return result.next;
	}

	public ListNode mergeKLists(ListNode[] lists)
	{
		if (lists == null || lists.length == 0)
			return null;

		ListNode result = null;

		for (ListNode l : lists)
		{
			result = mergeInPlace(result, l);
		}

		return result;
	}

	public static void main(String[] args)
	{
		MergeLists ml = new MergeLists();
	//	ListNode[] lists = new ListNode[] { new ListNode(1), new ListNode(3), new ListNode(1), new ListNode(3),
		//		new ListNode(1), new ListNode(3) };
		
		LinkedListImpl l1 = new LinkedListImpl();
		l1.add(1);
		l1.add(1);
		l1.add(3);
		
		LinkedListImpl l2 = new LinkedListImpl();
		l2.add(1);
		l2.add(3);
		l2.add(3);
		
		ListNode[] lists = new ListNode[] { l1.getHead(), l2.getHead()};
		ListNode result = ml.mergeKLists(lists);
		LinkedListImpl.print(result);
	}

}
