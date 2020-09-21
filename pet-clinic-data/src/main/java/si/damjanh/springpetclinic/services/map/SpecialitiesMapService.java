package si.damjanh.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import si.damjanh.springpetclinic.model.Speciality;
import si.damjanh.springpetclinic.services.SpecialitiesService;

import java.util.Set;

@Service
public class SpecialitiesMapService extends AbstractMapService<Speciality, Long> implements SpecialitiesService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.delteById(id);
    }

    @Override
    public void delete(Speciality obj) {
        super.delete(obj);
    }

    @Override
    public Speciality save(Speciality obj) {
        return super.save(obj);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
