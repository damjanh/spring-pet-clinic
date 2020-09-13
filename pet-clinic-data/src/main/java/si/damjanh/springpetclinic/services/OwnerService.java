package si.damjanh.springpetclinic.services;

import si.damjanh.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
