package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Setter
@Getter
public class TransactionCreatePaymentResponseDto {

    @XmlElement(name = "payment_id")
    @JsonProperty("payment_id")
    private Integer id;

    @Override
    public String toString() {
        return getId().toString();
    }
}
