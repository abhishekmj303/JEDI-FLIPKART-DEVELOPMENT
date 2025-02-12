package com.flipkart.bean;

import java.time.LocalDateTime;

public class Payment {
    private int id;
    private int customerId;
    private int bookingId;
    private float amount;
    private String status;
    private String paymentMethod;
    private LocalDateTime transactionDate;

    public Payment(int id, int customerId, int bookingId, float amount, String status, String paymentMethod, LocalDateTime transactionDate) {
        this.id = id;
        this.customerId = customerId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.transactionDate = transactionDate;
    }

    public int getId() { return id; }
    public int getCustomerId() { return customerId; }
    public int getBookingId() { return bookingId; }
    public float getAmount() { return amount; }
    public String getStatus() { return status; }
    public String getPaymentMethod() { return paymentMethod; }
    public LocalDateTime getTransactionDate() { return transactionDate; }

    public void processPayment() { System.out.println("Processing payment..."); }
}
