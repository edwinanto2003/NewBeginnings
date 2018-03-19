package rest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class EtherClient
{

	long[] getHistoricalData()
	{
		return null;
	}
	
	Timestamp getTimeStamp()
	{
		return new Timestamp(System.currentTimeMillis());
	}
	
	public long getPrice()
	{
		Client client = Client.create();

		String getURL = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=USD";

		WebResource webresource = client.resource(getURL);

		ClientResponse response = webresource.accept("application/json").get(ClientResponse.class);

		if (response.getStatus() != 200)
		{
			throw new RuntimeException("HTTP Error: " + response.getStatus());
		}

		String result = response.getEntity(String.class);
		System.out.println("Response from the Server: ");
		System.out.println(result);
		System.out.println(new Date());
		return 0;
	}

	public static void main(String[] args)
	{
		EtherClient ec = new EtherClient();
	//	ec.getPrice();
		System.out.println(ec.getTimeStamp());
		System.out.println(Date.);

	}

}
