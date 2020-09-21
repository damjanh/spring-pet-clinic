package si.damjanh.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import si.damjanh.springpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
