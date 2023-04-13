package diplom.services;

import diplom.dto.CompanyDto;
import diplom.dto.UserDto;
import diplom.elements.Company;
import diplom.elements.User;
import diplom.repositories.CompanyRepository;
import diplom.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CompanyService {

    private CompanyRepository companyRepository;
    private UserRepository userRepository;

    public List<CompanyDto> getCompanys() {
        List<Company> companies =  companyRepository.findAll();
        List<CompanyDto> companyDtos = new ArrayList<>();
        for (Company company: companies) {
            CompanyDto companyDto = new CompanyDto();
            companyDto.setCompanyName(company.getCompanyName());
            companyDtos.add(companyDto);
        }
        return  companyDtos;
    }

    public ResponseEntity<CompanyDto> addCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setCompanyName(companyDto.getCompanyName());
        companyRepository.save(company);
        return ResponseEntity.status(HttpStatus.CREATED).body(companyDto);
    }

    public ResponseEntity<CompanyDto> getCompany(int id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            CompanyDto companyDto = new CompanyDto();
            companyDto.setCompanyName(company.getCompanyName());
            return ResponseEntity.ok(companyDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //сохранение и редактирование
    public ResponseEntity<CompanyDto> updateCompany(int id, CompanyDto companyDto) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            company.setCompanyName(companyDto.getCompanyName());
            companyRepository.save(company);
            return ResponseEntity.ok(companyDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteCompany(int id) {
        companyRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> addUserToCompany(int companyId, UserDto userDto) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            User user = new User();
            user.setUserName(userDto.getUserName());
            user.setUserEmail(userDto.getUserEmail());
            user.setCompany(company);
            userRepository.save(user);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
