package services.map;

import model.Pet;
import services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {


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
