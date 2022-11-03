package mypetclinic.services.map;

import mypetclinic.model.Owner;
import mypetclinic.model.Pet;
import mypetclinic.services.OwnerService;
import mypetclinic.services.PetService;
import mypetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long>
        implements OwnerService {

    private final PetService petService;

    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;

    }

    public Set<Owner> findAll() {
        return super.findAll();
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public void delete(Owner object) {
        super.delete(object);

    }

    public Owner save(Owner object) {
        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());

                    }
                });

            }

            return super.save(object);
        } else {
            return null;
        }

    }

    public Owner findbyId(Long id) {
        return super.findbyId(id);
    }

    public Owner findByLastName(String lastName) {
        return null;
    }
}
