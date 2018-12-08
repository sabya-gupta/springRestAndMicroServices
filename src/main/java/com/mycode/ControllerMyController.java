package com.mycode;


import java.net.URI;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ControllerMyController {

	@GetMapping(path="/helloworld")
	public String helloWorld() {
		return "Hello world! If you can see this then you are on!! And he time now is "+System.currentTimeMillis();
	}
	
	@GetMapping(path="/date")
	public Date getDate() {
		return new Date();
	}
	
	@GetMapping(path="/sampleResource/{type}")
	public ResourceSampleResource getSampleResource(@PathVariable String type) {
		if(type.equalsIgnoreCase("human")) {
			throw new ExceptionResourceNotFoundException(type + " not found or supported!");
		}
		
		ResourceSampleResource sr = new ResourceSampleResource();
		sr.setType(type);
		sr.setPurchasedate(new Date());
		return sr;
	}
	
	
	@PostMapping(path="/sampleResource")
	public ResponseEntity getSampleResource(@Valid @RequestBody ResourceSampleResource sr) {
		
		System.out.println(sr.getType());
		
		if(sr.getType().equalsIgnoreCase("human")) {
			return ResponseEntity.unprocessableEntity().build();
		}
		
		if(sr.getType().equalsIgnoreCase("humanbeing")) {
			throw new ExceptionInvalidTypeException(sr.getType()+" is an Invalid Type");
		}
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{type}")
		.buildAndExpand(sr.getType())
		.toUri();
		return ResponseEntity.created(location).build();
	}

	
}
