package com.kassa.controller;

import com.kassa.entity.Check;
import com.kassa.service.ICheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CheckController {

    @Autowired
    private ICheckService checkService;

    @GetMapping(value = "/checks")
    @ResponseBody
    public List<Check> checkList() {
        return checkService.getAllChecks();
    }

    @GetMapping(value = "/checks/{date}")
    @ResponseBody
    public List<Check> getChecksByDate(@PathVariable String date) {
        return checkService.getChecksByDate(Long.parseLong(date));
    }

    @PostMapping(value = "/check",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Check addCheck(@RequestBody Check check) {
        return  checkService.addNewCheck(check);
    }

}
