package com.jfabiant.arduinoapi.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jfabiant.arduinoapi.models.Data;
import com.jfabiant.arduinoapi.services.DataService;

@RestController
public class DataController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	private DataService dataService;
	
	@GetMapping("/datos")
	public List<Data> datos() {
		logger.info("call datos");
		
		List<Data> datos = dataService.listar();
		
		return datos;
	}
	
}
