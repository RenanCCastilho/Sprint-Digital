package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.fiap.exception.UsuarioNotFoundException;
import br.com.fiap.model.Usuario;
import br.com.fiap.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario criarUsuario(String nome, String telefone, String email, String cpf) {
		Usuario novoUsuario = new Usuario(nome, telefone, email, cpf);
		return usuarioRepository.save(novoUsuario);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario atualizarUsuario(Long id, Usuario usuarioRequest) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);

		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();

			usuario.setNome(usuario.getNome());
			usuario.setTelefone(usuarioRequest.getTelefone());
			usuario.setEmail(usuarioRequest.getEmail());
			usuario.setCpf(usuarioRequest.getCpf());

			return usuarioRepository.save(usuario);
		} else {
			throw new UsuarioNotFoundException("Usuario não encontrado com o ID: " + id);
		}
	}

	public void excluirUsuario(Long id) {

		if (usuarioRepository.existsById(id)) {
			usuarioRepository.deleteById(id);
		} else {
			throw new UsuarioNotFoundException("Usuario não encontrado com o ID: " + id);
		}
	}
}
