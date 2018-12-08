package com.mycode;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping(path = "/filter")
public class ControllerFILTERController {

	@GetMapping(path = "/staticfileterresources")
	public List<ResourceSTATIC_FILTERResource> getAll() {
		List<ResourceSTATIC_FILTERResource> retList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			ResourceSTATIC_FILTERResource rsf = new ResourceSTATIC_FILTERResource("value1" + i, "value2" + i,
					"value3" + i, "value4" + i, "value5" + i);
			retList.add(rsf);
		}

		return retList;
	}

	@GetMapping(path = "/dynamicfileterresources")
	public MappingJacksonValue getAllFiltered() {
		List<ResourceDYNAMIC_FILTERResource> retList = new ArrayList<>();

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("ResourceDYNAMIC_FILTERResourceFilter",
				filter);

		for (int i = 0; i < 5; i++) {
			ResourceDYNAMIC_FILTERResource resourceObject = new ResourceDYNAMIC_FILTERResource("value1" + i,
					"value2" + i, "value3" + i, "value4" + i, "value5" + i);
			retList.add(resourceObject);
		}
		MappingJacksonValue mapping = new MappingJacksonValue(retList);
		mapping.setFilters(filterProvider);
		return mapping;
	}

	@GetMapping(path = "/dynamicfileterresources1")
	public MappingJacksonValue getOneFiltered() {

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1", "value2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("ResourceDYNAMIC_FILTERResourceFilter",
				filter);

		ResourceDYNAMIC_FILTERResource resourceObject = new ResourceDYNAMIC_FILTERResource("value1", "value2",
				"value3", "value4", "value5");
		MappingJacksonValue mapping = new MappingJacksonValue(resourceObject);
		mapping.setFilters(filterProvider);
		return mapping;
	}

}
