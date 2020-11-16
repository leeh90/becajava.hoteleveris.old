package br.hoteleveris.app.response;

public class TipoQuartoResponse extends BaseResponse {

	private Long id;
	private String descricao;
	private double valor;

	public TipoQuartoResponse() {

	}

	public TipoQuartoResponse(int statusCode, String message) {
		setStatusCode(statusCode);
		setMessage(message);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
