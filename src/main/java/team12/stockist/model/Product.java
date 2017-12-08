package team12.stockist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product 
{
	
	@Id
	@Column(name="PartID")
	private int partID;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="UnitPrice")
	private double unitPrice;
	
	@Column(name="Color")
	private String color;
	
	@Column(name="Dimension")
	private String dimension;
	
	@Column(name="Manufacturer")
	private String manufacturer;
	
	@Column(name="ReorderLevel")
	private int reorderLevel;
	
	@Column(name="MinReorderQty")
	private int minReorderQty;
	
	@Column(name="ShelfLocation")
	private String shelfLocation;
	
	@Column(name="SupplierID")
	private String supplierID;
	
	@Column(name="UnitsInStock")
	private int unitsInStock;
	
	@Column(name="UnitsOnOrder")
	private int unitsOnOrder;
	
	@Column(name="Discontinued")
	private int discontinued;
	
	//Table relationship do we need to write?
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int partID, String description, double unitPrice, String color, String dimension,
			String manufacturer, int reorderLevel, int minReorderLevel, String shelfLocation, String supplierID,
			int unitsInStock, int unitsOnOrder, int discontinued) {
		super();
		this.partID = partID;
		this.description = description;
		this.unitPrice = unitPrice;
		this.color = color;
		this.dimension = dimension;
		this.manufacturer = manufacturer;
		this.reorderLevel = reorderLevel;
		this.minReorderQty = minReorderLevel;
		this.shelfLocation = shelfLocation;
		this.supplierID = supplierID;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.discontinued = discontinued;
	}

	public int getPartID() {
		return partID;
	}

	public void setPartID(int partID) {
		this.partID = partID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public int getMinReorderQty() {
		return minReorderQty;
	}

	public void setMinReorderQty(int minReorderLevel) {
		this.minReorderQty = minReorderLevel;
	}

	public String getShelfLocation() {
		return shelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public int getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(int unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public int getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(int discontinued) {
		this.discontinued = discontinued;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + partID;
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
		Product other = (Product) obj;
		if (partID != other.partID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [PartID=" + partID + ", Description=" + description + ", UnitPrice=" + unitPrice + ", Color="
				+ color + ", Dimension=" + dimension + ", Manufacturer=" + manufacturer + ", ReorderLevel="
				+ reorderLevel + ", MinReorderLevel=" + minReorderQty + ", ShelfLocation=" + shelfLocation
				+ ", SupplierID=" + supplierID + ", UnitsInStock=" + unitsInStock + ", UnitsOnOrder=" + unitsOnOrder
				+ ", Discontinued=" + discontinued + "]";
	}
	
	
	

	
}
