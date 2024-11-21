package com.udea.sagoa.dominio.contract.repository;

import com.udea.sagoa.dominio.contract.model.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {


}
