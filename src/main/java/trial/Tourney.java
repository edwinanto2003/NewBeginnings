package trial;

import java.util.ArrayList;
import java.util.Arrays;

public class Tourney {
	int multisetPermutations(int[] multiset) {

		  int[] factorials = new int[multiset.length + 1];
		  factorials[0] = 1;
		  int i;
		  for (i = 1; i <= multiset.length; i++) {
		    factorials[i] = factorials[i - 1] * i;
		  }

		  Arrays.sort(multiset);
		  ArrayList<Integer> groups = new ArrayList<Integer>();
		  groups.add(1);
		  for (i = 1; i < multiset.length; i++) {
		    if (multiset[i] == multiset[i - 1]) {
		      groups.set(groups.size()-1, groups.get(groups.size()) - 1);
		    }
		    else {
		      groups.add(1);
		    }
		  }

		  int result = factorials[multiset.length];
		  for (int j = 0; j < groups.size(); j++) {
		    result /= factorials[groups.get(j)];
		  }

		  return result;
		}

	public static void main(String[] args) 
	{
		Tourney t = new Tourney();
		t.multisetPermutations(new int[]{2, 2, 1});
	}

}
