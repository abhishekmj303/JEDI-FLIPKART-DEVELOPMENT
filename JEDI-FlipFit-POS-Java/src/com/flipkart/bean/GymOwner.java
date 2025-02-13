package com.flipkart.bean;
import java.util.Date;
public class GymOwner extends User {
    
    private Date morningStartTime;
    private Date morningEndTime;
    private Date eveningStartTime;
    private Date eveningEndTime;

    public GymOwner(int id, String name, String email, String password, 
                    Date morningStartTime, Date morningEndTime, 
                    Date eveningStartTime, Date eveningEndTime) {
        super(id, name, email, password, "GYM_OWNER");
        this.morningStartTime = morningStartTime;
        this.morningEndTime = morningEndTime;
        this.eveningStartTime = eveningStartTime;
        this.eveningEndTime = eveningEndTime;
    }
    // Getter setters function for getting the date and times
    public Date getMorningStartTime() { return morningStartTime; }
    public void setMorningStartTime(Date morningStartTime) { this.morningStartTime = morningStartTime; }

    public Date getMorningEndTime() { return morningEndTime; }
    public void setMorningEndTime(Date morningEndTime) { this.morningEndTime = morningEndTime; }

    public Date getEveningStartTime() { return eveningStartTime; }
    public void setEveningStartTime(Date eveningStartTime) { this.eveningStartTime = eveningStartTime; }

    public Date getEveningEndTime() { return eveningEndTime; }
    public void setEveningEndTime(Date eveningEndTime) { this.eveningEndTime = eveningEndTime; }


}
