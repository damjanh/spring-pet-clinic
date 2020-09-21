package si.damjanh.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import si.damjanh.springpetclinic.model.Owner;
import si.damjanh.springpetclinic.model.Pet;
import si.damjanh.springpetclinic.model.PetType;
import si.damjanh.springpetclinic.model.Speciality;
import si.damjanh.springpetclinic.model.Vet;
import si.damjanh.springpetclinic.services.OwnerService;
import si.damjanh.springpetclinic.services.PetTypeService;
import si.damjanh.springpetclinic.services.SpecialityService;
import si.damjanh.springpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService,
            PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0) {
            loadData();
        }
        System.out.println("Loaded data!");
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Lafayette Street");
        owner1.setCity("Boston");
        owner1.setTelephone("21057129509");

        Pet michaelsPet = new Pet();
        michaelsPet.setPetType(savedDogType);
        michaelsPet.setName("Fluffy");
        michaelsPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(michaelsPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glendale");
        owner2.setAddress("53 George Street");
        owner2.setCity("Austin");
        owner2.setTelephone("2935792375");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatType);
        fionasPet.setName("Nightshade");
        fionasPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasPet);

        Owner owner3 = new Owner();
        owner3.setFirstName("Sam");
        owner3.setLastName("Axe");
        owner3.setAddress("343C Fifth Street");
        owner3.setCity("New York");
        owner3.setTelephone("6943063454");

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality savedRadilogy = specialityService.save(radiology);
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedDentistry = specialityService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadilogy);

        Vet vet2 = new Vet();
        vet2.setFirstName("Elliot");
        vet2.setLastName("Alderson");
        vet2.getSpecialities().add(savedSurgery);
        vet2.getSpecialities().add(savedDentistry);

        vetService.save(vet1);
        vetService.save(vet2);
    }
}
