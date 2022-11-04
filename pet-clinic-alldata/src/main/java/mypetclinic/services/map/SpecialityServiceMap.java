package mypetclinic.services.map;

import mypetclinic.model.Specialty;
import mypetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityServiceMap extends AbstractMapService<Specialty, Long> implements SpecialityService {
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    public void deleteById(Long id) {
        super.deleteById(id);

    }

    public void delete(Specialty object) {
        super.delete(object);

    }

    public Specialty save(Specialty object) {
        return super.save(object);
    }

    public Specialty findbyId(Long id) {
        return super.findbyId(id);
    }
}
