package mypetclinic.services.map;

import mypetclinic.model.Vet;
import mypetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {


    public Set<Vet> findAll() {
        return super.findAll();
    }

    public void deleteById(Long id) {
        super.deleteById(id);
    }

    public void delete(Vet object) {
        super.delete(object);

    }

    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    public Vet findbyId(Long id) {
        return super.findbyId(id);
    }
}
