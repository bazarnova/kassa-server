package com.kassa.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String productName;
    private Integer amount;
    private Integer account;
    private BigDecimal weight;
    private Long checkId;
    private String description;
}
