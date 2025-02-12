package com.flipkart.business;

import com.flipkart.bean.Notification;

public class NotificationBusiness {

    public void sendNotification(Notification notification) {
        System.out.println("Notification sent to user ID " + notification.getUserId());
        System.out.println("Message: " + notification.getMessage());
        System.out.println("Date: " + notification.getDateTime());
    }

    public void markAsRead(int notificationId) {
        System.out.println("Notification ID " + notificationId + " marked as read.");
    }

    public void listAllNotificationsForUser(int userId) {
        System.out.println("Listing notifications for user with ID: " + userId);
    }
}
