package com.mycode;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/hateoas")
public class ControllerHATEOASController {
	
	@Autowired
	ControllerMyController myController;
	
	@GetMapping(path="/hello")
	public String sayHello() {
		return "Hello Test!";
	}
	
	@GetMapping(path="/sampleResources")
	public List<ResourceSampleResource> getAllSampleResource() {
		return myController.getAllSampleResource();
	}
	
	@PostMapping(path="/sampleResources")
	public ResponseEntity<Resource> getSampleResource(@Valid @RequestBody ResourceSampleResource sr) {
		ControllerLinkBuilder link1toshow = linkTo(methodOn(this.getClass()).getAllSampleResource());
		Resource<ResourceSampleResource> resource = new Resource<ResourceSampleResource>(sr);
		resource.add(link1toshow.withRel("All The Sample resource"));
		return ResponseEntity.ok(resource);
	}
	

	
}
