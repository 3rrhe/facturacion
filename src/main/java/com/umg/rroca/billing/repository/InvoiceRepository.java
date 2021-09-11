package com.umg.rroca.billing.repository;

import com.umg.rroca.billing.model.Invoice;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}