package br.com.alura.Petshop_api.repository;

import br.com.alura.Petshop_api.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
