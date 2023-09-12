package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.model.Empresa;
import br.com.fiap.service.EmpresaService;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

	private final EmpresaService empresaService;

	@Autowired
	public EmpresaController(EmpresaService empresaService) {
		this.empresaService = empresaService;
	}

	@PostMapping
	public Empresa criarEmpresa(@RequestBody Empresa empresaRequest) {
		return empresaService.criarEmpresa(empresaRequest.getNome(), empresaRequest.getSegmento(),
				empresaRequest.getEndereco(), empresaRequest.getKm(), empresaRequest.isFavorito());
	}

	@GetMapping
	public List<Empresa> listarEmpresas() {
		return empresaService.listarEmpresas();
	}

	@PutMapping("/{id}")
	public Empresa atualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresaRequest) {
		return empresaService.atualizarEmpresa(id, empresaRequest);
	}

	@DeleteMapping("/{id}")
	public void excluirEmpresa(@PathVariable Long id) {
		empresaService.excluirEmpresa(id);
	}

}
