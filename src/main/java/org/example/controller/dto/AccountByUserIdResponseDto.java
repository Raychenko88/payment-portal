package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@Setter
@Getter
@JsonPropertyOrder({ "account_id", "account_num", "account_type", "balance"})
public class AccountByUserIdResponseDto {

    @XmlElement(name = "account_id")
    @JsonProperty(value = "account_id")
    private Integer id;
    @XmlElement(name = "account_num")
    @JsonProperty("account_num")
    private String accountNum;
    @XmlElement(name = "account_type")
    @JsonProperty("account_type")
    private String accountType;
    private BigDecimal balance;
}
