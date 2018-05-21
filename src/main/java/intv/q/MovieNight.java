package intv.q;

import java.util.*;
import java.text.SimpleDateFormat;

public class MovieNight {
	public static Boolean canViewAll(Collection<Movie> movies) 
	{
		if (movies == null || movies.size() == 0)
			return false;

		List<Movie> movieList = new ArrayList<Movie>(movies);


		Collections.sort(movieList, new Comparator<Movie>() 
		{
			public int compare(Movie o1, Movie o2) 
			{
				if( o1.getStart().before(o2.getStart()))
					return -1;
				else 
					return 1;
			}});

		for (Movie m : movieList)
		System.out.println(m.getName());
		
		
		for (int i = 0 ; i < movieList.size() - 1; i++)
			for (int j = i + 1; j < movieList.size();j++)
			{
				if(movieList.get(i).getEnd().after(movieList.get(j).getStart()))
					return false;
			}
		

		return true;
	}

	public static void main(String[] args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

		ArrayList<Movie> movies = new ArrayList<Movie>();
		movies.add(new Movie("a", sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
		movies.add(new Movie("b", sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
		movies.add(new Movie("c", sdf.parse("2015-01-01 21:31"), sdf.parse("2015-01-01 23:00")));

		System.out.println(MovieNight.canViewAll(movies));
	}
}

class Movie {
	private Date start, end;
	private String name;
	public Movie(String name, Date start, Date end) {
		this.start = start;
		this.end = end;
		this.name = name;
	}

	public Date getStart() {
		return this.start;
	}

	public Date getEnd() {
		return this.end;
	} 
	
	public String getName()
	{
		return this.name;
	}
}