package com.tpdan.msproductos.repository;

import com.tpdan.msproductos.model.Provision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvisionRepository extends JpaRepository<Provision, Integer> {
}
