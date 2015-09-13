package files;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.net.ssl.HttpsURLConnection;

public class CallingMap {

	private final static String USER_AGENT = "Mozilla/5.0";

	public static void main(String[] args) throws Exception {

		CallingMap http = new CallingMap();

		System.out.println("Testing 1 - Send Http GET request");
		//http.sendGet();
		
		System.out.println("\nTesting 2 - Send Http POST request");
	//	http.sendPost(null);

	}

	// HTTP GET request
	public static String sendGet(String location) throws Exception {
String finallocation = location.replaceAll("\\s+", "+");
System.out.println(finallocation+"is the new location");
		String url = "https://maps.google.com/maps/api/geocode/xml?address="+finallocation+"&sensor=false";
		
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

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
		System.out.println(response.toString());
		String finalresult=null;
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder;
	        InputSource is;
	        try {
	            builder = factory.newDocumentBuilder();
	            is = new InputSource(new StringReader(response.toString()));
	            Document doc = builder.parse(is);
	            NodeList list = doc.getElementsByTagName("lat");
	            //System.out.println("wow, we found out the latitude");
	           // System.out.println(list.item(0).getTextContent());
	            finalresult = list.item(0).getTextContent()+",";
	            list = doc.getElementsByTagName("lng");
	            finalresult += list.item(0).getTextContent();
	        } catch (ParserConfigurationException e) {
	        } catch (SAXException e) {
	        } catch (IOException e) {
	        }
		
		
		
		
		
		return finalresult.toString();

	}
	
	// HTTP POST request
	public static String sendPost(String location) throws Exception {

		String url = "https://maps.google.com/maps/api/geocode/xml";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String urlParameters = "address="+location+"&sensor=false";
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
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
		System.out.println(response.toString());
		return response.toString();

	}

}
