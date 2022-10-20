package com.testCases;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.JSONFileReader;
import io.qameta.allure.Description;
import junit.framework.Assert;

public class TC02_ValidateWicketKeeper {
JSONFileReader JSONFR;
	
	
	@BeforeMethod(alwaysRun = true)
	public void init() throws AWTException {
		JSONFR=new JSONFileReader();
			   
	    }
	
	

	@Test
	@Parameters({"FileName"})
	@Description("Test 2: This Test validates that the team has atleast 1 wicket keeper")
	public void validateThereIsAtleastOneWicketKeeperInTeam(@Optional("Cricket") String FileName) throws Exception, SQLException {
		
		try {
	
		    String FilePath=System.getProperty("user.dir") + "\\src\\test\\resources\\JSONFiles\\"+FileName+".json";			
			JSONArray PlayerDetails =JSONFR.returnJSONArray(FilePath, "player") ;          	       
		    int WicketKeeper=0;
		       
		        
		    Iterator itr2 = PlayerDetails.iterator(); // to iterate through each block of players

		    while (itr2.hasNext())  
		      { 
               	Iterator  itr1 = ((Map) itr2.next()).entrySet().iterator(); // to iterate through each key value pair in a block
		        	
               	while (itr1.hasNext()) { 
		        		
		        		Map.Entry pair =( Entry<String,String>) itr1.next(); //to get pairs as map key-value
		        		
		        		 if(pair.getKey().equals("role" )&& pair.getValue().equals("Wicket-keeper"))
			               {
			            	   WicketKeeper++;
			               }


		        	} 
		        } 


               if(WicketKeeper>=1)	
               {
		    		assertTrue(true,"There are "+WicketKeeper+" in the team");
               }
               else
               {
            	   assertTrue(false,"There is not atleast one wicket keeper in the team");
               }

		} catch (Exception e) {
			throw e;
		}
							
	}
	}