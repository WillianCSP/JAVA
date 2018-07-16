package br.com.dextra.loja;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import junit.framework.Assert;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.net.MediaType;
import com.thoughtworks.xstream.XStream;

import br.com.dextra.loja.modelo.Carrinho;
import br.com.dextra.loja.modelo.Produto;

public class ClientTest {

	private HttpServer server;

	@Before
	public void inicializaServidor(){
		this.server = Servidor.inicializaServidor();
	}
	
	@After
	public void paraServidor(){
		server.stop();
	}
	
	@Test
	public void testaQueBuscarUmCarrinhoTrazOCarrinhoEsperado() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		String conteudo = target.path("/carrinhos/1").request().get(String.class);
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		Assert.assertEquals("Polo de Tecnologia", carrinho.getRua());

	}
	
	@Test
	public void testaCriacaoNovoCarrinho() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Carrinho carrinho = new Carrinho();
		Produto produto = new Produto(3, "Cerveja Bohemia", 3.5, 1);
		
		carrinho.adiciona(produto);
		carrinho.setCidade("Campinas");
		carrinho.setId(2);
		carrinho.setRua("Polis");
		
		String converteCarrinhoXML = carrinho.toXML();
		
		Entity<String> entity = Entity.entity(converteCarrinhoXML, javax.ws.rs.core.MediaType.APPLICATION_XML);
		
		Response response = target.path("/carrinhos").request().post(entity);
		Assert.assertEquals(201, response.getStatus());
	}
}
