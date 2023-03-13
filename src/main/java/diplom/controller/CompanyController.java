package diplom.controller;

import diplom.domain.Company;
import diplom.repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gar/companies")
public class CompanyController {

    private final CompanyRepository repository;

    public CompanyController(CompanyRepository repository){
        this.repository = repository;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Company> findAll(){
        List<Company> companies = new ArrayList<>();
        repository.findAll().forEach(companies::add);
        return companies;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Company findById(@PathVariable int id) {
        return repository.findById(id).orElseThrow();
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        repository.deleteById(id);
    }

    @PostMapping
    public List<Company> save(@RequestBody Company company) {
        repository.save(company);
        List<Company> companies = new ArrayList<>();
        repository.findAll().forEach(companies::add);
        return companies;
    }
}
