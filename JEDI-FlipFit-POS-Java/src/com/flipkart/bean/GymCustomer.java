package com.flipkart.bean;

public class GymCustomer extends User {
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

	private String preferredCity;

    public GymCustomer(int id, String name, String email, String password, String preferredCity) {
        super(id, name, email, password, "CUSTOMER");
        this.preferredCity = preferredCity;
    }
}
