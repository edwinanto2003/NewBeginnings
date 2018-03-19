package com.edwin.ether;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class EtherTester
{	
	static Timer timer;
	
	static void startTimer()
	{
		timer = new Timer();
		timer.schedule(new EtherApiCaller(), 0, 5000);
	}
	
	static void stopTimer()
	{
		timer.cancel();
		timer.purge();
	}
	
	static class EtherApiCaller extends TimerTask
	{
		double[] price = new double[10];
		int index = 0;
		@Override
		public void run()
		{
		//	System.out.println("Sending GET request...");
			
			try
			{
				sendGet();
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void sayHello()
		{
			System.out.println("Hello....");
		}

		// HTTP GET request
		private void sendGet() throws Exception {

			String url = "https://min-api.cryptocompare.com/data/price?fsym=LTC&tsyms=BTC,USD,EUR";

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
		//	System.out.println("\nSending 'GET' request to URL : " + url);
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
							
	  //     System.out.println("JSON elements size : " + jsonObj.size());

			double priceRytNow = Double.parseDouble(jsonObj.get("USD").toString());
			
	//		JOptionPane.showInputDialog(new JFrame(), "hello");
			
//			if (index > 9)
//			{
//				EtherTester.stopTimer();
//				return;
//			}
			price[index++] = priceRytNow;
	       System.out.println("Price of LTC : " + jsonObj.get("USD"));
	      
		}
		
		
	}

	public static void main(String[] args)
	{
		startTimer();

		System.out.println("done");
	}

}
