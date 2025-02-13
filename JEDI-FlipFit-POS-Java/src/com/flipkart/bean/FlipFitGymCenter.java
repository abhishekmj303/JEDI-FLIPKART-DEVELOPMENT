package com.flipkart.bean;

import java.sql.Time;

public class FlipFitGymCenter {

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the seatsPerHour
	 */
	public int getSeatsPerHour() {
		return seatsPerHour;
	}

	/**
	 * @param seatsPerHour the seatsPerHour to set
	 */
	public void setSeatsPerHour(int seatsPerHour) {
		this.seatsPerHour = seatsPerHour;
	}

	/**
	 * @return the startTimeMorning
	 */
	public Time getStartTimeMorning() {
		return startTimeMorning;
	}

	/**
	 * @param startTimeMorning the startTimeMorning to set
	 */
	public void setStartTimeMorning(Time startTimeMorning) {
		this.startTimeMorning = startTimeMorning;
	}

	/**
	 * @return the endTimeMorning
	 */
	public Time getEndTimeMorning() {
		return endTimeMorning;
	}

	/**
	 * @param endTimeMorning the endTimeMorning to set
	 */
	public void setEndTimeMorning(Time endTimeMorning) {
		this.endTimeMorning = endTimeMorning;
	}

	/**
	 * @return the startTimeEvening
	 */
	public Time getStartTimeEvening() {
		return startTimeEvening;
	}

	/**
	 * @param startTimeEvening the startTimeEvening to set
	 */
	public void setStartTimeEvening(Time startTimeEvening) {
		this.startTimeEvening = startTimeEvening;
	}

	/**
	 * @return the endTimeEvening
	 */
	public Time getEndTimeEvening() {
		return endTimeEvening;
	}

	/**
	 * @param endTimeEvening the endTimeEvening to set
	 */
	public void setEndTimeEvening(Time endTimeEvening) {
		this.endTimeEvening = endTimeEvening;
	}

	/**
	 * @return the isApproved
	 */
	public boolean isApproved() {
		return isApproved;
	}

	/**
	 * @param isApproved the isApproved to set
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	private int id;
    private String name;
    private String address;
    private String city;
    private int seatsPerHour;
    private Time startTimeMorning;
    private Time endTimeMorning;
    private Time startTimeEvening;
    private Time endTimeEvening;
    private boolean isApproved;
    
	public FlipFitGymCenter(int id, String name, String address, String city, int seatsPerHour, Time startTimeMorning,
			Time endTimeMorning, Time startTimeEvening, Time endTimeEvening) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.seatsPerHour = seatsPerHour;
		this.startTimeMorning = startTimeMorning;
		this.endTimeMorning = endTimeMorning;
		this.startTimeEvening = startTimeEvening;
		this.endTimeEvening = endTimeEvening;
	}

}
