package mypetclinic.services.map;

import mypetclinic.model.Speciality;
import mypetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class SpecialityServiceMap extends AbstractMapService<Speciality, Long> implements SpecialityService {
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    public void deleteById(Long id) {
        super.deleteById(id);

    }

    public void delete(Speciality object) {
        super.delete(object);

    }

    public Speciality save(Speciality object) {
        return super.save(object);
    }

    public Speciality findbyId(Long id) {
        return super.findbyId(id);
    }
}
