package org.example.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;


@Setter
@Getter
public class UserAndAccountResponseDto {

    @XmlElement(name = "client_id")
    @JsonProperty("client_id")
    private Integer id;
}
