package br.com.gwenilorac.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.gwenilorac.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.gwenilorac.adopet.api.exception.ValidacaoException;
import br.com.gwenilorac.adopet.api.model.Adocao;
import br.com.gwenilorac.adopet.api.model.StatusAdocao;
import br.com.gwenilorac.adopet.api.model.Tutor;
import br.com.gwenilorac.adopet.api.repository.AdocaoRepository;
import br.com.gwenilorac.adopet.api.repository.TutorRepository;

import java.util.List;

@Component
public class ValidacaoTutorComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        boolean tutorTemAdocaoEmAndamento = adocaoRepository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO);

        if (tutorTemAdocaoEmAndamento) {
            throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
        }
    }

}
