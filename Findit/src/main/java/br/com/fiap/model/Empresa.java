package br.com.fiap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String segmento;

	@Column(nullable = false)
	private String endereco;

	@Column(nullable = false)
	private double km;

	private boolean favorito;

	public Empresa() {
	}

	public Empresa(String nome, String segmento, String endereco, double km, boolean favorito) {
		this.nome = nome;
		this.segmento = segmento;
		this.endereco = endereco;
		this.km = km;
		this.favorito = favorito;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", segmento=" + segmento + ", endereco=" + endereco + ", km="
				+ km + ", favorito=" + favorito + "]";
	}
}
