package com.example.comercial.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.comercial.model.Oportunidade;
import com.example.comercial.repository.OportunidadeRepository;
import com.example.comercial.service.OportunidadeService;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

	@Autowired
	private OportunidadeRepository oportunidadeRepository;
	@Autowired
	private OportunidadeService oportunidadeService;

	@GetMapping
	public List<Oportunidade> listar() {
		return oportunidadeRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity listarOnlyOne(@PathVariable Long codigo) {
		Optional op = this.oportunidadeRepository.findById(codigo);
		return op.isPresent() ? ResponseEntity.ok(op.get()) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Oportunidade> salvar(@Valid @RequestBody Oportunidade oportunidade) {
		Oportunidade op = oportunidadeRepository.save(oportunidade);
		return ResponseEntity.status(HttpStatus.CREATED).body(op);
	}

	@PutMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Oportunidade> editar(@Valid @PathVariable Long codigo,
			@RequestBody Oportunidade oportunidade) {
		
		Oportunidade novaOportunidade = this.oportunidadeRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		BeanUtils.copyProperties(oportunidade, novaOportunidade, "id");
		return ResponseEntity.ok(this.oportunidadeRepository.save(novaOportunidade));

	}

	@DeleteMapping("/{codigo}")
	public String deletar(@PathVariable Long codigo) {
		oportunidadeRepository.deleteById(codigo);
		return "Deletado";
	}

}
