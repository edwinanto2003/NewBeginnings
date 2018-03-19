package trial;

public class Add2Nos {
	
	int addTwoDigits(int n) 
	{
	    int a = n%10;
	    return n;
	}
	
	int largest(int n)
	{
	 int result = 10^n;
	 return result -1;
	}
	
	int add(int a , int b)
	{
		return a + b;
	}
	
	public static void main(String[] args) 
	{
		Add2Nos a = new Add2Nos();
		a.addTwoDigits(21);
		a.largest(3);
		System.out.println(a.add(2147483646, 100));
	}

}
