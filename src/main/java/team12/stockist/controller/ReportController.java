package team12.stockist.controller;

import static org.mockito.Matchers.floatThat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.New;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team12.stockist.model.Product;
import team12.stockist.model.Supplier;
import team12.stockist.service.ProductService;
import team12.stockist.service.SupplierService;

@RequestMapping(value = "/admin/print/")
@Controller
public class ReportController {

	@Autowired
	ProductService productService;

	@Autowired
	SupplierService supplierService;

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView printReport() {
		ModelAndView modelAndView = new ModelAndView("display-report");
		ArrayList<Supplier> supplierList = supplierService.findAll();
		HashMap<Supplier, ArrayList<Product>> orderListMap = getOrderList(supplierList);

		modelAndView.addObject("orderListMap", orderListMap);
		modelAndView.addObject("supplierList", supplierList);

		return modelAndView;
	}

	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public ModelAndView outputReport() {
		ModelAndView modelAndView = new ModelAndView();

		ArrayList<Supplier> supplierList = supplierService.findAll();
		HashMap<Supplier, ArrayList<Product>> orderListMap = getOrderList(supplierList);
		for (Map.Entry<Supplier, ArrayList<Product>> entry : orderListMap.entrySet()) {
			double totalPrice = 0;
			ArrayList<Product> productList = entry.getValue();
			String supplierId = entry.getKey().getSupplierID();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date = sdf.format(new Date());
			String filename = "C:\\JavaCaReport\\"+date+"-"+supplierId+"-ReorderReport.dat";
			try {
				PrintWriter out = new PrintWriter(new File(filename));
				out.println("\t\t\tInventory Reorder Report for Supplier " + supplierId);
				out.println("\t\t\t-------------------------------------------");
				out.println("=======================================================================\t\t\t");
				out.println("Part No.  Unit.Price  Qty  Reorder Qty.  Min.Ord.Qty  Ord.Qty  Price");
				out.println("=======================================================================\t\t\t");
				for (Product p : productList) {
					out.println(String.format("%04d", p.getPartID()) + "\t\t" + p.getUnitPrice() + "\t  "
							+ p.getUnitsInStock() + "\t\t\t" + (p.getReorderLevel() + "\t\t\t" + p.getMinReorderQty() + "\t\t"
									+ p.getUnitsOnOrder() + "\t\t" + p.getUnitsOnOrder() * p.getUnitPrice()));
					totalPrice += p.getUnitsOnOrder() * p.getUnitPrice();
				}
				out.println("=======================================================================\t\t\t");
				out.println("                                          TOTAL                " + totalPrice);
				out.println("=======================================================================\t\t\t");
				out.print("\t\t\t\t\t\t End of Report");
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		modelAndView.setViewName("redirect:/admin/print/report");

		return modelAndView;
	}

	private HashMap<Supplier, ArrayList<Product>> getOrderList(ArrayList<Supplier> supplierList) {

		HashMap<Supplier, ArrayList<Product>> orderListMap = new HashMap<Supplier, ArrayList<Product>>();
		for (Supplier supplier : supplierList) {
			ArrayList<Product> supplierProductList = productService.findProductBySupplier(supplier.getSupplierID());
			if (supplierProductList.size() > 0)
				orderListMap.put(supplier, supplierProductList);

		}

		return orderListMap;

	}

}
