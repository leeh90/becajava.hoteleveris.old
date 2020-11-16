package br.hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.request.TipoQuartoList;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

@Service
public class TipoQuartoService {

	@Autowired
	private TipoQuartoRepository _repository;

	public BaseResponse inserir(TipoQuartoRequest request) {

		if (request.getDescricao().equals(""))
			return new BaseResponse(400, "Preencha o campo Descrição.");

		if (request.getValor() <= 0)
			return new BaseResponse(400, "Preencha o valor do tipo do quarto.");

		TipoQuarto tipoQuarto = new TipoQuarto();

		tipoQuarto.setDescricao(request.getDescricao());
		tipoQuarto.setValor(request.getValor());
		_repository.save(tipoQuarto);
		return new BaseResponse(201, "Tipo de quarto inserido com sucesso.");

	}

	public TipoQuartoResponse obter(Long id) {
		TipoQuartoResponse response = new TipoQuartoResponse();

		if (_repository.existsById(id) == false || id == null)
			return new TipoQuartoResponse(404, "Nenhum registro encontrado.");

		Optional<TipoQuarto> tipoQuarto = _repository.findById(id);

		response.setStatusCode(200);
		response.setMessage("Registro localizado com sucesso.");
		response.setId(tipoQuarto.get().getId());
		response.setDescricao(tipoQuarto.get().getDescricao());
		response.setValor(tipoQuarto.get().getValor());
		return response;

	}

	public TipoQuartoList listar() {
		
		List<TipoQuarto> tipoQuartos = _repository.findAll();
		
		TipoQuartoList response = new TipoQuartoList();
		response.setTipoQuartos(tipoQuartos);
		response.setStatusCode(200);
		response.setMessage("Registos localizados com sucesso.");
		return response;
	}

}
