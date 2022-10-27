package services.map;

import model.Owner;
import services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {


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
        return super.save(object.getId(), object);
    }

    public Owner findbyId(Long id) {
        return super.findbyId(id);
    }
}
