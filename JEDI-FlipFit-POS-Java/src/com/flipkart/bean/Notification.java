package com.flipkart.bean;

import java.time.LocalDateTime;

public class Notification {
    private int id;
    private int userId;
    private String message;
    private LocalDateTime dateTime;
    private boolean isRead;

    public Notification(int id, int userId, String message, LocalDateTime dateTime, boolean isRead) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.dateTime = dateTime;
        this.isRead = isRead;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getMessage() { return message; }
    public LocalDateTime getDateTime() { return dateTime; }
    public boolean isRead() { return isRead; }

    public void markAsRead() { this.isRead = true; }
}
