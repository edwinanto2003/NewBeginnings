package trial;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCollectionMap
{
	private enum DAY
	{
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	}

	static int randomWithRange(int min, int max)
	{
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	public static void create()
	{
		Map<String, Collection<Integer>> eventModifierMap = new HashMap<>();
		List<Integer> values = new ArrayList<>();

		for (int i = 0; i < 100; i++)
		{
			values.add(randomWithRange(0, 6));
		}

		for (int val : values)
		{
			Collection<Integer> vals;
			if (eventModifierMap.containsKey(DAY.values()[val].toString()))
			{
				vals = eventModifierMap.get(DAY.values()[val].toString());

			}
			else
			{
				vals = new ArrayList<>();
			}
			vals.add(val);
			eventModifierMap.put(DAY.values()[val].toString(), vals);
		}

		for (Map.Entry<String, Collection<Integer>> entry : eventModifierMap.entrySet())
		{
			System.out.println("Key: " + entry.getKey() + " Values: " + entry.getValue());
		}
	}

	public static void main(String[] args)
	{
		// System.out.println(DAY.values()[2].toString());
		create();
	}

}
