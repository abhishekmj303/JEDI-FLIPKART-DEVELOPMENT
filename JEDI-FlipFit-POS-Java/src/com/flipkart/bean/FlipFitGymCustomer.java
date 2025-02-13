package com.flipkart.bean;

public class FlipFitGymCustomer {
    /**
	 * @return the preferredCity
	 */
	public String getPreferredCity() {
		return preferredCity;
	}

	/**
	 * @param preferredCity the preferredCity to set
	 */
	public void setPreferredCity(String preferredCity) {
		this.preferredCity = preferredCity;
	}

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

	private int id;
	private String preferredCity;

    public FlipFitGymCustomer(int id) {
        this.id = id;
    }
}
