package si.damjanh.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import si.damjanh.springpetclinic.model.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
