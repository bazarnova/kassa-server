package com.kassa.service;

import com.kassa.dto.CheckDTO;
import com.kassa.entity.Check;
import com.kassa.repository.CheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CheckService implements ICheckService {

    @Autowired
    private CheckRepository checkRepository;

    @Override
    public CheckDTO addNewCheck(CheckDTO checkDTO) {

        Check check = Check.builder()
                .date(checkDTO.getDate())
                .sumAmount(checkDTO.getSumAmount())
                .shopName(checkDTO.getShopName())
                .comment(checkDTO.getComment())
                .build();

        checkRepository.save(check);
        checkDTO.setId(check.getId());
        return checkDTO;
    }

    @Override
    public List<CheckDTO> getAllChecks() {

        List<CheckDTO> checkDTOs = new ArrayList<>();
        List<Check> checks = checkRepository.findAll();
        for (Check check : checks) {
            CheckDTO checkDTO = CheckDTO.builder()
                    .id(check.getId())
                    .date(check.getDate())
                    .sumAmount(check.getSumAmount())
                    .shopName(check.getShopName())
                    .comment(check.getComment())
                    .build();
            checkDTOs.add(checkDTO);
        }
        return checkDTOs;
    }

    @Override
    public List<CheckDTO> getChecksByDate(LocalDate date) {

        List<CheckDTO> checkDTOs = new ArrayList<>();
        List<Check> checks = checkRepository.getChecksByDate(date);
        for (Check check : checks) {
            CheckDTO checkDTO = CheckDTO.builder()
                    .id(check.getId())
                    .date(check.getDate())
                    .sumAmount(check.getSumAmount())
                    .shopName(check.getShopName())
                    .comment(check.getComment())
                    .build();
            checkDTOs.add(checkDTO);
        }
        return checkDTOs;
    }
}
