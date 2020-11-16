package br.hoteleveris.app.request;

public class ClienteRequest {

	private String nome;
	private String cpf;
	private String hash;

	public ClienteRequest() {
		
	}

	public ClienteRequest(String nome, String cpf, String hash) {
		this.nome = nome;
		this.cpf = cpf;
		this.hash = hash;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

}
