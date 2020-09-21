package si.damjanh.springpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import java.security.acl.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
