package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.service.AgendamentoService;
import br.com.fiap.model.Agendamento;
import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

	private final AgendamentoService agendamentoService;

	@Autowired
	public AgendamentoController(AgendamentoService agendamentoService) {
		this.agendamentoService = agendamentoService;
	}

	@PostMapping
	public Agendamento criarAgendamento(@RequestBody Agendamento agendamentoRequest) {
		return agendamentoService.criarAgendamento(agendamentoRequest);
	}

	@GetMapping
	public List<Agendamento> listarAgendamentos() {
		return agendamentoService.listarAgendamentos();
	}

	@PutMapping("/{id}")
	public Agendamento atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamentoRequest) {
		return agendamentoService.atualizarAgendamento(id, agendamentoRequest);
	}

	@DeleteMapping("/{id}")
	public void excluirAgendamento(@PathVariable Long id) {
		agendamentoService.excluirAgendamento(id);
	}

}
