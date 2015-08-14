package br.com.marcell.rest.cliente;

public enum RequestMethodEnum {
	
	GET("GET"),
	POST("POST"),
	HEAD("HEAD"),
	OPTIONS("OPTIONS"),
	PUT("PUT"),
	DELETE("DELETE"),
	TRACE("TRACE");

	private String valor;
	
	RequestMethodEnum(String descricao) {
		this.valor = descricao;
	}
	
	public String getValor() {
		return valor;
	}
	
}
