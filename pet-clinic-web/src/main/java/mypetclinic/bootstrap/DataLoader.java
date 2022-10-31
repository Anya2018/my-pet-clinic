package mypetclinic.bootstrap;

import mypetclinic.model.Owner;
import mypetclinic.model.Vet;
import mypetclinic.services.OwnerService;
import mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Jack");
        owner1.setLastName("Brown");
        owner1.setId(1L);

        ownerService.save(owner1);

        Vet vet1 = new Vet();
        vet1.setFirstName("Lola");
        vet1.setLastName("Green");
        vet1.setId(1L);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nata");
        vet2.setLastName("Bush");
        vet2.setId(2L);

        vetService.save(vet2);

    }
}
