package mypetclinic.services.springdatajpa;

import mypetclinic.model.Owner;
import mypetclinic.repositories.OwnerRepository;
import mypetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;


    public OwnerSDJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;

    }

    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    public Owner findbyId(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    public void delete(Owner object) {
        ownerRepository.delete(object);

    }

    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);

    }

    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
