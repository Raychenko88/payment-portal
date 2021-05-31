package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@Setter
@Getter
public class AccountCreateDto {

    @XmlElement(name = "account_num")
    @JsonProperty("account_num")
    private String accountNum;
    @XmlElement(name = "account_type")
    @JsonProperty("account_type")
    private String accountType;
    private BigDecimal balance;
}
