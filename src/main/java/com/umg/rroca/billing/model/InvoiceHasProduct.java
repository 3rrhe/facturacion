package com.umg.rroca.billing.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "invoice_has_product")
@EntityListeners(AuditingEntityListener.class)
public class InvoiceHasProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoiceHasProductId;

    @Column(name = "product_id", nullable = false)
    private long productId;

    @Column(name = "invoice_id", nullable = false)
    private long invoiceId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return invoiceHasProductId;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.invoiceHasProductId = id;
    }

    /**
     * Gets productId.
     *
     * @return the productId
     */
    public long getProductId() {
        return productId;
    }

    /**
     * Sets productId.
     *
     * @param productId the product id
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }

    /**
     * Gets invoiceId.
     *
     * @return the invoiceId
     */
    public long getInvoiceId() {
        return invoiceId;
    }

    /**
     * Sets invoiceId.
     *
     * @param invoiceId the invoice id
     */
    public void setInvoiceId(long invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InvoiceHasProduct{" +
                "id=" + invoiceId +
                ", product='" + productId + '\'' +
                ", invoice='" + invoiceId + '\'' +
                ", quantity='" + quantity.toString() + '\'' +
                '}';
    }
}