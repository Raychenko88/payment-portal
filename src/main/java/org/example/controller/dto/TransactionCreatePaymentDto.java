package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Setter
@Getter
public class TransactionCreatePaymentDto {

    @JsonProperty("source_acc_id")
    private Integer srcAccNum;
    @JsonProperty("dest_acc_id")
    private Integer destAccNum;
    private BigDecimal amount;
    private String reason;
}
