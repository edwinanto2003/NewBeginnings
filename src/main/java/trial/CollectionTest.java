package trial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionTest
{
	
	List<String> doses = new ArrayList<String>();
	
	Map<String, Node> nodesMappedById = new HashMap<String, Node>();
	
	public CollectionTest()
	{
		doses.add("Edwin");
		doses.add("Anto");
		doses.add("Gracy");
		doses.add("Rekha");
		doses.add("Rosheni");
		
		nodesMappedById.put("1", new Node(1));
		nodesMappedById.put("2", new Node(2));
		nodesMappedById.put("3", new Node(3));
		nodesMappedById.put("4", new Node(4));
		nodesMappedById.put("5", new Node(5));
	}
	
	public List<String> getDoses()
	{
		return Collections.unmodifiableList(doses);
	}
	
	public void clearDoses()
	{
		this.doses = new ArrayList<String>();
	}
	
	public Map<String, Node> getNodes()
	{
		return nodesMappedById;
	}
	
	public static void main(String[] args)
	{
		
		CollectionTest ct = new CollectionTest();
		
		List<String> names = ct.getDoses();
		
		ct.clearDoses();
		
		Map<String, Node> nodes = ct.getNodes();
		
		Node val = nodes.get("1");
		
		String key = nodes.
		
		
		
		System.out.println(names.size());
		
	}

}
