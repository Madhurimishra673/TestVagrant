package Utilities;

import java.awt.AWTException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.BeforeMethod;



import bsh.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class JSONFileReader {
	
	 
	/*Function Name:
	 *Date Of Creation
	 *Author
	 *Last Modified
	 *Summary
	 *Variable
	 * */
	@SuppressWarnings("unchecked")
	public JSONArray returnJSONArray(String vJSONFilePath, String vArraytoBeReturned) throws InterruptedException, IOException, ParseException,  org.json.simple.parser.ParseException {
		    
		JSONParser  jsonParser = new JSONParser();
		FileReader reader = new FileReader(vJSONFilePath);  		
		//parse JSON FIle Into A JSON Object    
		JSONObject JObject = (JSONObject) jsonParser.parse(reader);
        //parse JSON Object into a JSON Array
		JSONArray JArray = (JSONArray) JObject.get("player"); 

		return JArray;
		          
	           
	}
	
	
	
	
	
	
	
	
}
