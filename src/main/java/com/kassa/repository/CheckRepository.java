package com.kassa.repository;

import com.kassa.entity.Check;
import com.kassa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CheckRepository extends JpaRepository<Check, Long> {
    Check save(Check check);

    List<Check> findAll();
    List<Check> getChecksByDate(LocalDate date);


}
