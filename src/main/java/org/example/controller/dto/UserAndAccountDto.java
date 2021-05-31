package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.model.Account;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;


@Setter
@Getter
public class UserAndAccountDto {

    private Integer id;
    @XmlElement(name = "first_name")
    @JsonProperty("first_name")
    private String firstName;
    @XmlElement(name = "last_name")
    @JsonProperty("last_name")
    private String lastName;
    private List<Account> accounts;

    @Override
    public String toString() {
        return "client_id: " + getId();
    }
}
