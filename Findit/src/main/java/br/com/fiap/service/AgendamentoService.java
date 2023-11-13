package br.com.fiap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.exception.AgendamentoNotFoundException;
import br.com.fiap.model.Agendamento;
import br.com.fiap.repository.AgendamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    @Autowired
    public AgendamentoService(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    public Agendamento criarAgendamento(Agendamento agendamentoRequest) {
        Agendamento novoAgendamento = new Agendamento(
            agendamentoRequest.getEmpresa(),
            agendamentoRequest.getDataHora()
        );
        return agendamentoRepository.save(novoAgendamento);
    }

    public List<Agendamento> listarAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public Agendamento atualizarAgendamento(Long id, Agendamento agendamentoRequest) {
        Optional<Agendamento> agendamentoOptional = agendamentoRepository.findById(id);

        if (agendamentoOptional.isPresent()) {
            Agendamento agendamento = agendamentoOptional.get();
            agendamento.setEmpresa(agendamentoRequest.getEmpresa());
            agendamento.setDataHora(agendamentoRequest.getDataHora());
            return agendamentoRepository.save(agendamento);
        } else {
            throw new AgendamentoNotFoundException("Agendamento não encontrado com o ID: " + id);
        }
    }

    public void excluirAgendamento(Long id) {
        if (agendamentoRepository.existsById(id)) {
            agendamentoRepository.deleteById(id);
        } else {
            throw new AgendamentoNotFoundException("Agendamento não encontrado com o ID: " + id);
        }
    }
    
}
