package si.damjanh.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import si.damjanh.springpetclinic.model.Owner;
import si.damjanh.springpetclinic.model.PetType;
import si.damjanh.springpetclinic.model.Vet;
import si.damjanh.springpetclinic.services.OwnerService;
import si.damjanh.springpetclinic.services.PetTypeService;
import si.damjanh.springpetclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService,
            PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glendale");

        Owner owner3 = new Owner();
        owner3.setFirstName("Sam");
        owner3.setLastName("Axe");

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        Vet vet2 = new Vet();
        vet2.setFirstName("Elliot");
        vet2.setLastName("Alderson");

        vetService.save(vet1);
        vetService.save(vet2);

        System.out.println("Loaded data!");
    }
}
