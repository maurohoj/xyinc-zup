package com.maurohoj.xyinc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurohoj.xyinc.domain.POIs;

@Service
public class DBService {
	
	@Autowired
	private POIsService poisService;
	
	public void instantiateTestDatabase() {
		
		POIs po1 = new POIs (null, "Lanchonete", 27, 12);
		POIs po2 = new POIs (null, "Posto", 31, 18);
		POIs po3 = new POIs (null, "Joalheria", 15, 12);
		POIs po4 = new POIs (null, "Floricultura", 19, 21);
		POIs po5 = new POIs (null, "Pub", 12, 8);
		POIs po6 = new POIs (null, "Supermercado", 23, 6);
		POIs po7 = new POIs (null, "Churrascaria", 28, 2);
		
		poisService.createPOI(po1);
		poisService.createPOI(po2);
		poisService.createPOI(po3);
		poisService.createPOI(po4);
		poisService.createPOI(po5);
		poisService.createPOI(po6);
		poisService.createPOI(po7);
	}
}
