package br.com.criandoapi.projeto.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.DAO.IUsuario;
import br.com.criandoapi.projeto.DTO.UsuarioDto;
import br.com.criandoapi.projeto.entity.Usuario;
import br.com.criandoapi.projeto.security.Token;
import br.com.criandoapi.projeto.security.TokenUtil;
import jakarta.validation.Valid;

@Service
public class UsuarioService {
	private IUsuario repository;
	private PasswordEncoder passwordEncoder;
	
	public UsuarioService (IUsuario repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public List<Usuario> listarUsuario () {
		return repository.findAll();
	}
	
	public Usuario criarUsuario (Usuario usuarioNovo) {
		String encoder = this.passwordEncoder.encode(usuarioNovo.getPassword());
		usuarioNovo.setPassword(encoder);
		return repository.save(usuarioNovo);
	}
	
	public Usuario editarUsuario (Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getPassword());
		usuario.setPassword(encoder);
		return repository.save(usuario);
	}
	
	public void excluirUsuario (int id) {
		repository.deleteById(id);
	}

	public Boolean validarSenha(Usuario user) {
		String password = repository.getReferenceById(user.getId()).getPassword();
		return passwordEncoder.matches(user.getPassword(), password);
	}

	public Token gerarToken(@Valid UsuarioDto user) {
		Usuario usuario = repository.findByNameOrEmail(user.getUsername(), user.getEmail());
		if (usuario != null) {
			Boolean valid = passwordEncoder.matches(user.getPassword(), usuario.getPassword());
			if (valid) {
				return new Token(TokenUtil.createToken(usuario));
			}
		}
		return null;
	}
}
