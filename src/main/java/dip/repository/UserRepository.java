package dip.repository;

import dip.domain.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private List<User> users;

    public UserRepository(){
        this.users = new ArrayList<>(
                List.of(
                        new User(1, "Сорока"),
                        new User(2, "Перерядкин")
             )
        );
    }

    public Optional<User> findById(int id) {return users.stream().filter(p -> p.getId_user() == id).findFirst();}

    public List<User> findAll() {return users;}

    public void add(User user) {this.users.add(user);}

    public void remove(int id) {
        User user = findById(id).orElseThrow();
        this.users.remove(user);
    }

    @Override
    public String toString(){
        return "users: " + users;
    }
}
