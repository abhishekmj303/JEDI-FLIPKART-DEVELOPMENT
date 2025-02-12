package com.flipkart.bean;

public class FlipFitSlot {
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
	 * @return the centerId
	 */
	public int getCenterId() {
		return centerId;
	}

	/**
	 * @param centerId the centerId to set
	 */
	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}

	/**
	 * @return the slotInfo
	 */
	public String getSlotInfo() {
		return slotInfo;
	}

	/**
	 * @param slotInfo the slotInfo to set
	 */
	public void setSlotInfo(String slotInfo) {
		this.slotInfo = slotInfo;
	}

	/**
	 * @return the availableSeats
	 */
	public int getAvailableSeats() {
		return availableSeats;
	}

	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	private int id;
    private int centerId;
    private String slotInfo;
    private int availableSeats;

    public FlipFitSlot(int id, int centerId, String slotInfo, int availableSeats) {
        this.id = id;
        this.centerId = centerId;
        this.slotInfo = slotInfo;
        this.availableSeats = availableSeats;
    }
}
