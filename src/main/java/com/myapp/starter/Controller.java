package com.myapp.starter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping(value = "/web/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("name") String name) {

		return new ResponseEntity<String>(name, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/webhook", method = RequestMethod.POST)
	public ResponseEntity<?> getLicenseKey(@RequestBody String body) {
		System.out.println(body);
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
}
