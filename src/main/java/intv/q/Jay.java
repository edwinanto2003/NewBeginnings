package intv.q;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Employee
{
	int id;
	List<Employee> reports = new ArrayList<Employee>();

	public Employee(){}
	public Employee(int id, List<Employee> reports)
	{
		this.id = id;
		this.reports.addAll(reports);
	}

}

public class Jay
{
	Map<Integer, Employee> empMap = new HashMap<Integer, Employee>();

	public List<Employee> findReports(int id)
	{
		Set<Employee> visited = new HashSet<Employee>();
		List<Employee> result = new ArrayList<Employee>();
		Queue<Employee> q = new LinkedList<Employee>();
		Employee e = empMap.get(id);

		if (e == null)
			return result;

		q.add(e);

		while (!q.isEmpty())
		{
			Employee u = q.poll();

			if (!visited.contains(u))
			{
				visited.add(u);
				for (Employee emp : u.reports)
				{
					if (emp != null)
						q.add(emp);
				}
				if (u.id != id)
					result.add(u);
			}
		}

		for (Employee r : result)
			System.out.print( r.id + " ");

		return result;
	}

	public static void main(String[] args)
	{
		Employee e1 = new Employee();
		e1.id = 1;

		Employee e2 = new Employee();
		e2.id = 2;

		Employee e3 = new Employee();
		e3.id = 3;

		Employee e4 = new Employee();
		e4.id = 4;		

		List<Employee> e1reports = e1.reports;
		e1reports.add(e2);
		e1reports.add(e3);
		e1reports.add(e4);


		Employee e5 = new Employee();
		e5.id = 5;



		Employee e6 = new Employee();
		e6.id = 6;		




		Employee e7 = new Employee();
		e7.id = 7;


		List<Employee> e2reports =e2.reports;
		e2reports.add(e5);
		e2reports.add(e6);
		e2reports.add(e7);

		Employee e8 = new Employee();
		e8.id = 8;		

		Employee e9 = new Employee();
		e9.id = 9;

		Employee e10 = new Employee();
		e10.id = 10;	

		List<Employee> e6reports = e6.reports;
		e6reports.add(e8);
		e6reports.add(e9);
		e6reports.add(e10);

		e10.reports.add(e1);
		
		Jay j = new Jay();

		j.empMap.put(e1.id, e1);
		j.empMap.put(e2.id, e2);
		j.empMap.put(e3.id, e3);
		j.empMap.put(e4.id, e4);
		j.empMap.put(e5.id, e5);
		j.empMap.put(e6.id, e6);
		j.empMap.put(e7.id, e7);
		j.empMap.put(e8.id, e8);
		j.empMap.put(e9.id, e9);
		j.empMap.put(e10.id, e10);

		j.findReports(1);

	}

}
