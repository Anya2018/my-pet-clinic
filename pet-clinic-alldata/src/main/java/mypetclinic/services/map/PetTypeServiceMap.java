package mypetclinic.services.map;

import mypetclinic.model.PetType;
import mypetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType, Long> implements PetTypeService {

    public Set<PetType> findAll() {
        return super.findAll();
    }

    public void deleteById(Long id) {
        super.deleteById(id);

    }

    public void delete(PetType object) {
        super.delete(object);
    }

    public PetType save(PetType object) {
        return super.save(object);
    }

    public PetType findbyId(Long id) {
        return super.findbyId(id);
    }

    
}
