package si.damjanh.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import si.damjanh.springpetclinic.model.Pet;
import si.damjanh.springpetclinic.services.PetService;

import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet obj) {
        super.delete(obj);
    }

    @Override
    public Pet save(Pet obj) {
        return super.save(obj);
    }

    @Override
    public void deleteById(Long id) {
        super.delteById(id);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
