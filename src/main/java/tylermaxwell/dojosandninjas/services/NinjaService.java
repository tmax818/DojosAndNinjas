package tylermaxwell.dojosandninjas.services;

import org.springframework.stereotype.Service;
import tylermaxwell.dojosandninjas.models.Ninja;
import tylermaxwell.dojosandninjas.repositories.NinjaRepository;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository repo;

    public NinjaService(NinjaRepository repo){this.repo = repo;}

    public Ninja createNinja(Ninja ninja){return repo.save(ninja);}

    public List<Ninja> allNinjas() { return repo.findAll();
    }
}
