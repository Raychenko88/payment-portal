package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private Integer id;
    private Date timestamp = new Date();
    @Column(name = "src_acc_num", length = 50)
//    @JsonProperty("source_acc_id")
    private Integer srcAccNum;
    @Column(name = "dest_acc_num", length = 50)
//    @JsonProperty("dest_acc_id")
    private Integer destAccNum;
    private BigDecimal amount;
    @ManyToOne(targetEntity = User.class)
//    @JsonProperty("payer_id")
    private User payer;
    @ManyToOne(targetEntity = User.class)
//    @JsonProperty("recipient_id")
    private User recipient;
    private String reason;
    private String status;

    @Override
    public String toString() {
        return "\npayment_id: " + this.getId() + (this.getStatus() != null ? this.getStatus() : "");
    }
}
