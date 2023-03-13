package diplom.repository;

import diplom.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    //todo
    /*
    1 час 43
    Урок 7. Spring Data
    возможно реализовывать
    другие различные методы CRUD
    @Query
     */

}
