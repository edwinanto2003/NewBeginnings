import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TestSCript 
{
	private final static String path = "C:\\Users\\vagrant\\Desktop\\temp\\Outtask Web Server\\Outtask Web Public\\Expense"; 
	private static int count = 0;
	private static Set<String> fileSet = new HashSet<String>();
	private static Set<String> scriptSet = new HashSet<String>();
 	
	private static void recurseFiles()
	{
		File f = new File(path);
		recurseFiles(f);
	}

	private static void recurseFiles(File file) 
	{
		try {
			File[] files = file.listFiles();
			for (File f : files)
			{
				if (f.isDirectory())
				{
					recurseFiles(f);
				}
				else
				{
					BufferedReader br = new BufferedReader(new FileReader(f));
					String line;
					while((line = br.readLine()) != null)
					{
						line = line.toLowerCase();
						if (line.contains("../../../script"))
						{
							line = line.replaceAll("<!--|/|-->|^..^|\"|=|-->", " ");
							//System.out.println(f.getName());
							if(!fileSet.contains(f.getName()))
							{
								fileSet.add(f.getName());
							}
							String[] words = line.split(" ");
							System.out.println(words[words.length - 1]);
							scriptSet.add(words[words.length - 1]);
							//count++;
							//break;
						}

					}
					br.close();
				}
			}
		}catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}

	}

	public static void main(String[] args) 
	{

		recurseFiles();
		System.out.println("Script count: " + scriptSet.size());

	}

}
