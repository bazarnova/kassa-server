package com.kassa.service;

import com.kassa.dto.CheckDTO;
import com.kassa.entity.Check;

import java.time.LocalDate;
import java.util.List;

public interface ICheckService {
    CheckDTO addNewCheck(CheckDTO checkDTO);
    List<CheckDTO> getAllChecks();
    List<CheckDTO> getChecksByDate(LocalDate date);
}
