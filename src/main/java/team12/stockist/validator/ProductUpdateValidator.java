package team12.stockist.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import team12.stockist.model.Product;



@Component
public class ProductUpdateValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> arg0) 
	{
		// TODO Auto-generated method stub
		return Product.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) 
	{
		// TODO Auto-generated method stub
		
		
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "partID" , "error.productId", "PartID is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "description" , "error.productName", "Description is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "unitPrice" , "error.productUnitPrice", "Unit price is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "color" , "error.productColor", "Color is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "dimension" , "error.productDimension", "Dimension is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "manufacturer" , "error.productManufacturer", "Manufacturer is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "reorderLevel" , "error.productReorderLevel", "Reorder Level is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "minReorderQty" , "error.productReorderQuantity", "Minimum Reorder Quantity is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "shelfLocation" , "error.productShelLocation", "Shelf Location is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "supplierID" , "error.productSupplierID", "SupplierID is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "unitsOnOrder" , "error.productQuantity", "Quantity is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "unitsInStock" , "UnitsInStock is required", "UnitsInStock is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "discontinued" , "error.productQuantity", "Discontinue status  is required");
		
			
		
		
		
		
			
		}
}
		
		
		
	
