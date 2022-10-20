package com.testCases;

import java.awt.AWTException;
import java.io.FileReader;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.JSONFileReader;
import io.qameta.allure.Description;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TC01_ValidateForeignPlayers {
	
	JSONFileReader JSONFR;
	
	
	@BeforeMethod(alwaysRun = true)
	public void init() throws AWTException {
		JSONFR=new JSONFileReader();
			   
	    }
	
	

	@Test
	@Parameters({"FileName"})
	@Description("Test 1: This Test validates that the team has only 4 foreign players")
	public void validateOnlyFourForeignPlayersAreInTeam(@Optional("Cricket") String FileName) throws Exception, SQLException {
		
		try {
	
		    String FilePath=System.getProperty("user.dir") + "\\src\\test\\resources\\JSONFiles\\"+FileName+".json";			
			JSONArray PlayerDetails =JSONFR.returnJSONArray(FilePath, "player") ;          	       
		    int ForeignPlayers=0;
		       
		        
		    Iterator itr2 = PlayerDetails.iterator(); // to iterate through each block of players

		    while (itr2.hasNext())  
		      { 
               	Iterator  itr1 = ((Map) itr2.next()).entrySet().iterator(); // to iterate through each key value pair in a block
		        	
               	while (itr1.hasNext()) { 
		        		
		        		Map.Entry pair =( Entry<String,String>) itr1.next(); //to get pairs as map key-value
		        		if(pair.getKey().equals("country" )&& !pair.getValue().equals("India"))
		        			ForeignPlayers++;


		        	} 
		        } 


		    	
		    		Assert.assertEquals(4,ForeignPlayers,"Validation of number of foreign players in Team");
		    	
	          

			
		} catch (Exception e) {
			throw e;
		}
							
	}
	
	
	
	
}
