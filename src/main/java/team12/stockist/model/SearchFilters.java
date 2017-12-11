package team12.stockist.model;

import java.util.ArrayList;

public class SearchFilters {
	
	private ArrayList<String> colorFilters;
	private ArrayList<String> manufacturerFilters;
	
	
	public ArrayList<String> getColorFilters() {
		return colorFilters;
	}
	public void setColorFilters(ArrayList<String> colorFilters) {
		this.colorFilters = colorFilters;
	}
	public ArrayList<String> getManufacturerFilters() {
		return manufacturerFilters;
	}
	public void setManufacturerFilters(ArrayList<String> manufacturerFilters) {
		this.manufacturerFilters = manufacturerFilters;
	}
	
}
