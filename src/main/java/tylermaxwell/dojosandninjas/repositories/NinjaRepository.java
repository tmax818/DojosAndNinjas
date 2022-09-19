package tylermaxwell.dojosandninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import tylermaxwell.dojosandninjas.models.Ninja;

import java.util.List;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {

    List<Ninja> findAll();
}
