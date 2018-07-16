package br.dextra.managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;


import javax.faces.event.ActionEvent;

import br.dextra.modelo.Post;


@ManagedBean
@SessionScoped
public class PostBean {

	private List<Post> posts = new ArrayList<Post>() ;
	private Post post = new Post();

	public void adicionaPost() {
		Date dataCriacao = new Date();	
		this.post.setDataCriacao(dataCriacao.toString());
		
		this.posts.add(this.post);
		this.post = new Post();
			
		
		FacesMessage msg = new FacesMessage("Post Adicionado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	
	public void delete(Post post) {
		this.posts.remove(post);
	}
	
	public List<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	
}
