package diplom.controllers;

import diplom.dto.ActDto;
import diplom.services.ActService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acts")
@AllArgsConstructor
public class ActController {

    private ActService actService;

    @PostMapping
    public ResponseEntity<ActDto> addCompany(@RequestBody ActDto actDto) {
        return actService.addAct(actDto);
    }

    @GetMapping
    public List<ActDto> getActs() {
        return actService.getActs();
    }
}
