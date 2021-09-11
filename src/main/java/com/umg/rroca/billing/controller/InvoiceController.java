package com.umg.rroca.billing.controller;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import javax.validation.Valid;

import com.umg.rroca.billing.model.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.umg.rroca.billing.repository.InvoiceRepository;
import com.umg.rroca.billing.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    /**
     * Get all invoices list.
     *
     * @return the list
     */
    @GetMapping("/invoices")
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    /**
     * Gets invoices by id.
     *
     * @param invoiceId the invoice id
     * @return the invoices by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping("/invoices/{id}")
    public ResponseEntity<Invoice> getInvoicesById(@PathVariable(value = "id") Long invoiceId)
            throws ResourceNotFoundException {
        Invoice invoice =
                invoiceRepository
                        .findById(invoiceId)
                        .orElseThrow(() -> new ResourceNotFoundException("Invoice not found on :: " + invoiceId));
        return ResponseEntity.ok().body(invoice);
    }

    /**
     * Create new invoice.
     *
     * @param invoice the invoice
     * @return the invoice
     */
    @PostMapping("/invoices")
    public Invoice createInvoice(@Valid @RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    /**
     * Update invoice response entity.
     *
     * @param invoiceId      the invoice id
     * @param invoiceDetails the invoice details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping("/invoices/{id}")
    public ResponseEntity<Invoice> updateUser(
            @PathVariable(value = "id") Long invoiceId, @Valid @RequestBody Invoice invoiceDetails)
            throws ResourceNotFoundException {

        Invoice invoice =
                invoiceRepository
                        .findById(invoiceId)
                        .orElseThrow(() -> new ResourceNotFoundException("Invoice not found on :: " + invoiceId));

        invoice.setTotal(invoiceDetails.getTotal());
        final Invoice updatedInvoice = invoiceRepository.save(invoice);
        return ResponseEntity.ok(updatedInvoice);
    }

    /**
     * Delete invoice map.
     *
     * @param invoiceId the invoice id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/invoices/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long invoiceId) throws Exception {
        Invoice invoice =
                invoiceRepository
                        .findById(invoiceId)
                        .orElseThrow(() -> new ResourceNotFoundException("Invoice not found on :: " + invoiceId));

        invoiceRepository.delete(invoice);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}