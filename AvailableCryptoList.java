

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/** This class is dedicated to making an available crypto currency list, and storing the list in a hashmap
*/
public class AvailableCryptoList {
	private static AvailableCryptoList instance = null;
	
	private Map<String, String> availableCryptosMap = new HashMap<>();
	private List<String> availableCryptosList = new ArrayList<>();
	
	/** Getter Method to return an initialized hash map
	* <p>
	* @return instance the new hashmap object to store the available crypto list
	*/
	public static AvailableCryptoList getInstance() {
		if (instance == null)
			instance = new AvailableCryptoList();
		
		return instance;
	}
	/** Constructor that simply calls a private method to start finding avaliable cryptos to add to the list
	*/
	private AvailableCryptoList() {
		findAvailableCryptos();
	}
	/**This method is utilized to attempt to connect to alphavantage.co, for use with 
	*/
	public void call() {
		String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM&apikey=VNEY4VV2AWF1EB51";
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				System.out.println(inline);
//				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
//				int size = jsonArray.size();
//				
//				String name, id;
//				for (int i = 0; i < size; i++) {
//					JsonObject object = jsonArray.get(i).getAsJsonObject();
//					name = object.get("name").getAsString();
//					id = object.get("id").getAsString();
//					
//					availableCryptosMap.put(name, id);
//					availableCryptosList.add(name);
//				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
	
	private void findAvailableCryptos() {

		String urlString = 
				"https://api.coingecko.com/api/v3/coins/markets" + 
						"?vs_currency=usd&order=market_cap_desc&per_page=100&page=1&sparkline=false";
//		ALPHAVANTAGE API KEY = VNEY4VV2AWF1EB51
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responsecode = conn.getResponseCode();
			if (responsecode == 200) {
				String inline = "";
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext()) {
					inline += sc.nextLine();
				}
				sc.close();
				JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
				int size = jsonArray.size();
				
				String name, id;
				for (int i = 0; i < size; i++) {
					JsonObject object = jsonArray.get(i).getAsJsonObject();
					name = object.get("name").getAsString();
					id = object.get("id").getAsString();
					
					availableCryptosMap.put(name, id);
					availableCryptosList.add(name);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
	}
	/** Getter Method to access the list of crypto's
	* <p>
	* @return availableCryptosList.toArray(new String[availableCryptosList.size()]) the String array containing a list of available cryptos
	*/
	public String[] getAvailableCryptos() {
		return availableCryptosList.toArray(new String[availableCryptosList.size()]);
	}
	/** Getter Method to access a given crypto's ID
	* <p>
	* @param cryptoName The name of the crypto currency ID to return
	* @return availableCryptosMap.get(cryptoName) The String ID for the given crypto currency
	*/
	public String getCryptoID(String cryptoName) {
		return availableCryptosMap.get(cryptoName);
	}
}
