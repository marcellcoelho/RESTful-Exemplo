package br.com.marcell.rest.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.marcell.entidade.rest.Estudante;

import com.google.gson.Gson;

public class JerseyClient {

	public static void main(String[] args) {
		String json = null;
		
		/*METODO GET*/
		try {
			json = JsonReader.readUrl("http://localhost:8080/JSON-Exemplo/rest/restServico/print/marcell", RequestMethodEnum.GET);
			System.out.println(json);
			Gson gson = new Gson();
			Estudante estudante = gson.fromJson(json, Estudante.class);
			System.out.println(estudante.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*METODO POST*/
		try {
			URL targetUrl = new URL("http://localhost:8080/JSON-Exemplo/rest/restServico/send");

			HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Content-Type", "application/json");

			
			String input = json;

			OutputStream outputStream = httpConnection.getOutputStream();
			outputStream.write(input.getBytes());
			outputStream.flush();

			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "+ httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream())));

			String output;
			while ((output = responseBuffer.readLine()) != null) {
				System.out.println(output);
			};

			httpConnection.disconnect();

		  } catch (MalformedURLException e) {
			e.printStackTrace();
		  } catch (IOException e) {
			e.printStackTrace();
		 }

	}

}
