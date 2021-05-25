package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionCreatePaymentResponseDto {

    @JsonProperty("payment_id")
    private Integer id;

    @Override
    public String toString() {
        return getId().toString();
    }
}
