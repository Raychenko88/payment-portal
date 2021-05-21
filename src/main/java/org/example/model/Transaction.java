package org.example.model;

import io.swagger.models.auth.In;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer payment_id;
    private Date timestamp;
    @Column(name = "src_acc_num", length = 50)
    private Integer srcAccNum;
    @Column(name = "dest_acc_num", length = 50)
    private Integer destAccNum;
    private BigDecimal amount;
    private User payer;
    private User recipient;
//    @Column(name = "source_acc_id", length = 50)
//    private Integer sourceAccId;
//    @Column(name = "dest_acc_id", length = 50)
//    private Integer destAccId;
//    private String reason;
}
