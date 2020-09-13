package si.damjanh.springpetclinic.services.map;

import si.damjanh.springpetclinic.model.Owner;
import si.damjanh.springpetclinic.services.CrudService;

import java.util.Set;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner obj) {
        super.delete(obj);
    }

    @Override
    public Owner save(Owner obj) {
        return super.save(obj.getId(), obj);
    }

    @Override
    public void deleteById(Long id) {
        super.delteById(id);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
