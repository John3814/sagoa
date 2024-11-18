package com.udea.sagoa.dominio.customerconsumption.water.repository;

import com.udea.sagoa.dominio.customerconsumption.water.model.WaterMeterReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerConsumptionRepository extends JpaRepository<WaterMeterReading, Long> {
}
