package com.umg.rroca.billing.repository;

import org.springframework.stereotype.Repository;
import com.umg.rroca.billing.model.InvoiceHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InvoiceHasProductRepository extends JpaRepository<InvoiceHasProduct, Long> {
}