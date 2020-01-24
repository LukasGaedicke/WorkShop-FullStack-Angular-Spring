package com.example.comercial.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.comercial.model.Oportunidade;
import com.example.comercial.repository.OportunidadeRepository;

@Service
public class OportunidadeService {

	@Autowired
	private OportunidadeRepository oportunidadeRepository;

	public Oportunidade atualizar(Long codigo, Oportunidade oportunidade) {

		//Vai até o banco de dados e verifica se existe essa oportunidade
		Oportunidade novaOportunidade = this.oportunidadeRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		//Faz uma cópia das prop para uma nova oportunidade
		//fonte,() novoObj, o que ignorar
		BeanUtils.copyProperties(oportunidade, novaOportunidade, "id");
		return oportunidadeRepository.save(novaOportunidade);
	}
}
