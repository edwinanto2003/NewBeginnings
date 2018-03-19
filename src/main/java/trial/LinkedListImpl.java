package trial;

public class LinkedListImpl
{
	Node root;

	public LinkedListImpl()
	{
		root = null;
	}

	public Node getHead()
	{
		return root;
	}

	public void add(int val)
	{
		if (root == null)
		{
			root = new Node(val);
			return;
		}

		Node temp = root;

		while (temp.next != null)
			temp = temp.next;

		temp.next = new Node(val);
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
		
		Node temp = root;
		Node prev = temp;
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
		Node runner = root;
		Node head = root;
		return checkIfPalindrome(head, runner);
	}

	private boolean checkIfPalindrome(Node head, Node runner)
	{
		if (runner == null)
			return true;
		
		checkIfPalindrome(head, runner.next);
		
		if(head.val != runner.val)
			return false;
		
		return true;
		
	}

	public void print()
	{
		Node temp = root;
		while (temp != null)
		{
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}
}
