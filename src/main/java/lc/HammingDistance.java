package lc;

public class HammingDistance
{

	public int hammingDistance(int x, int y) 
	{
		x = x ^ y;
		int bitsDiff =0;

		while (x > 0)
		{
			if ((x & 1) == 1)
				bitsDiff++;
			x = x >> 1;
		}
		return bitsDiff;
	}
	
	public int hammingWeight(int n) 
    {
        int bits = 0;
        
        while (n > 0)
        {
            if ((n &1) == 1)
                bits++;
            n = n>>1;
        }
        
        return bits;
    
    }
	

	public static void main(String[] args)
	{
		HammingDistance hd = new HammingDistance();
		System.out.println(hd.hammingDistance(1, 4));
		
		System.out.println(hd.hammingWeight(2147483646));

	}

}
