/**
 * 
 */
package com.globant.EMS.models;

/**
 * @author mayuri.shinde
 *
 */
public class User {
	private String userId;
	private String userName;
	private String email;
	private double mobile;

	public User() {
	}

	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public double getMobile() {
		return mobile;
	}


	public void setMobile(double mobile) {
		this.mobile = mobile;
	}


//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
//		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(salary);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee other = (Employee) obj;
//		if (designation == null) {
//			if (other.designation != null)
//				return false;
//		} else if (!designation.equals(other.designation))
//			return false;
//		if (empId == null) {
//			if (other.empId != null)
//				return false;
//		} else if (!empId.equals(other.empId))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
//			return false;
//		return true;
//	}

}
