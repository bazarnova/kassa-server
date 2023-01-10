package com.kassa.controller;

import com.kassa.dto.CheckDTO;
import com.kassa.service.CheckListWrapper;
import com.kassa.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CheckController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private CheckService checkService;

    public CheckController(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping(value = "/checks")
    @ResponseBody
    public List<CheckDTO> checkList() {
        return checkService.getAllChecks();
    }

    @GetMapping(value = "/checks/{date}")
    @ResponseBody
    public ResponseEntity<CheckListWrapper> getChecksByDate(@PathVariable String date) {
        CheckListWrapper checkListWrapper = new CheckListWrapper(checkService.getChecksByDate(LocalDate.parse(date)));
        return new ResponseEntity<>(checkListWrapper, HttpStatus.OK);
    }

    @PostMapping(value = "/check",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public CheckDTO addCheck(@RequestBody CheckDTO checkDTO) {
        return  checkService.addNewCheck(checkDTO);
    }

}
