package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionCreateManyPaymentResponseDto {

    @JsonProperty("payment_id")
    private Integer id;
    @JsonProperty("status")
    private String status;
}
