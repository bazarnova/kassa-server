package com.kassa.service;

import com.kassa.dto.CheckDTO;
import com.kassa.entity.Check;
import com.kassa.flyway.CheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckService implements ICheckService {

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public Check addNewCheck(Check check) {

        CheckDTO checkDTO = new CheckDTO.Builder()
                .setDate(check.getDate())
                .setSumAmount(check.getSumAmount())
                .setShopName(check.getShopName())
                .setComment(check.getComment())
                .build();

        checkMapper.addCheck(checkDTO);
        check.setId(checkDTO.getId());
        return check;
    }

    @Override
    public List<Check> getAllChecks() {

        List<Check> checks = new ArrayList<>();
        List<CheckDTO> checkDTOS = checkMapper.getAllChecks();
        for (CheckDTO checkDTO : checkDTOS) {
            LocalDate date = checkDTO.getDate() == null ? null : checkDTO.getDate();
            Check check = new Check.Builder()
                    .setId(checkDTO.getId())
                    .setDate(date)
                    .setSumAmount(checkDTO.getSumAmount())
                    .setShopName(checkDTO.getShopName())
                    .setComment(checkDTO.getComment())
                    .build();
            checks.add(check);
        }
        return checks;
    }

    @Override
    public List<Check> getChecksByDate(LocalDate date) {

        List<Check> checks = new ArrayList<>();
        List<CheckDTO> checkDTOS = checkMapper.getChecksByDate(date);
        for (CheckDTO checkDTO : checkDTOS) {
            Check check = new Check.Builder()
                    .setId(checkDTO.getId())
                    .setDate(checkDTO.getDate())
                    .setSumAmount(checkDTO.getSumAmount())
                    .setShopName(checkDTO.getShopName())
                    .setComment(checkDTO.getComment())
                    .build();
            checks.add(check);
        }
        return checks;
    }
}
