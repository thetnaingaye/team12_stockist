package team12.stockist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "damagerecords")
public class DamageRecord {

	@Id
	@Column(name = "RMAID")
	private int rmaID;
	@Column(name = "Products_PartID")
	private int productPartID;
	@Column(name = "Qty")
	private int qty;
	@Column(name = "DateRecorded")
	private Date dateRecorded;
	@Column(name = "Remarks")
	private String remarks;

	// Table Relationship here using Javax.Persistence library. Do we need to write?

	// Constructors
	public DamageRecord(int rmaID, int productPartID, int qty, Date dateRecorded, String remarks) {
		super();
		this.rmaID = rmaID;
		this.productPartID = productPartID;
		this.qty = qty;
		this.dateRecorded = dateRecorded;
		this.remarks = remarks;
	}

	public DamageRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters and Setters
	public int getRmaID() {
		return rmaID;
	}

	public void setRmaID(int rmaID) {
		this.rmaID = rmaID;
	}

	public int getProductPartID() {
		return productPartID;
	}

	public void setProductPartID(int productPartID) {
		this.productPartID = productPartID;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Date getDateRecorded() {
		return dateRecorded;
	}

	public void setDateRecorded(Date dateRecorded) {
		this.dateRecorded = dateRecorded;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	// hashCode() and equals()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getOuterType().hashCode();
		result = prime * result + rmaID;
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
		DamageRecord other = (DamageRecord) obj;
		if (!getOuterType().equals(other.getOuterType()))
			return false;
		if (rmaID != other.rmaID)
			return false;
		return true;
	}

	private DamageRecord getOuterType() {
		return DamageRecord.this;
	}

}
