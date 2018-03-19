package trial;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CreatePaths
{

  private List<Double> getEvents(String eventIDpath)
  {
    List<Double> events = new ArrayList<>();
    try
    {
      BufferedReader reader =
          new BufferedReader(new InputStreamReader(new FileInputStream(new File(eventIDpath)), "UTF-8"));
      int count = 0;
      while (true)
      {
        String line = reader.readLine();
        if (line == null)
          break;
        // System.out.println(line);
        count++;

        line = line.trim();
        events.add(Double.parseDouble(line));
      }
      System.out.println(count);

      reader.close();
    } catch (Exception e)
    {
      e.printStackTrace();
    }
    return events;
  }

  public static void main(String[] args)
  {
    CreatePaths cp = new CreatePaths();

    String eventIDpath = "/Users/hm/Desktop/event_ids.txt";
    List<Double> event_ids = cp.getEvents(eventIDpath);
    String origURL= " writer.println(\"{  \\\"url\\\": \"http://dh2vablh01:8080/ml-immunization/ablh.dh2.cerner.com/service/immunizations/events/ByEventId?eventIds=22335399\\\",  \\\"method\\\": \\\"GET\\\",  <user_info> }\\tget_by_event_1\");";
  // System.out.println(origURL);
    String baseUrl =
        "writer.println(\"{  \\\"url\\\": \\\"http://dh2vablh01:8080/ml-immunization/ablh.dh2.cerner.com/service/immunizations/events/ByEventId?";

    String base2Url ="eventIds=22335399&eventIds=22335400";
    String base3Url="\",  \\\"method\\\": \\\"GET\\\",  <user_info> }";
    String base4Url ="\tget_by_event_1\");";

    //System.out.println(baseUrl + base2Url + base3Url + base4Url);

    
    int evt_id_index = 0;
    int eventCnt=0;
    for(int j = 1; j < 30 ;j ++)
    {
      StringBuilder finalUrl = new StringBuilder();
      finalUrl.append(baseUrl);
      
      for(int i = 0; i < eventCnt + 2 ;i ++)
      {
        finalUrl.append("eventIds=");
        finalUrl.append(new DecimalFormat("#").format(event_ids.get(evt_id_index + i)));
        finalUrl.append("&");
      }
      evt_id_index += 2;
      eventCnt= eventCnt+2;
      finalUrl.append(base3Url);
      finalUrl.append("\tget_by_event_"+evt_id_index+"\");");
      
      System.out.println(finalUrl);
    }
    
  }

}
