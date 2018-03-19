package trial;
/**
 * 
 * 1- correct, -1 wrong, 0 - no answer
 * 
 * @author hm
 *
 */
public class cfBot {

	double companyBotStrategy(int[][] trainingData) 
	{
	    int correct = 0;
	    int sum =0;
	    for (int i = 0; i < trainingData.length; i++)
	        for(int j = 0 ; j < trainingData[0].length;j++)
	        {
	            if (trainingData[i][1] == 1)
	            {
	                sum+=trainingData[i][0];
	                correct++;
	            }
	        }
	    return (double)sum/correct;
	}

	
	public static void main(String[] args) 
	{
			cfBot cf = new cfBot();
			int[][] trainingData = new int[][]{{3, 1},
	                {6, 1},
	                {4, 1},
	                {5, 1}};
			System.out.println(cf.companyBotStrategy(trainingData));
	}

}
