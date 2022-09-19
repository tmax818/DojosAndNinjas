package tylermaxwell.dojosandninjas.repositories;

import org.springframework.data.repository.CrudRepository;
import tylermaxwell.dojosandninjas.models.Dojo;

import java.util.List;

public interface DojoRepository extends CrudRepository<Dojo, Long> {

    List<Dojo> findAll();
}
