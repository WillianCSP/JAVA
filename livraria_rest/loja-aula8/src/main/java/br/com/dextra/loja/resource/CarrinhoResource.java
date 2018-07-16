package br.com.dextra.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.thoughtworks.xstream.XStream;

import br.com.dextra.loja.dao.CarrinhoDAO;
import br.com.dextra.loja.modelo.Carrinho;
import br.com.dextra.loja.modelo.Produto;

@Path("carrinhos")
public class CarrinhoResource {

	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@PathParam("id") long id) {
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		return carrinho.toXML();
	}

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response adiciona(String conteudo) {
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		new CarrinhoDAO().adiciona(carrinho);
		URI uri = URI.create("/carrinhos/" + carrinho.getId());
		return Response.created(uri).build();
	}
	
	@Path("{id}/produtos/{produtoId}")
	@DELETE
	public Response removeProdudo(@PathParam("id") long id, @PathParam("produtoId") long produtoId){
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		carrinho.remove(produtoId);
		return Response.ok().build();
	}
	
	
	@Path("{id}")
	@DELETE
	public Response removeCarrinho(@PathParam("id") long id) {
		new CarrinhoDAO().remove(id);
		return Response.ok().build();
	}
	
	@Path("{id}/produtos/{produtoId}")
	@PUT
	public Response alteraProduto(String novoProduto,@PathParam("id") long id, @PathParam("produtoId") long produtoId) {
		
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		Produto produto = (Produto) new XStream().fromXML(novoProduto);
		carrinho.troca(produto);
		return Response.ok().build();
	}
	
	
	@Path("{id}/produtos/{produtoId}/quantidade")
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public Response alteraQuantidadeProduto(String novaQuantidadeProduto,@PathParam("id") long id, 
			@PathParam("produtoId") long produtoId) {
		
		Carrinho carrinho = new CarrinhoDAO().busca(id);
		Produto produto = (Produto) new XStream().fromXML(novaQuantidadeProduto);
		carrinho.trocaQuantidade(produto);
		return Response.ok().build();
	}
	
}