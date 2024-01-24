package br.com.gwenilorac.adopet.api.validacoes;

import br.com.gwenilorac.adopet.api.dto.SolicitacaoAdocaoDto;

public interface ValidacaoSolicitacaoAdocao {

    void validar(SolicitacaoAdocaoDto dto);

}
