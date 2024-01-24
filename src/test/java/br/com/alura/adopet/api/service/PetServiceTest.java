package br.com.alura.adopet.api.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.gwenilorac.adopet.api.dto.CadastroPetDto;
import br.com.gwenilorac.adopet.api.dto.PetDto;
import br.com.gwenilorac.adopet.api.model.Abrigo;
import br.com.gwenilorac.adopet.api.model.Pet;
import br.com.gwenilorac.adopet.api.repository.PetRepository;
import br.com.gwenilorac.adopet.api.service.PetService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class PetServiceTest {

    @InjectMocks
    private PetService service;

    @Mock
    private CadastroPetDto cadastroPetDto;

    @Mock
    private PetRepository repository;

    @Mock
    private Abrigo abrigo;

    @Test
    void deveriaCadastrarPet() {
        //Act
        service.cadastrarPet(abrigo,cadastroPetDto);

        //Assert
        then(repository).should().save(new Pet(cadastroPetDto,abrigo));
    }

    @Test
    void deveriaRetornarTodosOsPetsDisponiveis() {
        //Act
        service.buscarPetsDisponiveis();

        //Assert
        then(repository).should().findAllByAdotadoFalse();
    }

}