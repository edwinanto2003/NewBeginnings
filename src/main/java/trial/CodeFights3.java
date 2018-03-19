package trial;

public class CodeFights3 {


	String smartAssigning(String[] names, boolean[] statuses, int[] projects, int[] tasks) 
	{
		int minTaskIndex = -1;
		int minProjectIndex = -1;

		for (int i = 0; i < names.length; i ++)
		{
			if(statuses[i] == false)
			{
				if (minTaskIndex < 0)
					minTaskIndex = i;
				if (minProjectIndex < 0)
					minProjectIndex = i;

				if(tasks[i] < tasks[minTaskIndex])
					minTaskIndex = i;
				else if (tasks[i] == tasks[minTaskIndex])
				{
					if(projects[i] < projects[minProjectIndex])
						minProjectIndex = i;
				}            
			}
		}

		if(minProjectIndex == minTaskIndex)
			return names[minProjectIndex];
		else 
			return names[minTaskIndex];
	}

	public static void main(String[] args) 
	{
		CodeFights3 cf = new CodeFights3();

		/**
		 names: ["John", "Martin"]
		statuses: [false, false]
		projects: [2, 1]
		tasks: [16, 5]
		 */

		 String[] names = {"John", "Martin"};
		boolean[] statuses = {true, false};
		int[] projects = {1, 2};
		int[] tasks = {6, 6};

		cf.smartAssigning(names, statuses, projects, tasks);

	}

}
