package com.myapp.restcontroller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.utility.Util;

@RestController
public class Controller {
	
	@Autowired
	Util util;

	@RequestMapping(value = "/webhook/{test}", method = RequestMethod.GET)
	public ResponseEntity<?> testCall(@PathVariable("test") String test) {
		System.out.println("Service Call..");
		return new ResponseEntity<String>(test, HttpStatus.OK);
	}

	@RequestMapping(value = "/webhook", method = RequestMethod.POST)
	public ResponseEntity<?> getStockInfo(@RequestBody String body) {
		System.out.println("Body: " + body);
		JSONObject jsonObject = util.getJsonObj(body);
		if (jsonObject != null) {
			System.out.println("True");
		}else {
			System.out.println("Null object");
		}
		
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
}
