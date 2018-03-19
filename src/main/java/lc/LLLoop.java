package lc;

public class LLLoop
{
	
	
	public boolean hasCycle(ListNode head) 
    {
        if (head == null || head.next == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast)
        {
            if (fast == null || fast.next == null)
                return false;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
	
	

	public static void main(String[] args)
	{
		ListNode node = new  ListNode(1);
		node.next = new ListNode(2);
		
		node.next.next = node;
		LLLoop lllp = new LLLoop();
		System.out.println(lllp.hasCycle(node));

	}

}
