package trial;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParser
{

	public static void main(String[] args)
	{
		JSONParser parser = new JSONParser();
		 
        try {
 
            Object obj = parser.parse(new FileReader(
                    "/Users/hm/Desktop/temp/json.txt"));
 
            JSONObject jsonObject = (JSONObject) obj;
 
            JSONArray immunizations = (JSONArray) jsonObject.get("immunizations");
           	Iterator<JSONObject> iterator = immunizations.iterator();
           	
           	StringBuilder eventBuilder = new StringBuilder();
           	StringBuilder tempNotGivenIdBuilder = new StringBuilder();
           	int eventCount =0;
           	while (iterator.hasNext())
            {
           		JSONObject immunization = iterator.next();
           		
           		Long eventId = (Long) immunization.get("eventId");
           		Boolean isTempNotGiven = (Boolean) immunization.get("isTemporaryNotGiven");
               
           		if(isTempNotGiven)
           		{
           			tempNotGivenIdBuilder.append("tempNotGivenId="+eventId+"&");
           		}
           		else
           			{

           			eventCount++;
           			eventBuilder.append("eventId="+eventId+"&");
           			}
           			
            }
 
           	System.out.println(eventCount);
           	System.out.println(eventBuilder.toString());
           	System.out.println(tempNotGivenIdBuilder.toString());
           
 
        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
