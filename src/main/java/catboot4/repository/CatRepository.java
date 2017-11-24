package catboot4.repository;


import catboot4.model.Cat;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by USER on 06.11.2017.
 */
public interface CatRepository extends CrudRepository<Cat,Integer> {

}
