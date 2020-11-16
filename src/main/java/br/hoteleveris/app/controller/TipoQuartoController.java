package br.hoteleveris.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.hoteleveris.app.request.TipoQuartoList;
import br.hoteleveris.app.request.TipoQuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;
import br.hoteleveris.app.service.TipoQuartoService;

@RestController
@RequestMapping("/tipoQuartos")
public class TipoQuartoController extends BaseController {

	@Autowired
	private TipoQuartoService _service;

	@PostMapping
	public ResponseEntity inserir(TipoQuartoRequest request) {
		try {
			BaseResponse response = _service.inserir(request);
			return ResponseEntity.status(response.getStatusCode()).body(response);

		} catch (Exception e) {
			return ResponseEntity.status(errorBase.getStatusCode()).body(errorBase);

		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity obter(@PathVariable Long id) {
		List<TipoQuartoResponse> tipoQuartos = new ArrayList<TipoQuartoResponse>();
		try {
			TipoQuartoResponse response = _service.obter(id);
			return ResponseEntity.status(response.getStatusCode()).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.getStatusCode()).body(errorBase);

		}

	}

	@GetMapping
	public ResponseEntity listar() {
		try {
			List<TipoQuartoResponse> quarto = new ArrayList<TipoQuartoResponse>();
			TipoQuartoList tipoQuarto = _service.listar();

			return ResponseEntity.status(200).body(tipoQuarto);

		} catch (Exception e) {
			return ResponseEntity.status(errorBase.getStatusCode()).body(errorBase);

		}

	}

}
