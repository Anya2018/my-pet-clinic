package mypetclinic.bootstrap;

import model.Owner;
import model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import services.OwnerService;
import services.VetService;
import services.map.OwnerServiceMap;
import services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
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

    }
}
