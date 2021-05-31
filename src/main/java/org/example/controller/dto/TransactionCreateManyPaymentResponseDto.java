package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Setter
@Getter
public class TransactionCreateManyPaymentResponseDto {

    @XmlElement(name = "payment_id")
    @JsonProperty("payment_id")
    private Integer id;
    @XmlElement(name = "status")
    @JsonProperty("status")
    private String status;
}
