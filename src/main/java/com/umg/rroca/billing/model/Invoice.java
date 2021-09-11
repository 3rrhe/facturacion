package com.umg.rroca.billing.model;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "invoice")
@EntityListeners(AuditingEntityListener.class)
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoiceId;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "total", nullable = false)
    private Float total;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return invoiceId;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.invoiceId = id;
    }

    /**
     * Gets User Id.
     *
     * @return the name
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets name.
     *
     * @param userId the first name
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * Gets total.
     *
     * @return the total
     */
    public Float getTotal() {
        return total;
    }

    /**
     * Sets total.
     *
     * @param total the total
     */
    public void setTotal(Float total) {
        this.total = total;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + invoiceId +
                ", user='" + userId + '\'' +
                ", total='" + total.toString() + '\'' +
                ", createdAt='" + createdAt.toString() + '\'' +
                '}';
    }
}