package com.udea.sagoa.dominio.customerconsumption.water.model;

import com.udea.sagoa.dominio.waterbill.model.WaterBill;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "water_consumptions")
@Getter
public class WaterConsumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "water_bill_id", referencedColumnName = "id")
    private WaterBill waterBill;

    @ManyToOne
    @JoinColumn(name = "previous_reading", referencedColumnName = "id", nullable = false)
    private WaterMeterReading previousReading;

    @ManyToOne
    @JoinColumn(name = "current_reading", referencedColumnName = "id", nullable = false)
    private WaterMeterReading currentReading;

    @Column(name = "consumption_m3", nullable = false)
    private Double consumptionM3;

    @Column(name = "subtotal", nullable = false)
    private Long subtotal;

}
