package dip.controller;

import dip.domain.User;
import dip.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gar")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/users")
    @ResponseBody
    public List<User> findAll(){
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public User findById(@PathVariable int id) {
        return repository.findById(id).orElseThrow();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        repository.remove(id);
    }

    @PostMapping
    public List<User> save(@RequestBody User user) {
        repository.add(user);
        return repository.findAll();
    }
}
