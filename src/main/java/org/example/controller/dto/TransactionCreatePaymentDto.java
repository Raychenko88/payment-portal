package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;


@Setter
@Getter
public class TransactionCreatePaymentDto {

    @XmlElement(name = "source_acc_id")
    @JsonProperty("source_acc_id")
    private Integer srcAccNum;
    @XmlElement(name = "dest_acc_id")
    @JsonProperty("dest_acc_id")
    private Integer destAccNum;
    private BigDecimal amount;
    private String reason;
}
