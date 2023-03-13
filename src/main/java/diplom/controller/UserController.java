package diplom.controller;

import diplom.domain.User;
import diplom.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gar/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<User> findAll(){
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public User findById(@PathVariable int id) {
        return repository.findById(id).orElseThrow();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteById(id);
    }

    @PostMapping
    public List<User> save(@RequestBody User user) {
        repository.save(user);
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }
}
