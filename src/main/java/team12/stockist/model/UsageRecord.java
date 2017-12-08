package team12.stockist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "usagerecords")
public class UsageRecord {
	
	@Id
	@Column (name = "TransID")
	private int transID;
	@Column (name = "CustomerName")
	private String customerName;
	@Column (name = "DateUsed")
	private Date dateUsed;
	@Column (name = "UserID")
	private int userId;
	
	
	//Constructors
	public UsageRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsageRecord(int transID, String customerName, Date dateUsed, int userId) {
		super();
		this.transID = transID;
		this.customerName = customerName;
		this.dateUsed = dateUsed;
		this.userId = userId;
	}
	
	//Getters and Setters
	public int getTransID() {
		return transID;
	}
	public void setTransID(int transID) {
		this.transID = transID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getDateUsed() {
		return dateUsed;
	}
	public void setDateUsed(Date dateUsed) {
		this.dateUsed = dateUsed;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	//hashCode and equals (for TransId only)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + transID;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsageRecord other = (UsageRecord) obj;
		if (transID != other.transID)
			return false;
		return true;
	}
	
	
	
}
