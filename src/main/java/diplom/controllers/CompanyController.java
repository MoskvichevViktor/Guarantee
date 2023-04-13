package diplom.controllers;

import diplom.dto.CompanyDto;
import diplom.dto.UserDto;
import diplom.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    @GetMapping("/api/companies")
    public List<CompanyDto> getCompanys() {
        return companyService.getCompanys();
    }

    @PostMapping
    public ResponseEntity<CompanyDto> addCompany(@RequestBody CompanyDto companyDto) {
        return companyService.addCompany(companyDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompany(@PathVariable int id) {
        return companyService.getCompany(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable int id, @RequestBody CompanyDto companyDto) {
        return companyService.updateCompany(id, companyDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable int id) {
        return companyService.deleteCompany(id);
    }

    //метод который добавляет работника в компанию
    @PutMapping("/{id}/add-user")
    public ResponseEntity<Void> addUserToCompany(@PathVariable int id, @RequestBody UserDto userDto) {
        return companyService.addUserToCompany(id, userDto);
    }
}
