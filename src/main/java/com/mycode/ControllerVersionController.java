package com.mycode;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/versiontest")
public class ControllerVersionController {

	//FIRST STRATEGY
	@GetMapping(path="/resourceversion")
	ResourceForVERSION_V1 getResource() {
		return new ResourceForVERSION_V1("field1");
	}

	@GetMapping(path="/resourceversion/v2") //bad strategy
	ResourceForVERSION_V2 getResourceV2() {
		return new ResourceForVERSION_V2("field1", "field2");
	}
	

	//SECOND STRATEGY
	@GetMapping(path="/resourceversion/params", params="version=1")
	ResourceForVERSION_V1 getResourceV1_1() {
		return new ResourceForVERSION_V1("field1");
	}

	@GetMapping(path="/resourceversion/params", params="version=2") 
	ResourceForVERSION_V2 getResourceV2_1() {
		return new ResourceForVERSION_V2("field1", "field2");
	}

	//THIRD STRATEGY
	@GetMapping(path="/resourceversion/headers", headers="X-RESOURCE-VERSION=1")
	ResourceForVERSION_V1 getResourceV1_2() {
		return new ResourceForVERSION_V1("field1");
	}

	@GetMapping(path="/resourceversion/headers", headers="X-RESOURCE-VERSION=2") 
	ResourceForVERSION_V2 getResourceV2_2() {
		return new ResourceForVERSION_V2("field1", "field2");
	}
	

	//FOURTH STRATEGY
	@GetMapping(path="/resourceversion/produces", produces="application/v1+json")
	ResourceForVERSION_V1 getResourceV1_3() {
		return new ResourceForVERSION_V1("field1");
	}

	@GetMapping(path="/resourceversion/produces", produces="application/v2+json") 
	ResourceForVERSION_V2 getResourceV2_3() {
		return new ResourceForVERSION_V2("field1", "field2");
	}
	
	
}
