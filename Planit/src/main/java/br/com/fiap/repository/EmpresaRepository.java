package br.com.fiap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	List<Empresa> findByFavorito(boolean favorito);

	List<Empresa> findBySegmento(String segmento);

}
