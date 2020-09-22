package si.damjanh.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import si.damjanh.springpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
