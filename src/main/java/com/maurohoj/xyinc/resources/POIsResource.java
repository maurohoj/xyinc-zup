package com.maurohoj.xyinc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maurohoj.xyinc.domain.POIs;
import com.maurohoj.xyinc.services.POIsService;

@RestController
@RequestMapping(value = "/pois")
public class POIsResource {

	@Autowired
	private POIsService service;

	// Utilização de tratamento de exceção (try-cath) nas requisições http

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllPOIs() {
		try {
			return ResponseEntity.ok(service.getAllPOIs());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	//baseando-se na metodologia REST, o mesmo endpoint '{id}', realiza tarefas diferentes com base no metodo http chamado'
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findId(@PathVariable Integer id) {
		try {
			return ResponseEntity.ok().body(service.findPOI(id));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePOI(@PathVariable Integer id) {
		try {
			service.deletePOI(id);
			return ResponseEntity.ok(service.getAllPOIs());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@RequestMapping(value = "/create", method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<?> createPOI(@RequestBody POIs poi) {
		try {
			service.createPOI(poi);
			return ResponseEntity.ok(service.getAllPOIs());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@RequestMapping(value = "/POIsNearby", method = { RequestMethod.GET })
	public ResponseEntity<?> getPOIsNearby(@RequestParam("coordx") int coordx, @RequestParam("coordy") int coordy, @RequestParam("maxDistance") double maxDistance){
		try {
            POIs poiReference = new POIs(null, "POI Reference", coordx, coordy);
            return ResponseEntity.ok(service.getPOIsNearby(poiReference, maxDistance));
        } catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
	}

}
