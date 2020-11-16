package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Comodidade;
import br.hoteleveris.app.repository.ComodidadeRepository;
import br.hoteleveris.app.request.ComodidadeList;
import br.hoteleveris.app.request.ComodidadeRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ComodidadeResponse;

@Service
public class ComodidadeService {

	@Autowired
	private ComodidadeRepository _repository;

	public BaseResponse inserir(ComodidadeRequest request) {
		if (request.getNome().equals(""))
			return new BaseResponse(400, "Preencha o nome.");

		Comodidade comodidade = new Comodidade();

		comodidade.setNome(request.getNome());
		_repository.save(comodidade);
		return new BaseResponse(201, "Inserido com sucesso.");
	}

	public ComodidadeResponse obter(Long id) {
		ComodidadeResponse response = new ComodidadeResponse();

		Optional<Comodidade> comodidade = _repository.findById(id);

		response.setStatusCode(200);
		response.setMessage("Registro localizado com sucesso.");
		response.setId(comodidade.get().getId());
		response.setNome(comodidade.get().getNome());
		return response;

	}

	public ComodidadeList listar() {

		List<Comodidade> comodidades = _repository.findAll();

		ComodidadeList response = new ComodidadeList();
		response.setComodidades(comodidades);
		response.setStatusCode(200);
		response.setMessage("Registos localizados com sucesso.");
		return response;
	}

}
