package br.com.criandoapi.projeto.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.criandoapi.projeto.entity.Usuario;

public interface IUsuario extends JpaRepository<Usuario, Integer>{

	public Usuario findByNameOrEmail(String name, String email);

}
