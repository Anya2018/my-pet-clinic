package mypetclinic.services.map;

import mypetclinic.model.Owner;
import mypetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
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
        return super.save(object);
    }

    public Owner findbyId(Long id) {
        return super.findbyId(id);
    }

    public Owner findByLastName(String lastName) {
        return null;
    }
}
