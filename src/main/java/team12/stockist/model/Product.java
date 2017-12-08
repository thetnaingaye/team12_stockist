package team12.stockist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product 
{
	
	@Id
	private int PartID;
	
	@Column(name="Description")
	private String description;
	
	private double UnitPrice;
	private String Color;
	private String Dimension;
	private String Manufacturer;
	private int ReorderLevel;
	private int MinReorderQty;
	private String ShelfLocation;
	private String SupplierID;
	private int UnitsInStock;
	private int UnitsOnOrder;
	private int Discontinued;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int partID, String description, double unitPrice, String color, String dimension,
			String manufacturer, int reorderLevel, int minReorderLevel, String shelfLocation, String supplierID,
			int unitsInStock, int unitsOnOrder, int discontinued) {
		super();
		PartID = partID;
		this.description = description;
		UnitPrice = unitPrice;
		Color = color;
		Dimension = dimension;
		Manufacturer = manufacturer;
		ReorderLevel = reorderLevel;
		MinReorderQty = minReorderLevel;
		ShelfLocation = shelfLocation;
		SupplierID = supplierID;
		UnitsInStock = unitsInStock;
		UnitsOnOrder = unitsOnOrder;
		Discontinued = discontinued;
	}

	public int getPartID() {
		return PartID;
	}

	public void setPartID(int partID) {
		PartID = partID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		UnitPrice = unitPrice;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public String getDimension() {
		return Dimension;
	}

	public void setDimension(String dimension) {
		Dimension = dimension;
	}

	public String getManufacturer() {
		return Manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}

	public int getReorderLevel() {
		return ReorderLevel;
	}

	public void setReorderLevel(int reorderLevel) {
		ReorderLevel = reorderLevel;
	}

	public int getMinReorderQty() {
		return MinReorderQty;
	}

	public void setMinReorderQty(int minReorderLevel) {
		MinReorderQty = minReorderLevel;
	}

	public String getShelfLocation() {
		return ShelfLocation;
	}

	public void setShelfLocation(String shelfLocation) {
		ShelfLocation = shelfLocation;
	}

	public String getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(String supplierID) {
		SupplierID = supplierID;
	}

	public int getUnitsInStock() {
		return UnitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		UnitsInStock = unitsInStock;
	}

	public int getUnitsOnOrder() {
		return UnitsOnOrder;
	}

	public void setUnitsOnOrder(int unitsOnOrder) {
		UnitsOnOrder = unitsOnOrder;
	}

	public int getDiscontinued() {
		return Discontinued;
	}

	public void setDiscontinued(int discontinued) {
		Discontinued = discontinued;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + PartID;
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
		if (PartID != other.PartID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [PartID=" + PartID + ", Description=" + description + ", UnitPrice=" + UnitPrice + ", Color="
				+ Color + ", Dimension=" + Dimension + ", Manufacturer=" + Manufacturer + ", ReorderLevel="
				+ ReorderLevel + ", MinReorderLevel=" + MinReorderQty + ", ShelfLocation=" + ShelfLocation
				+ ", SupplierID=" + SupplierID + ", UnitsInStock=" + UnitsInStock + ", UnitsOnOrder=" + UnitsOnOrder
				+ ", Discontinued=" + Discontinued + "]";
	}
	
	
	

	
}
