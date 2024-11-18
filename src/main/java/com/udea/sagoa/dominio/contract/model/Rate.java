package com.udea.sagoa.dominio.contract.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Entity()
@Table(name = "rates")
@Getter
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rate_name", nullable = false)
    private String rateName;

    @Column(name = "rate_description")
    private String rateDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "rate_type")
    private RateType rateType;

    @Enumerated(EnumType.STRING)
    private Stratum stratum;

    @Column(name = "rate_m3", nullable = false)
    private Double rateM3;

    @Column(name = "fixed charge")
    private Double fixedCharge;

    @Column(name = "late_fee")
    private Double lateFee;

    @OneToMany(mappedBy = "rate")
    private Set<Contract> contracts;

    public Rate() {
    }

}
