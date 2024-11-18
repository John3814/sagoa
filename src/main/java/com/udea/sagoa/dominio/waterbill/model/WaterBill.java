package com.udea.sagoa.dominio.waterbill.model;

import com.udea.sagoa.dominio.contract.model.Contract;
import com.udea.sagoa.dominio.customerconsumption.water.model.WaterConsumption;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "water_bills")
@Getter
public class WaterBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "bill_number", unique = true)
    private String billNumber;

    @Column(nullable = false, name = "issue_date")
    private Date issueDate;

    @Column(nullable = false, name = "payment_due_date")
    private Date paymentDueDate;

    @Column(nullable = false, name = "total_payable")
    private Long totalPayable;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "period_id", referencedColumnName = "id")
    private WaterBillingPeriod period;

    @OneToOne(mappedBy = "waterBill")
    private WaterConsumption waterConsumption;

    public WaterBill(){}
}
