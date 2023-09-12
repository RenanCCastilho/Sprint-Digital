package br.com.fiap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.exception.EmpresaNotFoundException;
import br.com.fiap.model.Empresa;
import br.com.fiap.repository.EmpresaRepository;

@Service
public class EmpresaService {

	private final EmpresaRepository empresaRepository;

	@Autowired
	public EmpresaService(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}

	public Empresa criarEmpresa(String nome, String segmento, String endereco, double km, boolean favorito) {
		Empresa novaEmpresa = new Empresa(nome, segmento, endereco, km, favorito);
		return empresaRepository.save(novaEmpresa);
	}

	public List<Empresa> listarEmpresas() {
		return empresaRepository.findAll();
	}

	public Empresa atualizarEmpresa(Long id, Empresa empresaRequest) {

		Optional<Empresa> empresaOptional = empresaRepository.findById(id);

		if (empresaOptional.isPresent()) {
			Empresa empresa = empresaOptional.get();

			empresa.setNome(empresaRequest.getNome());
			empresa.setSegmento(empresaRequest.getSegmento());
			empresa.setEndereco(empresaRequest.getEndereco());
			empresa.setKm(empresaRequest.getKm());
			empresa.setFavorito(empresaRequest.isFavorito());

			return empresaRepository.save(empresa);
		} else {

			throw new EmpresaNotFoundException("Empresa não encontrada com o ID: " + id);
		}
	}

	public void excluirEmpresa(Long id) {

		if (empresaRepository.existsById(id)) {
			empresaRepository.deleteById(id);
		} else {

			throw new EmpresaNotFoundException("Empresa não encontrada com o ID: " + id);
		}
	}

}
