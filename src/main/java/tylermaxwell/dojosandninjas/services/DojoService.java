package tylermaxwell.dojosandninjas.services;

import org.springframework.stereotype.Service;
import tylermaxwell.dojosandninjas.models.Dojo;
import tylermaxwell.dojosandninjas.repositories.DojoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {

    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public void createDojo(Dojo dojo) {
        dojoRepository.save(dojo);

    }

    public List<Dojo> getAll() {
        return (List<Dojo>) dojoRepository.findAll();
    }

    public Dojo getOne(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        return optionalDojo.orElse(null);
    }
}
