package com.kassa.controller;

import com.kassa.entity.Check;
import com.kassa.service.CheckListWrapper;
import com.kassa.service.ICheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CheckController {

    private final ICheckService checkService;

    public CheckController(ICheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping(value = "/checks")
    @ResponseBody
    public List<Check> checkList() {
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
    public Check addCheck(@RequestBody Check check) {
        return  checkService.addNewCheck(check);
    }

}
