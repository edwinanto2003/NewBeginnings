package com.edwin.backtracking;

import trial.LinkedListImpl;
import trial.Node;

public class Palindrome
{
	
	
    Node reverse (Node head)
    {
        Node prev = null;
        Node curr = head;
        
        while (curr!=null)
        {
            Node temp = curr;
            curr = curr.getNext();
            temp.setNext(prev);
            prev = temp;
        }
        
        return prev;
    }
    
    public boolean isPalindrome(Node head) 
    {
        if (head == null || head.getNext() == null)
            return true;
        
        Node slow = head;
        Node fast = head;
        
        while (fast !=null &&  fast.getNext()!=null)
        {
            slow=slow.getNext();
            fast = fast.getNext().getNext();
        }
        
        Node right;
        if (fast == null)
        {
            right = reverse(slow);
        }else
        {
            right = reverse(slow.getNext());
        }
        
        Node left = head;
        while (right !=null)
        {
            if(left.getVal() != right.getVal())
                return false;
            left= left.getNext();
            right = right.getNext();
        }
        return true;
    }

	public static void main(String[] args)
	{
		LinkedListImpl ll = new LinkedListImpl();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(2);
		ll.add(1);
		
		Node head = ll.getHead();
		
		System.out.println(head.getVal());
		ll.print();
		
		Palindrome p = new Palindrome();
		
		p.isPalindrome(head);
//		
//		System.out.println();
//		ll.remove(3);
//		ll.print();
//		System.out.println();
//		ll.remove(1);
//		ll.remove(2);
//
//		ll.remove(1);
//		ll.print();
	}

}
