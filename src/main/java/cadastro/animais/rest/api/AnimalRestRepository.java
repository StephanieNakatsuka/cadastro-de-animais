package cadastro.animais.rest.api;

import cadastro.animais.rest.entity.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(
        path = "animal",
        collectionResourceRel =  "animal"
)
public interface AnimalRestRepository extends CrudRepository<Animal, UUID> {
}
