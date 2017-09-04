package com.myapp.utility;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

@Service
public class Util implements CommonUtils {

	@Override
	public JSONObject getJsonObj(String jsonString) {
		// TODO Auto-generated method stub
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		try {
			json = (JSONObject) parser.parse(jsonString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Parse Exception...");
		}
		return json;
	}
}
