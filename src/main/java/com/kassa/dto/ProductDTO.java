package com.kassa.dto;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String productName;
    private Integer amount;
    private Integer account;
    private BigDecimal weight;
    private Long checkId;
    private String description;

    public ProductDTO(Builder builder) {
        this.id = builder.id;
        this.productName = builder.name;
        this.account = builder.account;
        this.amount = builder.amount;
        this.weight = builder.weight;
        this.checkId = builder.check_id;
        this.description = builder.description;
    }

    public ProductDTO() {
    }

    public ProductDTO(Long id, String productName, Integer amount, Integer account, BigDecimal weight, Long checkId, String description) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.account = account;
        this.weight = weight;
        this.checkId = checkId;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {
        Long id;
        String name;
        Integer amount;
        Integer account;
        BigDecimal weight;
        Long check_id;
        String description;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAmount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public Builder setAccount(Integer account) {
            this.account = account;
            return this;
        }

        public Builder setWeight(BigDecimal weight) {
            this.weight = weight;
            return this;
        }

        public Builder setCheck_id(Long check_id) {
            this.check_id = check_id;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductDTO build() {
            return new ProductDTO(this);
        }
    }
}
