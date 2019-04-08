package com.maurohoj.xyinc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurohoj.xyinc.domain.POIs;
import com.maurohoj.xyinc.repositories.POIsRepository;

@Service
public class POIsService {

	@Autowired
	private POIsRepository repo;
	
	//retorna todos os pontos de interesse cadastrados
	public List<POIs> getAllPOIs() {
		return repo.findAll();
	}
	
	//retorna o ponto de interesse com base no 'id'
	public POIs findPOI(Integer id) {
		Optional<POIs> obj = repo.findById(id);
		//retorna null caso o objeto não seja encontrado
		return obj.orElse(null);
		}

	public void deletePOI(Integer id) {
		repo.deleteById(id);
		}
	//cria um novo ponto de interesse
    public void createPOI(POIs poi){
        repo.save(poi);
    }
    
    //retorna os pontos proximos ao POI informado com base na distancia maxima
    //função 'distanceBetweenPOIs' implementada na classe 'POIs'
    public List<String> getPOIsNearby(POIs poiReference, double maxDistance){
        
    	List<POIs> nearbyPOIs = getAllPOIs().stream().filter(poi -> poiReference.distanceBetweenPOIs(poi) <= maxDistance).collect(Collectors.toList());
        //percorrer os POIs encontrados e reotornar somente os nomes
        List<String> namePOIs = new ArrayList<>();
        for (POIs np : nearbyPOIs) {
        	namePOIs.add(np.getNome());
        }
        return namePOIs;
    }
	
	
}
