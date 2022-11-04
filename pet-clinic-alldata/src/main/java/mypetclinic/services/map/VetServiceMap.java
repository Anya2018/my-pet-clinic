package mypetclinic.services.map;

import mypetclinic.model.Specialty;
import mypetclinic.model.Vet;
import mypetclinic.services.SpecialityService;
import mypetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if (object.getSpecialties().size() > 0) {
            object.getSpecialties().forEach(specialty -> {
                        if (specialty.getId() == null) {
                            Specialty savedSpeciality =
                                    specialityService.save(specialty);
                            specialty.setId(savedSpeciality.getId());

                        }
                    }
            );
        }
        return super.save(object);
    }

    public Vet findbyId(Long id) {
        return super.findbyId(id);
    }
}
