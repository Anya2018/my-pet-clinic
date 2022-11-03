package mypetclinic.services.map;

import mypetclinic.model.Pet;
import mypetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {


    public Set<Pet> findAll() {
        return super.findAll();
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public void delete(Pet object) {
        super.delete(object);

    }

    public Pet save(Pet object) {
        return super.save(object);
    }

    public Pet findbyId(Long id) {
        return super.findbyId(id);
    }
}
