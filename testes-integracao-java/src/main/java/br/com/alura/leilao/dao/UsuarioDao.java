package br.com.alura.leilao.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.alura.leilao.model.Usuario;

//Notação do Spring para conseguirmos injetar essa classe em um controller
@Repository
//Não herda nem implementa nenhuma interface
public class UsuarioDao {

	//Atributo da interface JPA que faz oacesso ao banco de dados
	//Notaço para ser injetado automaticamente
	@PersistenceContext
	private EntityManager em;

	//Método para busca de usuário
	public Usuario buscarPorUsername(String username) {
		//Faz uma query utilizando o JPQL
		return em.createQuery("SELECT u FROM Usuario u WHERE u.nome = :username", Usuario.class)
				//Faz a consulta buscando um usuário que tem esse username que foi passado como parâmetro
				.setParameter("username", username)
				.getSingleResult();
	}

	//Método excluir um usuário
	public void deletar(Usuario usuario) {
		em.remove(usuario);
	}

}
