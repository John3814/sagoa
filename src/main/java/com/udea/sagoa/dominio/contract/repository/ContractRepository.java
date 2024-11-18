package com.udea.sagoa.dominio.contract.repository;

import com.udea.sagoa.dominio.contract.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
}
