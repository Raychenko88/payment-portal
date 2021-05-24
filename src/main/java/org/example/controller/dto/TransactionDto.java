package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.model.User;

import javax.persistence.Column;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDto {

    @JsonProperty("payer_id")
    private User payer;
    @JsonProperty("recipient_id")
    private User recipient;
    @JsonProperty("source_acc_id")
    private Integer srcAccNum;
    @JsonProperty("dest_acc_id")
    private Integer destAccNum;
}
