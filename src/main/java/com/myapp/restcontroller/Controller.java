package com.myapp.restcontroller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.utility.CommonUtils;
import com.myapp.utility.JsonUtil;

@RestController
public class Controller {
	
	
	private CommonUtils util = new JsonUtil();
	private String intent;
	private JSONObject element;

	@RequestMapping(value = "/webhook/{test}", method = RequestMethod.GET)
	public ResponseEntity<?> testCall(@PathVariable("test") String test) {
		System.out.println("Service Call..");
		return new ResponseEntity<String>(test, HttpStatus.OK);
	}

	@RequestMapping(value = "/webhook", method = RequestMethod.POST)
	public ResponseEntity<?> getStockInfo(@RequestBody String body) {
		JSONObject jsonObject = util.parseStringToJson(body);
		
		if (jsonObject != JSONObject.NULL) {
			try {
				element = JsonUtil.getElement(jsonObject, "speech", "nice to see you", "nice to see you swapnil");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Exceptiion...");
			}
			
		}else {
			System.out.println("Null object");
		}
		System.out.println("element: " + element);
		return new ResponseEntity<String>(element.toString(), HttpStatus.OK);
	}
}
