/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class FlipFitRole {
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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}
	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	private String roleName;
	
	public FlipFitRole(int id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}
}
