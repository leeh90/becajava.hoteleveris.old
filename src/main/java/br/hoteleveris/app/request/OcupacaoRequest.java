package br.hoteleveris.app.request;

import java.util.Date;

public class OcupacaoRequest {

	private Date data;
	private int qtdeDiarias;
	private String situacao;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQtdeDiarias() {
		return qtdeDiarias;
	}

	public void setQtdeDiarias(int qtdeDiarias) {
		this.qtdeDiarias = qtdeDiarias;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
