package org.purpura.apipg.controller.alive;

import org.purpura.apipg.dto.schemas.alive.AliveResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alive")
public class AliveController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public AliveResponseDTO alive() {
        return new AliveResponseDTO("banana", "Api is alive!");
    }
}
