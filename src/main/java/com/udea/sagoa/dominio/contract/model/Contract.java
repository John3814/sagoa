package com.udea.sagoa.dominio.contract.model;

import com.udea.sagoa.dominio.user.model.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "contracts")
@Getter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String contractNumber;

    @Column(nullable = false, unique = true, name = "meter_number")
    private String meterNumber;

    @Enumerated(EnumType.STRING)
    private ContractStatus status;

    @Column(nullable = false, name = "start_date")
    private Date startDate;

    @Column(nullable = false, name = "end_date")
    private Date endDate;

    @Column(nullable = false, name = "service_address")
    private String serviceAddress;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String neighborhood;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "rate_id", referencedColumnName = "id")
    private Rate rate;

    public Contract() {}

}
