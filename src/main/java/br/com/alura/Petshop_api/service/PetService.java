package br.com.alura.Petshop_api.service;

import br.com.alura.Petshop_api.entity.Pet;
import br.com.alura.Petshop_api.repository.PetRepository;
import br.com.alura.Petshop_api.dto.pet.DadosCadastroPet;
import br.com.alura.Petshop_api.dto.pet.DadosDetalhamentoPet;
import br.com.alura.Petshop_api.dto.pet.DadosListagemPet;
import br.com.alura.Petshop_api.dto.pet.DadosPetAtualizado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PetService {
    @Autowired
    private PetRepository repository;

    public ResponseEntity cadastro(DadosCadastroPet dadosCadastroPet, UriComponentsBuilder uriComponentsBuilder) {
        var pet = new Pet(dadosCadastroPet);
        var uri = uriComponentsBuilder.path("/pet/{id}").buildAndExpand(dadosCadastroPet.id()).toUri();
        repository.save(pet);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPet(pet));
    }

    public ResponseEntity buscarPorId(Long id) {
        var pet = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoPet(pet));
    }

    public ResponseEntity<Page<DadosListagemPet>> buscarPets(Pageable pageable) {
        var page = repository.findAll(pageable).map(DadosListagemPet::new);
        return ResponseEntity.ok(page);
    }

    public ResponseEntity deletar(Long id) {
         repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity atualizarPet(Long id, DadosPetAtualizado dadosPetAtualizado) {
        var pet = repository.getReferenceById(id);
        pet.atualizar(dadosPetAtualizado);
        return  ResponseEntity.ok(new DadosDetalhamentoPet(pet));
    }
}
