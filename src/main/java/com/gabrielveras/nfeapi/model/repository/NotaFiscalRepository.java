package com.gabrielveras.nfeapi.model.repository;

import com.gabrielveras.nfeapi.model.entity.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Integer> {
}
