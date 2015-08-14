package br.com.marcell.servico.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.marcell.entidade.rest.Estudante;

@Path("/restServico")
public class RestServico {

	@GET
	@Path("/print/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public Estudante produceJSON( @PathParam("nome") String nome ) {
		Estudante estudante = new Estudante();
		estudante.setId(1);
		estudante.setIdade(25);
		estudante.setNome("Marcell");
		estudante.setSobrenome("Coelho");
		return estudante;

	}
	
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consumeJSON(Estudante estudante) {
		String output = estudante.toString();
		return Response.status(200).entity(output).build();
	}


}
