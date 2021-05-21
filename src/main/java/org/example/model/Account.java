package org.example.model;

import lombok.*;

import javax.persistence.*;

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
    private Integer accountNum;
    @Column(name = "account_type", length = 50)
    private String accountType;
    private String balance;
    @ManyToOne(targetEntity = User.class)
    private User user;
}
