package com.egt.intern.task.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Map;

@Entity
@Table(name = "currency_db")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "success")
    private boolean success;

    @Column(name = "timestamp") // fix
    private Long timestamp;

    @Column(name = "base")
    private String base;

    @Column(name = "date")
    private LocalDate date; // fix

    @ElementCollection
    @CollectionTable(name = "currency_mapping",
            joinColumns = {@JoinColumn(name = "currency_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "currency_code")
    @Column(name = "exchange_rate")
    private Map<String, Double> rates;

    public Currency() {
    }

    public Currency(Long id, boolean success, long timestamp, String base, LocalDate date, Map<String, Double> rates) {
        this.id = id;
        this.success = success;
        this.timestamp = timestamp;
        this.base = base;
        this.date = date;
        this.rates = rates;
    }


    public Long getId() {
        return id;
    }

    public boolean isSuccess() {
        return success;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public LocalDate getDate() {
        return date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(LocalDate date) {
        this.date = LocalDate.now();;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", success=" + success +
                ", timestamp=" + timestamp +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                ", rates=" + rates +
                '}';
    }

    public void setSuccess(boolean success) {
    }
}
