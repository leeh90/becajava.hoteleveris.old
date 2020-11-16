package br.hoteleveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.TipoQuartoRepository;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class TipoQuartoService {

	@Autowired
	final TipoQuartoRepository _repository;

	public TipoQuartoService(TipoQuartoRepository repository) {
		_repository = repository;
	}

	public BaseResponse inserir(TipoQuartoRequest tipoQuartoRequest) {
		TipoQuarto tipoQuarto = new TipoQuarto();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (tipoQuarto.getDescricao().equals("")) {
			base.Message = "Preencha o campo descrição.";
		}
		if (tipoQuarto.getValor() == 0) {
			base.Message = "Valor inválido.";
		}
		return base;
	}

//	if (tipoQuarto.getId() == null || tipoQuarto.getId() <= 0) {
//	base.Message = "O ID do Tipo Quarto é inválido ou não existe.";
//}
}
