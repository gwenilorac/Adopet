package br.com.alura.adopet.api.validacoes;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.gwenilorac.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.gwenilorac.adopet.api.exception.ValidacaoException;
import br.com.gwenilorac.adopet.api.model.StatusAdocao;
import br.com.gwenilorac.adopet.api.repository.AdocaoRepository;
import br.com.gwenilorac.adopet.api.validacoes.ValidacaoPetComAdocaoEmAndamento;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ValidacaoPetComAdocaoEmAndamentoTest {

    @InjectMocks
    private ValidacaoPetComAdocaoEmAndamento validador;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void naoDeveriaPermitirSolicitacaoDeAdocaoDePetComPedidoEmAndamento() {
        //Arrange
        given(adocaoRepository.existsByPetIdAndStatus(
                dto.idPet(),
                StatusAdocao.AGUARDANDO_AVALIACAO)
        ).willReturn(true);

        //Act + Assert
        assertThrows(ValidacaoException.class, () -> validador.validar(dto));
    }

    @Test
    void deveriaPermitirSolicitacaoDeAdocaoDePetComPedidoInexistente() {
        //Arrange
        given(adocaoRepository.existsByPetIdAndStatus(
                dto.idPet(),
                StatusAdocao.AGUARDANDO_AVALIACAO
        )).willReturn(false);

        //Act + Assert
        assertDoesNotThrow(()->validador.validar(dto));
    }

}