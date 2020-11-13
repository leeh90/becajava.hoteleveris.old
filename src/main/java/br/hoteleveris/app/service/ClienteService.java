package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.response.ClienteResponse;
import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.repository.ClienteRepository;
import br.hoteleveris.app.request.ClienteRequest;
import br.hoteleveris.app.response.BaseResponse;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository _repository;

	public ClienteService(ClienteRepository repository) {
		_repository = repository;

	}

	public BaseResponse inserir(ClienteRequest clienteRequest) {
		Cliente cliente = new Cliente();
		BaseResponse base = new BaseResponse();
		base.StatusCode = 400;

		if (clienteRequest.getNome().equals("")) {
			base.Message = "Preencha o campo nome.";
			return base;
		}

		if (clienteRequest.getCpf().equals("")) {
			base.Message = "Preencha o campo Cpf.";
			return base;
		}

		if (clienteRequest.getHash().equals("")) {
			base.Message = "Preencha o campo Hash.";
			return base;
		}

		cliente.setNome(clienteRequest.getNome());
		cliente.setCpf(clienteRequest.getCpf());
		cliente.setHash(clienteRequest.getHash());

		_repository.save(cliente);
		base.StatusCode = 201;
		base.Message = "Inserido com sucesso.";

		return base;
	}

	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = _repository.findById(id);		
		ClienteResponse response = new ClienteResponse();
		
		if (cliente.get().getId().equals("") || (cliente.get().getId() <= 0 )){
			response.Message = "Cliente não encontrado";
			response.StatusCode = 404;
			return response;
		}
		
		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());

		response.Message = "Cliente obtido com sucesso";
		response.StatusCode = 200;
		return response;
	}

}
