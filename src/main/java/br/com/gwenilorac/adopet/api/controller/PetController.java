package br.com.gwenilorac.adopet.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gwenilorac.adopet.api.dto.PetDto;
import br.com.gwenilorac.adopet.api.service.PetService;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public ResponseEntity<List<PetDto>> listarTodosDisponiveis() {
        List<PetDto> pets = service.buscarPetsDisponiveis();
        return ResponseEntity.ok(pets);
    }

}
