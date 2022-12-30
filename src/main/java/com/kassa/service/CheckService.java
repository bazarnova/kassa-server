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

        CheckDTO checkDTO = CheckDTO.builder()
                .date(check.getDate())
                .sumAmount(check.getSumAmount())
                .shopName(check.getShopName())
                .comment(check.getComment())
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
            Check check = Check.builder()
                    .id(checkDTO.getId())
                    .date(date)
                    .sumAmount(checkDTO.getSumAmount())
                    .shopName(checkDTO.getShopName())
                    .comment(checkDTO.getComment())
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
            Check check = Check.builder()
                    .id(checkDTO.getId())
                    .date(checkDTO.getDate())
                    .sumAmount(checkDTO.getSumAmount())
                    .shopName(checkDTO.getShopName())
                    .comment(checkDTO.getComment())
                    .build();
            checks.add(check);
        }
        return checks;
    }
}
