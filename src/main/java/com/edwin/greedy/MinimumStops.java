package com.edwin.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinimumStops
{

	int findMinStops(int initialGas, int d, GasStation[] gasStations)	
	{
		int minStops = 0;
		
		int currentPos = 0;
		int gasAvailable  = initialGas;
		
		Arrays.sort(gasStations, new Comparator<GasStation>()
		{
			public int compare(GasStation g1, GasStation g2)
			{
				return (g1.distanceFromDestination < g2.distanceFromDestination) ? 1 : -1;
			}
		});
		
		while (currentPos < d)
		{
			int stopPos = currentPos + gasAvailable;
			
			if (stopPos < d)
			{
				GasStation g = findClosestGasStation(gasStations);
				if (g == null)
					return -1;
				gasAvailable = gasAvailable - (d - g.distanceFromDestination) + g.gasAvailable;
			}
		}
		
		return minStops;
	}

	private GasStation findClosestGasStation(GasStation[] gasStations)
	{
		int s = 0, e = gasStations.length - 1;
		
		if (gasStations == null || gasStations.length ==0)
			return null;
		
	}

	public static void main(String[] args)
	{
		int d = 20;
		int initialGas = 10;
		
		GasStation[] gasStations = new GasStation[]{new GasStation(14, 4), new GasStation(12, 12), new GasStation(15, 1)};
		
		MinimumStops mm = new MinimumStops();
		System.out.println(mm.findMinStops(initialGas, d, gasStations));
	}

}
