package si.damjanh.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import si.damjanh.springpetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
