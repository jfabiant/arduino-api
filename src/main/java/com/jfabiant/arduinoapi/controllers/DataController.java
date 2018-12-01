package com.jfabiant.arduinoapi.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jfabiant.arduinoapi.models.Data;
import com.jfabiant.arduinoapi.models.ResponseMessage;
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
	
	@PostMapping("/datos")	// https://spring.io/guides/gs/uploading-files/
	public ResponseMessage crear(@RequestParam("humedad") String humedad, @RequestParam("temperatura") String temperatura, @RequestParam("rayos_v") String rayos_v, @RequestParam("sensor_lluvia") String sensor_lluvia) {
		logger.info("call crear(" + humedad + ", " + temperatura + ", " + rayos_v + ", " + sensor_lluvia + ")");
		
		Data data = new Data();
		data.setHumedad(humedad);
		data.setTemperatura(temperatura);
		data.setRayos_v(rayos_v);
		data.setSensor_lluvia(sensor_lluvia);
				
		dataService.crear(data);
		
		return ResponseMessage.success("Registro completo");
	}

	
}
