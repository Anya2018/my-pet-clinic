package services.map;

import model.Pet;
import services.PetService;

import java.util.Set;

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
        return super.save(object.getId(), object);
    }

    public Pet findbyId(Long id) {
        return super.findbyId(id);
    }
}
