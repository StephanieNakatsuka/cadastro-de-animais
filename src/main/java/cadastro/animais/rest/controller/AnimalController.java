package cadastro.animais.rest.controller;

import cadastro.animais.rest.entity.Animal;
import cadastro.animais.rest.repository.AnimalRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalRepository repository;

    // LISTAR TODOS
    @GetMapping
    public List<Animal> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Animal> buscarPorId(@PathVariable UUID id) {

        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CADASTRAR
    @PostMapping
    public ResponseEntity<Animal> cadastrar(@RequestBody @Valid Animal animal) {

        Animal novoAnimal = repository.save(animal);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoAnimal);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Animal> atualizar(
            @PathVariable UUID id,
            @RequestBody Animal animalAtualizado) {

        return repository.findById(id)
                .map(animal -> {

                    animal.setNome(animalAtualizado.getNome());
                    animal.setIdade(animalAtualizado.getIdade());
                    animal.setCor(animalAtualizado.getCor());
                    animal.setEspecie(animalAtualizado.getEspecie());

                    Animal animalSalvo = repository.save(animal);

                    return ResponseEntity.ok(animalSalvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable UUID id) {

        return repository.findById(id)
                .map(animal -> {

                    repository.delete(animal);

                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}