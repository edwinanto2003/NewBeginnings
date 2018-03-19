package trial;
/**
 * 
 * You have some tasks in your Asana account. For each ith of them you know its deadlinesi, which is the last day by which it should be completed. As you can see in your calendar, today is the day number day. Asana labels each task in accordance with its due date:

	If the task is due today or it's already overdue, it is labeled as Today;
	If the task should be completed within a week (but not today), i.e. its deadline is somewhere between day + 1 and day + 7 both inclusive, it is labeled as Upcoming;
	All other tasks are labeled as Later;
	Your goal is to find the number of tasks with each label and return it as an array of format [Today, Upcoming, Later], where Today, Upcoming and Later is the number of tasks with the corresponding label.
	
	Example
	
	For deadlines = [1, 2, 3, 4, 5] and day = 2, the output should be
	tasksTypes(deadlines, day) = [2, 3, 0].
	
	Today is day 2, so tasks with deadlines at 1 and 2 are labeled as Today. Other three tasks should be completed within a week and should be labeled as Upcoming. There're no tasks labeled as Later.
	
	
	
	For deadlines = [1, 2, 4, 2, 10, 3, 1, 4, 5, 4, 9, 8] and day = 1, the output should be
	tasksTypes(deadlines, day) = [2, 8, 2].
	
	Today is day 1, which means that two tasks with deadlines 1 are labeled as Today. Tasks with deadlines 10 and 9 are labeled as Later, since their deadlines are more than 7 days ahead. The rest 8 tasks are labeled as Upcoming.
	
	
	
	Input/Output
	
	[time limit] 3000ms (java)
	[input] array.integer deadlines
	
	Constraints:
	1 ≤ deadlines.length ≤ 15,
	1 ≤ deadlines[i] ≤ 15.
	
	[input] integer day
	
	Constraints:
	1 ≤ day ≤ 10.
	
	[output] array.integer
	
	Array of three elements, the number of tasks labeled as Today, Upcoming and Later, respectively.
 * 
 * 
 * 
 * @author Edwin
 *
 */
public class CodeFights2 {
	int[] tasksTypes(int[] deadlines, int day) 
	{
	    int todayCount = 0;
	    int upcomingCount = 0;
	    int laterCount = 0;
	    
	    for (int i = 0; i < deadlines.length; i++)
	    {
	        if(deadlines[i] <= day)
	            todayCount++;
	        else if((deadlines[i]>= day+1) && (deadlines[i]<= day +7))
	            upcomingCount++;
	        else
	            laterCount++;
	    }
	    
	    return new int[]{todayCount, upcomingCount, laterCount};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
