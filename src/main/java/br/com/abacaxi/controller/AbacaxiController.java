package br.com.abacaxi.controller;

import java.util.List;
import java.util.Optional;

import javax.lang.model.util.Elements.Origin;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.abacaxi.dto.AbacaxiDTO;
import br.com.abacaxi.entity.Abacaxi;
import br.com.abacaxi.enums.AbacaxiStatusEnum;
import br.com.abacaxi.repository.AbacaxiRepository;
import br.com.abacaxi.service.AbacaxiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Abacaxi", description = "API gerenciamento Abacaxis")
@RestController
public class AbacaxiController {



	@Autowired
	AbacaxiService abacaxiService;

	@Operation(summary = "Buscar todos os abacaxis", description = "Obeter todos os abacaxis nesse endpoint.", tags = {"", "" })
	@ApiResponses({
			@ApiResponse(responseCode = "200",  content = { @Content(schema = @Schema(implementation = Abacaxi.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			// @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
	})
	
						//	@GetMapping("/abacaxi")
						//	public ResponseEntity<List<Abacaxi>> getAllAbacaxis() {
						//		return ResponseEntity.status(HttpStatus.OK).body(abacaxiRepository.findAll());
						//	}
	
	@GetMapping("/abacaxi")
	public ResponseEntity<List<Abacaxi>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(abacaxiService.getAll());
	}
	


	@Operation(summary = "Buscar um abacaxi por id", description = "Obter um abacaxi passando seu id")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Abacaxi.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }) })
	
							//	@GetMapping("/abacaxi/{id}")
							//	public ResponseEntity<Object> getAbacaxi(@PathVariable Long id) {
							//		Optional<Abacaxi> abacaxiOptional = abacaxiRepository.findById(id);
							//		if (abacaxiOptional.isEmpty()) {
							//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Abacaxi Not Found");
							//		}
							//		return ResponseEntity.status(HttpStatus.OK).body(abacaxiOptional.get());
							//	}
	
	@GetMapping("/abacaxi/{id}")
	public ResponseEntity<Object> getAbacaxi(@PathVariable Long id) {
		Optional<Abacaxi> abacaxiOptional = abacaxiService.getOne(id);
		if(abacaxiOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body( String.format("Abacaxi id: %d Not Found", id));
		}
		return ResponseEntity.status(HttpStatus.OK).body(abacaxiOptional.get());
	}
	

	@Operation(summary = "Buscar todos os abacaxis passando um país de origem", description = "Todos abacaxis por origem")
	@GetMapping("/abacaxi/origin/{contry}")
					//	public List<Abacaxi> getAbacaxiByOrigin(@PathVariable String contry) {
					//		return abacaxiRepository.findAbacaxiByOrigin(contry);
					//	}
	
	public ResponseEntity<List<Abacaxi>>  getAbacaxiByOrigin(@PathVariable String contry){
		return ResponseEntity.status(HttpStatus.OK).body(abacaxiService.getByOrigin(contry));
	}
	
	
//	
//	@Operation(summary = "Buscar todos os abacaxis que não é de origem BR", description = "Todos abacaxis por que não são do Brasil")
//	@GetMapping("/abacaxi/origin/importados")
//	public List<Abacaxi> getAbacaxiWhereNotBrazil(){
//		return abacaxiRepository.findAbacaxiWhereNotBrazil();
//	}
//	
//	@Operation(summary = "Buscar todos os abacaxis a partir de um determinado preco", description = "Todos abacaxis a partir de um preco")
//	@GetMapping("/abacaxi/buscar/{price}")
//	public List<Abacaxi> getAbacaxiByPrice(@PathVariable Float price){
//		return abacaxiRepository.findAbacaxiByPrice(price);
//	}
//
//
//	@Operation(summary = "Criar um novo abacaxi", description = "Enviar e cadastrar novo abacaxi")
//	@PostMapping("/abacaxi")
//	public ResponseEntity<Abacaxi> saveAbacaxi(@RequestBody @Valid AbacaxiDTO abacaxiDTO) {
//		var abacaxi = new Abacaxi();
//		abacaxi.setStatus(AbacaxiStatusEnum.ATIVADO);
//		BeanUtils.copyProperties(abacaxiDTO, abacaxi);
//		return ResponseEntity.status(HttpStatus.CREATED).body(abacaxiRepository.save(abacaxi));
//	}
//
//	@Operation(summary = "Atualizar um abacaxi", description = "Realizar a atualização dos dados de uma abacaxi passando o id")
//	@PutMapping("/abacaxi/update/{id}")
//	public Abacaxi updateAbacaxi(@PathVariable Long id, @RequestBody Abacaxi upAbacaxi) {
//		var abacaxi = abacaxiRepository.findById(id).get();
//		abacaxi.setName(upAbacaxi.getName());
//		abacaxi.setPrice(upAbacaxi.getPrice());
//		abacaxi.setOrigin(upAbacaxi.getOrigin());
//		abacaxiRepository.save(abacaxi);
//		return abacaxi;
//	}
//
//	@Operation(summary = "Deletar abacaxi por id", description = "Deletar um abacaxi por id")
//	@DeleteMapping("/abacaxi/delete/{id}")
//	public void deleteAbacaxi(@PathVariable Long id) {
//		var abacaxi = abacaxiRepository.findById(id).get();
//		abacaxiRepository.delete(abacaxi);
//	}

}
