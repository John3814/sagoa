package com.udea.sagoa.dominio.waterbill.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "water_billing_periods")
public class WaterBillingPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "period_start_date")
    private Date periodStartDate;

    @Column(name = "period_end_date")
    private Date periodEndDate;

    @Column(name = "generation_date")
    private Date generationDate;

    @OneToMany(mappedBy = "period")
    private Set<WaterBill> waterBills;


}
