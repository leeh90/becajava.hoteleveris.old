package br.hoteleveris.app.controller;

import br.hoteleveris.app.response.BaseResponse;

public class BaseController {
	
	public BaseResponse errorBase = new BaseResponse();
	
	public BaseController() {
		errorBase.StatusCode = 500;
		errorBase.Message = "Ocorreu um erro inesperado. Contate o administrador";
	}


}
