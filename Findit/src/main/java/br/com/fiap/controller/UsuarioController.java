package br.com.fiap.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.model.Usuario;
import br.com.fiap.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping
	public Usuario criarUsuario(@RequestBody Usuario usuarioRequest) {
		return usuarioService.criarUsuario(usuarioRequest.getNome(), usuarioRequest.getTelefone(),
				usuarioRequest.getEmail(), usuarioRequest.getCpf());
	}

	@GetMapping
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}

	@PutMapping("/{id}")
	public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioRequest) {
		return usuarioService.atualizarUsuario(id, usuarioRequest);
	}

	@DeleteMapping("/{id}")
	public void exlcuirUsuario(@PathVariable Long id) {
		usuarioService.excluirUsuario(id);
	}
}
