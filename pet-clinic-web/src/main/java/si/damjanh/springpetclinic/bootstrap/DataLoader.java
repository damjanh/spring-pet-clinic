package si.damjanh.springpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import si.damjanh.springpetclinic.model.Owner;
import si.damjanh.springpetclinic.model.Vet;
import si.damjanh.springpetclinic.services.OwnerService;
import si.damjanh.springpetclinic.services.VetService;
import si.damjanh.springpetclinic.services.map.OwnerMapService;
import si.damjanh.springpetclinic.services.map.VetMapService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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