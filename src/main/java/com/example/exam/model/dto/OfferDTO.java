package com.example.exam.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class OfferDTO {

    @NotBlank(message = "Description cannot be empty!")
    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters!")
    private String description;

    @NotNull(message = "Please enter valid price")
    @Min(value = 0, message = "Price cannot be negative!")
    private BigDecimal price;

    @NotBlank(message = "Condition cannot be empty!")
    private String condition;

    public OfferDTO() {
    }

    public String getDescription() {
        return description;
    }

    public OfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getCondition() {
        return condition;
    }

    public OfferDTO setCondition(String condition) {
        this.condition = condition;
        return this;
    }
}
