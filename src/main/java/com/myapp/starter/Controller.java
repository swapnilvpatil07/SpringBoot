package com.myapp.starter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping(value = "/web/{name}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("name") String name) {

		return new ResponseEntity<String>(name, HttpStatus.OK);
	}
	
	/*@RequestMapping(value = "/license", method = RequestMethod.POST)
	public ResponseEntity<?> getLicenseKey(@RequestBody LicsenseKey key) {
		String licKey = key.getLicenseKey();
		if (licKey.isEmpty() || licKey == null) {
			return new ResponseEntity<String>("Invalid Key", HttpStatus.NOT_FOUND);
		}
		System.out.println(licKey);
		String status = "Valid Key";
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}*/
}
