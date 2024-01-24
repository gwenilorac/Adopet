package br.com.gwenilorac.adopet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gwenilorac.adopet.api.model.Adocao;
import br.com.gwenilorac.adopet.api.model.StatusAdocao;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    boolean existsByPetIdAndStatus(Long idPet, StatusAdocao status);

    boolean existsByTutorIdAndStatus(Long idPet, StatusAdocao status);

    Integer countByTutorIdAndStatus(Long idTutor, StatusAdocao status);

}
