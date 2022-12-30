package com.kassa.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CheckDTO {
    private Long id;
    private Double sumAmount;
    private LocalDate date;
    private String shopName;
    private String comment;
}
