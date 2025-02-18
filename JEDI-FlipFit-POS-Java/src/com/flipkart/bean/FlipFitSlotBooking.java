package com.flipkart.bean;

import java.time.LocalDate;

public class FlipFitSlotBooking {
    private int id;
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
	 * @return the slotId
	 */
	public int getSlotId() {
		return slotId;
	}

	/**
	 * @param slotId the slotId to set
	 */
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the dateTime
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	private int slotId;
    private int customerId;
    private LocalDate date;

    public FlipFitSlotBooking(int id, int slotId, int customerId, LocalDate date) {
        this.id = id;
        this.slotId = slotId;
        this.customerId = customerId;
        this.date = date;
    }
}
