package br.com.alura.adopet.api.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.gwenilorac.adopet.api.model.Abrigo;
import br.com.gwenilorac.adopet.api.model.Adocao;
import br.com.gwenilorac.adopet.api.model.Pet;
import br.com.gwenilorac.adopet.api.repository.AbrigoRepository;
import br.com.gwenilorac.adopet.api.repository.PetRepository;
import br.com.gwenilorac.adopet.api.service.AbrigoService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AbrigoServiceTest {

    @InjectMocks
    private AbrigoService service;

    @Mock
    private AbrigoRepository repository;

    @Mock
    private Abrigo abrigo;

    @Mock
    private PetRepository petRepository;

    @Test
    void deveriaChamarListaDeTodosOsAbrigos() {
        //Act
        service.listar();

        //Assert
        then(repository).should().findAll();
    }

    @Test
    void deveriaChamarListaDePetsDoAbrigoAtravesDoNome() {
        //Arrange
        String nome = "Miau";
        given(repository.findByNome(nome)).willReturn(Optional.of(abrigo));

        //Act
        service.listarPetsDoAbrigo(nome);

        //Assert
        then(petRepository).should().findByAbrigo(abrigo);
    }

}