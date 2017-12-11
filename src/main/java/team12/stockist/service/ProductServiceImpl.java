package team12.stockist.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import team12.stockist.model.Product;
import team12.stockist.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductRepository prepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see team12.stockist.service.ProductService#findAllProduct()
	 */
	@Override
	@Transactional
	public ArrayList<Product> findAllProduct() {
		ArrayList<Product> sl = (ArrayList<Product>) prepo.findAll();
		return sl;
	}

	@Override
	@Transactional
	public Product findProductById(Integer productId) {
		return prepo.findOne(productId);
	}

	@Override
	@Transactional
	public Product createProduct(Product product) {
		return prepo.saveAndFlush(product);
	}

	@Override
	@Transactional
	public Product updateProduct(Product product) {
		return prepo.saveAndFlush(product);
	}

	@Override
	@Transactional
	public void deleteProduct(Product product) {
		prepo.delete(product);

	}

	@Override
	@Transactional
	public ArrayList<Product> findProductBySupplier(String supplierID) {
		return prepo.findProductBySupplier(supplierID);
	}
	
	
	
	
	
	
	@Override
	@Transactional
	public ArrayList<Product> findAllProductByFilter(ArrayList<String> mfrFilters)         
	{
		String temp = mfrFilters.get(0);
		ArrayList<Product> output = (ArrayList<Product>) prepo.findAllByFilter(temp);
		
		// If there are more than one filters
		if (mfrFilters.size() >= 1)
		{
			for (int i = 1; i < mfrFilters.size(); i++) {
				
				temp = mfrFilters.get(i);
				output.addAll((ArrayList<Product>) prepo.findAllByFilter(temp));
			}
			
			try   // Remove any repeated entries
			{
				output = DuplicateRemover(output);
			}
			catch(NullPointerException e)
	        {
	            System.out.print("NullPointerException caught");
	        }
		}
		
		return output;
	}
	
	
	
	
	

	
	
	
	


	
	
	
	//-------------------- SEARCH --------------------------//

	@Override
	@Transactional        // General search without filters
	public ArrayList<Product> searchProduct(String input)
	{
		ArrayList<Product> output;
		input = StringConversion(input);
		
		// Check if user input is an integer
		boolean checkInt = isInteger(input);
		
		
		if (checkInt)
		{
			output = (ArrayList<Product>) prepo.searchAllPartID(input);
			return output;
		}
		else
		{
			output = (ArrayList<Product>) prepo.searchAllDescription(input);
			output.addAll((ArrayList<Product>) prepo.searchAllColor(input));
			output.addAll((ArrayList<Product>) prepo.searchAllManufacturer(input));
			output.addAll((ArrayList<Product>) prepo.searchAllShelfLocation(input));
			output.addAll((ArrayList<Product>) prepo.searchSupplierName(input));
			
			output = DuplicateRemover(output);
			return output;
		}
	}


	@Override
	@Transactional        // Advanced Search - Using filters
	public ArrayList<Product> searchProductByFilters(String input, ArrayList<String> mfrFilters)
	{
		ArrayList<Product> output = null;
		input = StringConversion(input);
		String tempA = mfrFilters.get(0);
		
		// Check if user input is an integer
		boolean checkInt = isInteger(input);
		
		if (checkInt)
		{
			output = (ArrayList<Product>) prepo.searchAllPartIDByFilterManufacturer(input, tempA);
			
			if (mfrFilters.size() >= 1)
			{
				for (int i = 1; i < mfrFilters.size(); i++) {
					
					tempA = mfrFilters.get(i);
					output.addAll((ArrayList<Product>) prepo.searchAllPartIDByFilterManufacturer(input, tempA));
				}
			}
		}
		else
		{
			output = (ArrayList<Product>) prepo.searchAllDescriptionByFilterManufacturer(input, tempA);
			output.addAll((ArrayList<Product>) prepo.searchAllColorByFilterManufacturer(input, tempA));
			output.addAll((ArrayList<Product>) prepo.searchAllShelfLocationByFilterManufacturer(input, tempA));
			output.addAll((ArrayList<Product>) prepo.searchSupplierNameByFilterManufacturer(input, tempA));
			
			if (mfrFilters.size() >= 1)
			{
				for (int i = 1; i < mfrFilters.size(); i++) {
					
					tempA = mfrFilters.get(i);
					output.addAll((ArrayList<Product>) prepo.searchAllDescriptionByFilterManufacturer(input, tempA));
					output.addAll((ArrayList<Product>) prepo.searchAllColorByFilterManufacturer(input, tempA));
					output.addAll((ArrayList<Product>) prepo.searchAllShelfLocationByFilterManufacturer(input, tempA));
					output.addAll((ArrayList<Product>) prepo.searchSupplierNameByFilterManufacturer(input, tempA));
				}
			}
		}
		
		try
		{
			output = DuplicateRemover(output);
		}
		catch(NullPointerException e)
        {
            System.out.print("NullPointerException caught");
        }
		return output;
	}
	
	
	
	
	
	
	//-------------------- SUPPORT METHODS --------------------------//
	
	// Making any given string to be easily manipulated and managed
	private static String StringConversion(String x) {
		// Converts input into lower chars and trims any spaces behind and back
		String y = x.toLowerCase().trim();
		y = y.replaceAll("\\s", ""); // Removing all whitespaces no matter where it is.
		return y;
	}
	// Checking if input is an integer
	private static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			// If can be parse, input is an integer
			return true;
		} catch (NumberFormatException ex) {
			// If exception is caught, then input is not an integer.
			return false;
		}
	}
	// Removes duplicate entries [Separate into two methods, cos the Arraylist will have to be cycled through two 
		// times for any duplicate entries to be completely removed. If you want to know why exactly this is so, ask me :) ]
	private ArrayList<Product> DuplicateRemover(ArrayList<Product> ipt)
	{
		ipt = RemoverProcesses(ipt);
		ipt = RemoverProcesses(ipt);
		return ipt;
	}
	private ArrayList<Product> RemoverProcesses(ArrayList<Product> ipt)
	{
		int temp1;
		int temp2;
		for (int i = 0; i < ipt.size(); i++) {
			temp1 = ipt.get(i).getPartID();
			
			for (int j = i + 1; j < ipt.size(); j++) {
				temp2 = ipt.get(j).getPartID();
				
				if (temp1 == temp2)
				{
					System.out.println(temp1);
					System.out.println(temp2);
					ipt.remove(j);
				}
			}
		}
		return ipt;
	}


}
