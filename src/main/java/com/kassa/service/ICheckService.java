package com.kassa.service;

import com.kassa.entity.Check;

import java.util.List;

public interface ICheckService {
    Check addNewCheck(Check check);
    List<Check> getAllChecks();
    List<Check> getChecksByDate(Long date);
}
