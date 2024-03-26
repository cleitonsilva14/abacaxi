package br.com.abacaxi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.abacaxi.entity.Abacaxi;

public interface AbacaxiRepository extends JpaRepository<Abacaxi, Long> {
	
	@Query(value="select * from tb_abacaxi a where a.origin = ?1",  nativeQuery=true)
	List<Abacaxi> findAbacaxiByOrigin(String origin);
	
	
	@Query(value = "select * from tb_abacaxi a where a.origin != 'Brazil'", nativeQuery = true)
	List<Abacaxi> findAbacaxiWhereNotBrazil();
	
	@Query(value = "select * from tb_abacaxi a where a.price >= ?1", nativeQuery = true)
	List<Abacaxi> findAbacaxiByPrice(Float price);
	
}
