package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Date;

@XmlRootElement
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date timesTamp = new Date();
    @Column(name = "src_acc_num", length = 50)
    private Integer srcAccNum;
    @Column(name = "dest_acc_num", length = 50)
    private Integer destAccNum;
    private BigDecimal amount;
    @ManyToOne(targetEntity = User.class)
    private User payer;
    @ManyToOne(targetEntity = User.class)
    private User recipient;
    private String reason;
    private String status;
}
