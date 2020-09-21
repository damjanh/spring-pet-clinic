package si.damjanh.springpetclinic.services.map;

import org.springframework.stereotype.Service;
import si.damjanh.springpetclinic.model.Speciality;
import si.damjanh.springpetclinic.model.Vet;
import si.damjanh.springpetclinic.services.SpecialityService;
import si.damjanh.springpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet obj) {
        super.delete(obj);
    }

    @Override
    public Vet save(Vet obj) {
        if (obj.getSpecialities().size() > 0) {
            obj.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(obj);
    }

    @Override
    public void deleteById(Long id) {
        super.delteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
