package mypetclinic.bootstrap;

import mypetclinic.model.*;
import mypetclinic.services.OwnerService;
import mypetclinic.services.PetTypeService;
import mypetclinic.services.SpecialityService;
import mypetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialtiesService;


    public DataLoader(OwnerService ownerService, VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();

        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jack");
        owner1.setLastName("Brown");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        Pet pet1 = new Pet();
        pet1.setBirthDate(LocalDate.now());
        pet1.setPetType(savedDogPetType);
        pet1.setOwner(owner1);
        pet1.setName("Sharik");
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anna");
        owner2.setLastName("Cleary");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("11111");

        Pet pet2 = new Pet();
        pet2.setBirthDate(LocalDate.now());
        pet2.setPetType(savedCatPetType);
        pet2.setOwner(owner1);
        pet2.setName("Barsik");
        owner1.getPets().add(pet2);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Elsa");
        owner3.setLastName("Frozen");
        ownerService.save(owner3);

        Vet vet1 = new Vet();
        vet1.setFirstName("Lola");
        vet1.setLastName("Green");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mia");
        vet2.setLastName("Brown");
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);
    }
}
