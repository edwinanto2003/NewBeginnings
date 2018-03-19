package rest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {

	private final String Cerner_Identifier_Mapping_Scope = "Cerner-Identifier-Mapping-Scope";
	private final String Cerner_Correlation_ID = "Cerner-Correlation-ID";
	
	public static void main(String[] args) throws Exception {

		HttpURLConnectionExample http = new HttpURLConnectionExample();

		System.out.println("Testing 1 - Send Http GET request");
		http.sendGet();

//		System.out.println("\nTesting 2 - Send Http POST request");
//		http.sendPost();

	}

	// HTTP GET request
	private void sendGet() throws Exception {

		String url = "https://api-mplus-dev.northamerica.cerner.net/ml-immunization/deveng.northamerica.cerner.net/service/patients/1316020/immunizations";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty(Cerner_Correlation_ID,"112121");
		con.setRequestProperty(Cerner_Identifier_Mapping_Scope, "http://hl7.org/fhir/DSTU2/daf/immunization-daf");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		

		String inputLine;
		StringBuffer response = new StringBuffer();
	
		
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
	//	System.out.println(response.toString());
	 
		
		
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject) parser.parse(response.toString());
						
       System.out.println("JSON elements size : " + jsonObj.size());
       
       System.out.println("Element 1 : " + jsonObj.get("immunizations"));
       JSONArray immunizations = (JSONArray) jsonObj.get("immunizations");
       Set<Long> events = new HashSet<Long>();
       for (Object o : immunizations)
       {
    	   JSONObject ob = (JSONObject)o;
    	   System.out.println("eventId : " + ob.get("eventId"));
    	   events.add((Long)ob.get("eventId"));
       }
       System.out.println("events : " + events.size());
       System.out.println("Element 2 : " + jsonObj.get("statuses"));
	}

	// HTTP POST request
//	private void sendPost() throws Exception {
//
//		String url = "https://selfsolve.apple.com/wcResults.do";
//		URL obj = new URL(url);
//		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
//
//		//add reuqest header
//		con.setRequestMethod("POST");
//		con.setRequestProperty("User-Agent", USER_AGENT);
//		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//
//		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
//
//		// Send post request
//		con.setDoOutput(true);
//		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
//		wr.writeBytes(urlParameters);
//		wr.flush();
//		wr.close();
//
//		int responseCode = con.getResponseCode();
//		System.out.println("\nSending 'POST' request to URL : " + url);
//		System.out.println("Post parameters : " + urlParameters);
//		System.out.println("Response Code : " + responseCode);
//
//		BufferedReader in = new BufferedReader(
//		        new InputStreamReader(con.getInputStream()));
//		String inputLine;
//		StringBuffer response = new StringBuffer();
//
//		while ((inputLine = in.readLine()) != null) {
//			response.append(inputLine);
//		}
//		in.close();
//
//		//print result
//		System.out.println(response.toString());
//
//	}

}
