package com.kassa.service;

import com.kassa.dto.CheckDTO;
import com.kassa.entity.Check;
import com.kassa.mybatis.CheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckService implements ICheckService {

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public Check addNewCheck(Check check) {

        CheckDTO checkDTO = new CheckDTO.Builder()
                .setDate(Instant.ofEpochMilli(check.getDate()).atZone(ZoneId.systemDefault()).toLocalDate())
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
            Long date = checkDTO.getDate() == null ? 0 : checkDTO.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond();
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
    public List<Check> getChecksByDate(Long date) {

        List<Check> checks = new ArrayList<>();
        LocalDate localDate = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDate();
        List<CheckDTO> checkDTOS = checkMapper.getChecksByDate(localDate);
        for (CheckDTO checkDTO : checkDTOS) {
            Long checkDate = checkDTO.getDate() == null ? 0 : checkDTO.getDate().atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond();
            Check check = new Check.Builder()
                    .setId(checkDTO.getId())
                    .setDate(checkDate)
                    .setSumAmount(checkDTO.getSumAmount())
                    .setShopName(checkDTO.getShopName())
                    .setComment(checkDTO.getComment())
                    .build();
            checks.add(check);
        }
        return checks;
    }
}
