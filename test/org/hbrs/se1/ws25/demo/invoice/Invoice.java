package org.hbrs.se1.ws25.demo.invoice;

import java.util.Objects;

public class Invoice {
    private int sum;
    private String currency;

    public Invoice( int sum, String currency ){
        this.sum = sum;
        this.currency = currency;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;
        return sum == invoice.sum && Objects.equals(currency, invoice.currency);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "sum=" + sum +
                ", currency='" + currency + '\'' +
                '}';
    }
}


