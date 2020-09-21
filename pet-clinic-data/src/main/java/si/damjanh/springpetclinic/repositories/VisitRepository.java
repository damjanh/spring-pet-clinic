package si.damjanh.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import si.damjanh.springpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
