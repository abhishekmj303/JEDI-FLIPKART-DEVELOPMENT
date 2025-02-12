package com.flipkart.business;

public class PaymentBusiness {
	
    public void processPayment(int customerId, double amount) {
        System.out.println("Processing payment of Rs. " + amount + " for Customer ID: " + customerId);
    }
    
    public boolean refundPayment(int paymentId) {
        System.out.println("Refunding payment with ID: " + paymentId);
        return true;
    }
    
    public String getPaymentStatus(int paymentId) {
        System.out.println("Fetching payment status for Payment ID: " + paymentId);
        return "Completed";
    }
    
}
