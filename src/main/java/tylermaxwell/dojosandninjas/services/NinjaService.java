package tylermaxwell.dojosandninjas.services;

import org.springframework.stereotype.Service;
import tylermaxwell.dojosandninjas.models.Ninja;
import tylermaxwell.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public void createNinja(Ninja ninja) {
        ninjaRepository.save(ninja);
    }
}
