package br.com.abacaxi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.abacaxi.entity.Abacaxi;
import br.com.abacaxi.repository.AbacaxiRepository;

@Service
public class AbacaxiService {

	@Autowired
	AbacaxiRepository abacaxiRepository;
	
	public List<Abacaxi> getAll(){
		return abacaxiRepository.findAll();
	}
	
	public Optional<Abacaxi> getOne( Long id){
			return abacaxiRepository.findById(id);
	}
	
	public List<Abacaxi> getByOrigin(String origin){
		return abacaxiRepository.findAbacaxiByOrigin(origin);
	}
	
	
	
}
