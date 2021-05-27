package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.model.Account;

import java.util.List;

@Setter
@Getter
public class UserAndAccountDto {

    private Integer id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private List<Account> accounts;

    @Override
    public String toString() {
        return "client_id: " + getId();
    }
}
