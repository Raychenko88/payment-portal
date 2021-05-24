package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "account_num", length = 50)
    @JsonProperty("account_num")
    private String accountNum;
    @Column(name = "account_type", length = 50)
    @JsonProperty("account_type")
    private String accountType;
    private BigDecimal balance;
    @ManyToOne(targetEntity = User.class)
    private User user;
}
