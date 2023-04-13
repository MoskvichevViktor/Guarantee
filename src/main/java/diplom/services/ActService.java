package diplom.services;

import diplom.constants.ActStatus;
import diplom.dto.ActDto;
import diplom.dto.CompanyDto;
import diplom.elements.Act;
import diplom.elements.Company;
import diplom.repositories.ActRepository;
import diplom.repositories.CompanyRepository;
import diplom.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ActService {

    private ActRepository actRepository;

    public ResponseEntity<ActDto> addAct(ActDto actDto) {
        Act act = new Act();
        act.setActId(actDto.getActId());
        act.setActDate(actDto.getActDate());

        actRepository.save(act);
        return ResponseEntity.status(HttpStatus.CREATED).body(actDto);
    }

    public List<ActDto> getActs() {
        List<Act> acts =  actRepository.findAll();
        List<ActDto> actDtos = new ArrayList<>();
        for (Act act: acts) {
            ActDto actDto = new ActDto();
            actDto.setActId(act.getActId());
            actDto.setActDate(act.getActDate());
            actDtos.add(actDto);
        }
        return  actDtos;
    }
}
