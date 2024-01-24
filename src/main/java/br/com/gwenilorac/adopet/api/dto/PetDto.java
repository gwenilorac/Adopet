package br.com.gwenilorac.adopet.api.dto;

import br.com.gwenilorac.adopet.api.model.Pet;
import br.com.gwenilorac.adopet.api.model.TipoPet;

public record PetDto(Long id, TipoPet tipo, String nome, String raca, Integer idade) {

    public PetDto(Pet pet) {
        this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade());
    }

}
