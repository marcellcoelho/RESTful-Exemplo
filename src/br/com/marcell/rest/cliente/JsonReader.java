package br.com.marcell.rest.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class JsonReader {
	
	public static final int SUCESSO_200 = 200;

	public static String readUrl(String url, RequestMethodEnum methodEnum) throws IOException {

		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod(methodEnum.getValor());
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != SUCESSO_200) {
			return String.valueOf(conn.getResponseCode());
		}

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		StringBuilder builder = new StringBuilder();
		String retornoJson = null;
		while ((retornoJson = bufferedReader.readLine()) != null) {
			builder.append(retornoJson);
		};
		bufferedReader.close();
		return builder.toString();
	}

}