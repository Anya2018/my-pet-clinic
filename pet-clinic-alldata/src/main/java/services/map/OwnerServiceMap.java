package services.map;

import model.Owner;
import services.OwnerService;

import java.util.Set;


public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {


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

    public Owner findByLastName(String lastName) {
        return null;
    }
}
