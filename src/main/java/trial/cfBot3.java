package trial;

import java.util.ArrayList;
import java.util.List;

/**
 * Ever so often on Codefights, a user tries to submit a duplicate solution they
 * copied from someone else. Generally these are pretty easy to detect and
 * block. However, it gets trickier when you have a duplicate solution with some
 * variables renamed to avoid getting caught.
 * 
 * The cheating usually happens as follows: in a text editor the
 * "Find and replace" function is applied to all occurrences of some variable
 * name A that consists of letters, digits, underscores, and starts with a
 * non-digit character (since it's a variable name), to change it to some other
 * variable name B that fulfills the same constraints.
 * 
 * It would appear that after applying this "Find and replace" procedure
 * multiple times it would be impossible to detect duplicates, but this isn't
 * the case. Your goal is to implement an algorithm that compares two code
 * snippets and determines whether one of them could be produced from the other
 * using the above-described approach.
 * 
 * Note. Here is a formal definition of how "Find and replace" function works.
 * When searching for string A to replace all of its occurrences in string S
 * with string B, it first finds the leftmost occurrence of A in S. Then it
 * replaces this occurrence of A with B. Then it repeats the above procedure for
 * the suffix of S which starts immediately after the last character of the
 * inserted copy of B. The process repeats until the remaining suffix contains
 * no occurrences of A.
 * 
 * Example
 * 
 * For
 * 
 * code1 = ["def is_even_sum(a, b):", "    return (a + b) % 2 == 0"] and
 * 
 * code2 = ["def is_even_sum(summand_1, summand_2):",
 * "    return (summand_1 + summand_2) % 2 == 0"] the output should be
 * plagiarismCheck(code1, code2) = true.
 * 
 * All occurrences of a are replaced with summand_1, and all occurrences of b
 * are replaced with summand_2.
 * 
 * For
 * 
 * code1 = ["function is_even_sum(a, b) {", "  return (a + b) % 2 === 0;", "}"]
 * and
 * 
 * code2 = ["function is_even_sum(a, b) {", "  return (a + b) % 2 !== 1;", "}"]
 * the output should be plagiarismCheck(code1, code2) = false.
 * 
 * Input/Output
 * 
 * [time limit] 3000ms (java) [input] array.string code1
 * 
 * Constraints: 1 ≤ code1.length ≤ 60, 0 ≤ code1[i].length ≤ 100.
 * 
 * [input] array.string code2
 * 
 * Constraints: 1 ≤ code2.length ≤ 60, 0 ≤ code2[i].length ≤ 100.
 * 
 * [output] boolean
 * 
 * true if code2 can be obtained from code1 using zero or more
 * "Find and replace" operations, false otherwise.
 * 
 * 
 * 
 * 
 * @author hm
 *
 */
public class cfBot3 {
	boolean plagiarismCheck(String[] code1, String[] code2) 
	{

		List<String> code1Terms = new ArrayList<String>();
		List<String> code2Terms = new ArrayList<String>();

		for (int i = 0; i < code1.length; i++) 
		{
			String[] code1Words = code1[i].split("\\W+");
			String[] code2Words = code2[i].split("\\W+");

			if(code1Words.length != code2Words.length)
				return false;

			for (int j = 0; j < code1Words.length; j++) 
			{
				if (code1Words[j].equals(code2Words[j]))
					continue;

				code1Terms.add(code1Words[j]);
				code2Terms.add(code2Words[j]);
			}
		}

		if(code1Terms.size() != code2Terms.size())
			return false;

		String[] newCode2 = new String[code2.length];
		int count =0;
		for (String word: code2)
		{	
			for (int i = 0; i < code1Terms.size(); i++) 
			{
				word = word.replace(code2Terms.get(i),	code1Terms.get(i));
			}
			newCode2[count++] = word;
		}

		for (int i = 0 ; i < code1.length; i++)
		{
			if (code1[i].equals(newCode2[i]))
				continue;
			else return false;
		}

		return true;
	}

	public static void main(String[] args) 
	{
		/**
		 * Example

			For			
			code1 = ["def is_even_sum(a, b):",
			         "    return (a + b) % 2 == 0"]
			and			
			code2 = ["def is_even_sum(summand_1, summand_2):",
			         "    return (summand_1 + summand_2) % 2 == 0"]
			the output should be plagiarismCheck(code1, code2) = true.

			All occurrences of a are replaced with summand_1, and all occurrences of b are replaced with summand_2.

			For			
			code1 = ["function is_even_sum(a, b) {",
			         "  return (a + b) % 2 === 0;",
			         "}"]
			and			
			code2 = ["function is_even_sum(a, b) {",
			         "  return (a + b) % 2 !== 1;",
			         "}"]
			the output should be plagiarismCheck(code1, code2) = false.
		 */

		String[] code1 = {"def is_even_sum(a, b):",
		"    return (a + b) % 2 == 0"};

		String[] code2 = {"def is_even_sum(summand_1, summand_2):",
		"    return (summand_1 + summand_2) % 2 == 0"};


		cfBot3 cf = new cfBot3();

		cf.plagiarismCheck(code1, code2);

		String[] code3 = {"def return_first(f, s):", 
				 "  t = f", 
				 "  return f"};

		String[] code4 = {"def return_first(f, s):", 
				 "  f = f", 
				 "  return f"};


		cf.plagiarismCheck(code3, code4);
	}

}
