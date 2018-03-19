package trial;

import java.util.ArrayList;
import java.util.List;


public class Test1
{
	class CodeFieldPair
	{
		int key;
		int string;

	}

	private void getPairs(List<CodeFieldPair> codeuids)
	{

		for (CodeFieldPair codeuid : codeuids)
		{
			System.out.println(codeuid.key);
			System.out.println(codeuid.string);
		}
	}

	public static void main(String[] args)
	{
		String comment = "[02/06/2016 18:20] adding an admin note .. modifying this with hopes it would show up.. oh please lord .. let this show up\r\n";

		comment = comment.replaceAll("\\<.*?\\>", "");
		System.out.println(comment);

		Test1 t1 = new Test1();
		
		// new CodeFieldPair();
		
		String cerenerCorrelationId = new StringBuilder((int) Math.floor(Math.random() * 1000)).toString();
		System.out.println(cerenerCorrelationId);
		List<CodeFieldPair> codeuids = new ArrayList<CodeFieldPair>();
		for (int i = 0; i < 10; i++)
		{
			CodeFieldPair cc = t1.new CodeFieldPair(); 
			if (i % 2 == 0)
			{
				cc.key = i;
				cc.string = i * 4;
				codeuids.add(cc);
			}
		}
		t1.getPairs(codeuids);
	}

}
