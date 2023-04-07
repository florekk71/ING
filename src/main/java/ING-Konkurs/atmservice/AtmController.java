package com.example.myapp;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atms")
public class AtmController {

    @PostMapping(value = "/calculateOrder", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Atm>> calculateOrder(@RequestBody List<Task> tasks) {
        List<Atm> atms = new ArrayList<>();

        // Add priority tasks first
        for (Task task : tasks) {
            if (task.getRequestType() == RequestType.PRIORITY) {
                atms.add(new Atm(task.getRegion(), task.getAtmId(), task.getRequestType()));
            }
        }

        // Add standard tasks
        for (Task task : tasks) {
            if (task.getRequestType() == RequestType.STANDARD) {
                atms.add(new Atm(task.getRegion(), task.getAtmId(), task.getRequestType()));
            }
        }

        // Sort by region and ATM ID
        atms.sort(Comparator.comparing(Atm::getRegion).thenComparing(Atm::getAtmId));

        // Add low cash signals
        for (Task task : tasks) {
            if (task.getRequestType() == RequestType.SIGNAL_LOW) {
                atms.add(new Atm(task.getRegion(), task.getAtmId(), task.getRequestType()));
            }
        }

        // Add ATM failures
        for (Task task : tasks) {
            if (task.getRequestType() == RequestType.FAILURE_RESTART) {
                atms.add(new Atm(task.getRegion(), task.getAtmId(), task.getRequestType()));
            }
        }

        // Remove duplicates
        atms = atms.stream()
                .distinct()
                .collect(Collectors.toList());

        return new ResponseEntity<>(atms, HttpStatus.OK);
    }

}

