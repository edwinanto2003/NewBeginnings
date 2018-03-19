package trial;

public class PoorPigs 
{
	public static void main(String[] args)
	{
		PoorPigs pp  = new PoorPigs();
		pp.poorPigs(1000, 15, 60);
	}
	
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) 
	{
		float res = (float)minutesToDie / minutesToTest;
		return (int) (buckets * res);
	}
}
