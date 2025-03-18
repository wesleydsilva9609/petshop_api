package br.com.alura.Petshop_api;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroPet(@RequestBody DadosCadastroPet dadosCadastroPet, UriComponentsBuilder uriComponentsBuilder){
        return service.cadastro(dadosCadastroPet,uriComponentsBuilder);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPet>> buscarPets(@PageableDefault(size = 5, sort = "id")Pageable pageable) {
        return service.buscarPets(pageable);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePorID(@PathVariable Long id){
        return service.deletar(id);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarPetPorId(@PathVariable Long id,@RequestBody DadosPetAtualizado dadosPetAtualizado){
        return service.atualizarPet(id,dadosPetAtualizado);
    }


}
