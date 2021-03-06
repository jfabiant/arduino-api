package com.jfabiant.arduinoapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfabiant.arduinoapi.models.Data;
import com.jfabiant.arduinoapi.repositories.DataRepository;
@Service
public class DataService {
	
	@Autowired
	private DataRepository dataRepository;
	
	public List<Data> SLluvia(){
		return dataRepository.SLluvia();
	}
	
	public List<Data> PLluvia(){
		return dataRepository.PLluvia();
	}
	
	public List<Data> NLluvia(){
		return dataRepository.NLluvia();
	}
	
	public List<Data> listar(){
		return dataRepository.listar();
	}
	
	public void crear(Data data) {
		dataRepository.crear(data);
	}

}
