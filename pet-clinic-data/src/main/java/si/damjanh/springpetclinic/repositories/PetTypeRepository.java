package si.damjanh.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import si.damjanh.springpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
