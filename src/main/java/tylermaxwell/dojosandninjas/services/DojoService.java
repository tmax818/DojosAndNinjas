package tylermaxwell.dojosandninjas.services;

import org.springframework.stereotype.Service;
import tylermaxwell.dojosandninjas.models.Dojo;
import tylermaxwell.dojosandninjas.repositories.DojoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {

    private final DojoRepository repo;

    public DojoService(DojoRepository repo){this.repo = repo;}

    // CREATE
    public Dojo createDojo(Dojo dojo){return repo.save(dojo);}

    // READ ALL
    public List<Dojo> allDojos() { return repo.findAll();}

    // READ ONE
    public Dojo findDojo(Long id){
        Optional<Dojo> optionalDojo = repo.findById(id);
        return optionalDojo.orElse(null);
    }
}
