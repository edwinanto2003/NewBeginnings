package trial;

public class CFChallenge1 {

	String[] CodeFight(int n) {
		String[] arr = new String[n];
		for (int i = 1; i <= n; i++) {
			if (i % 5 == 0 && i % 7 == 0)
				arr[i - 1] = "CodeFight";
			else if (i % 5 == 0)
				arr[i - 1] = "Code";
			else if (i % 7 == 0)
				arr[i - 1] = "Fight";
			else
				arr[i - 1] = Integer.toString(i);

		}

		return arr;
	}

	public static void main(String[] args) 
	{
		CFChallenge1 cf = new CFChallenge1();
		cf.CodeFight(35);
	}

}
