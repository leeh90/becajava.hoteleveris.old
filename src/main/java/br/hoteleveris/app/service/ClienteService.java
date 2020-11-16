package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.response.ClienteResponse;
import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class ClienteService {

	@Autowired
	final ClienteRepository _repository;

	public ClienteService(ClienteRepository repository) {
		_repository = repository;

	}

	public BaseResponse inserir(ClienteRequest request) {

		if (request.getNome().equals(""))
			return new BaseResponse(400, "Preencha o campo Nome.");
		if (request.getCpf().equals(""))
			return new BaseResponse(400, "Preencha o campo Cpf.");
		if (request.getHash().equals(""))
			return new BaseResponse(400, "Preencha o campo Hash.");

		Cliente cliente = new Cliente();

		cliente.setNome(request.getNome());
		cliente.setCpf(request.getCpf());
		cliente.setHash(request.getHash());

		_repository.save(cliente);
		return new BaseResponse(201, "Inserido com sucesso.");

	}

	public ClienteResponse obter(Long id) {
		ClienteResponse response = new ClienteResponse();
	
		
		if (_repository.existsById(id) == false || id == null) {
			return new ClienteResponse(404, "Nenhum registro encontrado.");
		}
		
		Optional<Cliente> cliente = _repository.findById(id);

		response.setStatusCode(200);
		response.setMessage("Registro localizado com sucesso.");
		response.setId(cliente.get().getId());
		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());
		return response;

	}

}
