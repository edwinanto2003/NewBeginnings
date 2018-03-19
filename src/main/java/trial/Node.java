package trial;

public class Node
{
	public int val;
	public Node next;
	
	public Node(int val)
	{
		this.val = val;
		this.next = null;
	}
	
	public int getVal()
	{
		return this.val;
	}
	
	public Node getNext()
	{
		return this.next;
	}
	
	public void setNext(Node node)
	{
		this.next = node;
	}
}
