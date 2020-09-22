package si.damjanh.springpetclinic.services.springdatajpa;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import si.damjanh.springpetclinic.model.Speciality;
import si.damjanh.springpetclinic.repositories.SpecialityRepository;
import si.damjanh.springpetclinic.services.SpecialityService;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpariclitySDJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpariclitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality spec) {
        Speciality savedSpeciality = specialityRepository.save(spec);
        return savedSpeciality;
    }

    @Override
    public void delete(Speciality spec) {
        specialityRepository.delete(spec);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
