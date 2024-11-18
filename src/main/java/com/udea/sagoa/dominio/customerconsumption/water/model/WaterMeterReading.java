package com.udea.sagoa.dominio.customerconsumption.water.model;

import com.udea.sagoa.dominio.contract.model.Contract;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "water_meter_reading")
@Getter
public class WaterMeterReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    @Column(nullable = false, name = "reading_date")
    private Date readinDate;

    private Double readingValue;
}
