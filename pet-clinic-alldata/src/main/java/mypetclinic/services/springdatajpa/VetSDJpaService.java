package mypetclinic.services.springdatajpa;

import mypetclinic.model.Vet;
import mypetclinic.repositories.VetRepository;
import mypetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    public Vet findbyId(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
