package si.damjanh.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import si.damjanh.springpetclinic.model.Owner;
import si.damjanh.springpetclinic.model.Pet;
import si.damjanh.springpetclinic.model.PetType;
import si.damjanh.springpetclinic.model.Speciality;
import si.damjanh.springpetclinic.model.Vet;
import si.damjanh.springpetclinic.model.Visit;
import si.damjanh.springpetclinic.services.OwnerService;
import si.damjanh.springpetclinic.services.PetTypeService;
import si.damjanh.springpetclinic.services.SpecialityService;
import si.damjanh.springpetclinic.services.VetService;
import si.damjanh.springpetclinic.services.VisitService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService,
            PetTypeService petTypeService, SpecialityService specialityService,
            VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
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
        PetType dog = PetType.builder().name("Dog").build();
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = PetType.builder().name("Cat").build();
        PetType savedCatType = petTypeService.save(cat);

        Owner michael = new Owner();
        michael.setFirstName("Michael");
        michael.setLastName("Weston");
        michael.setAddress("123 Lafayette Street");
        michael.setCity("Boston");
        michael.setTelephone("21057129509");

        Pet michaelsPet = new Pet();
        michaelsPet.setPetType(savedDogType);
        michaelsPet.setName("Fluffy");
        michaelsPet.setBirthDate(LocalDate.now());
        michaelsPet.setOwner(michael);
        michael.getPets().add(michaelsPet);

        Owner fiona = new Owner();
        fiona.setFirstName("Fiona");
        fiona.setLastName("Glendale");
        fiona.setAddress("53 George Street");
        fiona.setCity("Austin");
        fiona.setTelephone("2935792375");

        Pet fionasPet = new Pet();
        fionasPet.setPetType(savedCatType);
        fionasPet.setName("Nightshade");
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setOwner(fiona);
        fiona.getPets().add(fionasPet);

        Owner owner3 = new Owner();
        owner3.setFirstName("Sam");
        owner3.setLastName("Axe");
        owner3.setAddress("343C Fifth Street");
        owner3.setCity("New York");
        owner3.setTelephone("6943063454");

        ownerService.save(michael);
        ownerService.save(fiona);
        ownerService.save(owner3);

        Visit catVisit = new Visit();
        catVisit.setPet(fionasPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sick kitty");
        visitService.save(catVisit);

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
